package jdbc2;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
/*
 1. Singleton & DB Connection - getInstance, getConnection
 2. create - signUp
 3. retrieve - getUser, ... userInfo, findById
 // 싱글톤으로 만드는 게 좋음. 상태값을 저장하지도 않고 공유하지도 않기 때문에
 */

public class UserDAO {
	private final String url;
	private final String dbUser;
	private final String dbPassword;

	// 1. Singleton & DB Connection
	// ----------------------------
	private static UserDAO instance;

	private UserDAO() {

		Properties props = new Properties();
		try (InputStream in = ClassLoader.getSystemResourceAsStream("jdbc2/db.properties");
				InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
			props.load(reader);
			url = props.getProperty("db.url");
			dbUser = props.getProperty("db.user");
			dbPassword = props.getProperty("db.password");
		} catch (Exception e) {
			throw new RuntimeException("접속정보가 없거나 잘못됨 ..." + e.getMessage());
		}
	}

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, dbUser, dbPassword);
	}

	// 2. create - signUp
	// ----------------------------
	public void signUp(User user) throws SQLException {
		String insertSQL = UserSQL.INSERT_USER;
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.setInt(5, user.getBirthYear());

			pstmt.executeUpdate();

		}

	}

	// 3. retrieve
	public User getUser(String username, String password) throws SQLException {
		String loginSQL = UserSQL.GET_USER;
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(loginSQL)) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new User(username, password, rs.getString("NAME"), rs.getString("EMAIL"), rs.getInt("BIRTH"));
			}

		}
		throw new RuntimeException(MessageUtil.get("error.login.invalid"));
		// 임시로 시스템 에러메시지 확인을 위함.
		// return null;
	}

	public int updatePassword(String username, String newPassword) throws SQLException {
		String updateSQL = UserSQL.UPDATE_SQL;
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

			pstmt.setString(1, newPassword);
			pstmt.setString(2, username);
			return pstmt.executeUpdate();
		}
	}

	public boolean deleteByUsername(String username) throws SQLException {
		String deleteSQL = UserSQL.DELETE_SQL;
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {

			pstmt.setString(1, username);

			int rowsDeleted = pstmt.executeUpdate();
			return rowsDeleted > 0;

		}

	}

	public User findByUsername(String username) throws SQLException {
	    String searchSQL = UserSQL.SELECT_SQL;
	    try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(searchSQL)) {
	        System.out.println(">>> 실행된 쿼리: " + searchSQL);
	        System.out.println(">>> 검색할 username: " + username);

	        pstmt.setString(1, username);

	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            return new User(rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("NAME"),
	                    rs.getString("EMAIL"), rs.getInt("BIRTH"));
	        } else {
	            System.out.println(">>> 결과 없음 (rs.next() = false)");
	        }
	        return null;
	    }
	}

}
