package jdbc2;

import java.sql.SQLException;

public class UserService {
	private static final UserDAO userDAO = UserDAO.getInstance();
	private static UserService instance;

	private UserService() {
	}

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	public boolean signUp(User user) {
		try {
			userDAO.signUp(user);
			return true;
		} catch (Exception e) {
			System.out.println("$$ 회원가입 실패 : " + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	public User login(String username, String password) {
		try {
			return userDAO.getUser(username, password);
		} catch (Exception e) {
			System.out.println("$$$로그인 실패 : " + e.getMessage());
			return null;
		}
	}

	public void updatePassword(String username, String newPassword) throws Exception {
		try {
			if (newPassword.length() < 3)
				throw new RuntimeException(MessageUtil.get("error.user.password"));
			{
				int result = userDAO.updatePassword(username, newPassword);
				if (result == 1) {
					return;
				} else
					throw new RuntimeException(MessageUtil.get("error.user.password2"));
			}
		} catch (Exception e) {
			System.out.println("$$$패스워드 수정 실패 : " + e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	public boolean deleteUser(String username) {
		try {
			return userDAO.deleteByUsername(username);
		}catch(SQLException e) {
			System.out.println(MessageUtil.get("error.user.delete"));
			return false;
		}
	}
	
	public User searchUser(String username) throws Exception {
	    try {
	        User user = userDAO.findByUsername(username);
	        if (user == null) {
	            // 사용자 없음도 예외 처리하여 호출자에게 메시지 전달
	            throw new Exception(MessageUtil.get("error.user.select"));
	        }
	        return user;
	    } catch (SQLException e) {
	        throw new Exception(MessageUtil.get("error.user.select"), e);
	    }
	}
}
