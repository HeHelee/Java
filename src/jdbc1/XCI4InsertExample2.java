package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class XCI4InsertExample2 {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private static final String USER = "ace";
	private static final String PASSWORD = "ace";

	public static void main(String[] args) {
		
		// 조회 구문
		String selectSQL = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID FROM DEPARTMENTS";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSQL)) {

			while (rs.next()) {
				int department_id1 = rs.getInt("DEPARTMENT_ID");
				String department_name = rs.getString("DEPARTMENT_NAME");
				int manager_id = rs.getInt("MANAGER_ID");
				int location_id = rs.getInt("LOCATION_ID");

				System.out.println("DEPARTMENT_ID: " + department_id1 + ", DEPARTMENT_NAME: " + department_name
						+ ", MANAGER_ID: " + manager_id + ", LOCATION_ID: " + location_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 변수
	    String name = null;
	    int salary = 0;
	    String job_id = null;
	    double commission_pct = 0.0;
	    int department_id = 0;
		
	    //입력 부분
		try (Scanner sc = new Scanner(System.in);) {
			System.out.print("LAST_NAME : ");
			name = sc.nextLine();
			System.out.print("SALARY : ");
			salary = sc.nextInt();
			sc.nextLine();
			System.out.print("JOB_ID : ");
			job_id = sc.nextLine();
			System.out.print("COMMISSION_PCT : ");
			commission_pct = sc.nextDouble();
			System.out.print("DEPARTMENT_ID : ");
			department_id = sc.nextInt();
		}catch (Exception e) {
			e.printStackTrace();
		}
		

		// 삽입 구문
		String insertSQL = "INSERT INTO EMP_TEMP (LAST_NAME, SALARY, JOB_ID, COMMISSION_PCT, DEPARTMENT_ID) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

			pstmt.setString(1, name);
			pstmt.setInt(2, salary);
			pstmt.setString(3, job_id);
			pstmt.setDouble(4, commission_pct);
			pstmt.setInt(5, department_id);

			int rowsInserted = pstmt.executeUpdate(); // 반영된 레코드의 개수가 리턴이 됨.
			if (rowsInserted > 0) {
				System.out.println("입력 되었습니다!");
			} else {
				System.out.println("입력된 행이 없습니다.");
			}
		} catch (SQLException e) {
			if (e.getErrorCode() == 2291) {
				System.out.println("잘못된 부서 번호 입니다.");
			} else {
				System.out.println("SQL 오류 코드 : " + e.getErrorCode());
				e.printStackTrace();
			}

		}

	}
}