package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class XCI1SelectExample {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private static final String USER = "ace";
	private static final String PASSWORD = "ace";

	public static void main(String[] args) {
		String selectSQL = 
				"""
		        select 
		           name, 
		           korean, 
		           eng, 
		           math, 
		           phil,
		           total,
		           avg
		        from school
		  		""";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSQL)) {

			while (rs.next()) {
				String name = rs.getString("name");
		        int korean = rs.getInt("korean");
		        int eng = rs.getInt("eng");
		        int math = rs.getInt("math");
		        int phil = rs.getInt("phil");
		        int total = rs.getInt("total");
		        double avg = rs.getDouble("avg");
		        				
				System.out.println("name: " + name + ", korean: " + korean + ", eng: " + eng
						+ ", math: " + math + ", phil: " + phil + ", total: " + total + ", avg: " + avg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
