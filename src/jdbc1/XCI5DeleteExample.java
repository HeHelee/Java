package jdbc1; 
import java.sql.*;
import java.util.Scanner; 
 
public class XCI5DeleteExample { 
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xepdb1"; 
    private static final String USER = "ace"; 
    private static final String PASSWORD = "ace"; 
 
    public static void main(String[] args) { 
    	Scanner sc = new Scanner(System.in);
    	System.out.print("이름을 입력해주세요 : ");
    	String last_name = sc.nextLine();
    	
        String deleteSQL = "DELETE emp_temp WHERE LAST_NAME = ?"; 
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); 
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) { 
 
            pstmt.setString(1, last_name); 
 
            int rowsDeleted = pstmt.executeUpdate(); //원본 데이터 변경 (삭제 됬는지 아닌지 확인)
            if (rowsDeleted > 0) { 
                System.out.println("삭제 되었습니다!"); 
            } else { 
             System.out.println("삭제된 행이 없습니다."); 
            } 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
}