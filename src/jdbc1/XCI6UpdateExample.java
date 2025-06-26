package jdbc1; 
import java.sql.*; 
 
public class XCI6UpdateExample { 
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xepdb1"; 
    private static final String USER = "ace"; 
    private static final String PASSWORD = "ace"; 
 
    public static void main(String[] args) { 
        String updateSQL = "UPDATE XCI_MEMBERS SET NAME = ? WHERE USERNAME = ?"; 
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); // commit을 하던지 rollback을 하던지 함.
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) { //쿼리를 오라클 서버에 던져줌.
            pstmt.setString(1, "장10"); 
            pstmt.setString(2, "z10"); 
            int rowsUpdated = pstmt.executeUpdate(); //레코드의 개수 반환
            if (rowsUpdated > 0) { 
                System.out.println("수정되었습니다!"); 
            } else { 
             System.out.println("수정된 행이 없습니다."); 
            } 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
} 
 