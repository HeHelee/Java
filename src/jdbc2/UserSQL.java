package jdbc2;

public class UserSQL {
	public static final String INSERT_USER = """
			INSERT INTO XCI_MEMBERS (USERNAME, PASSWORD, NAME, EMAIL, BIRTH, JOIN_DATE) VALUES (?, ?, ?, ?, ?, SYSDATE)
			""";

	public static final String GET_USER = """

			SELECT USERNAME, PASSWORD, NAME, EMAIL, BIRTH
			FROM   XCI_MEMBERS
			WHERE  USERNAME = ? AND PASSWORD = ?
			""";

	public static final String UPDATE_SQL = """

			   UPDATE XCI_MEMBERS SET
			PASSWORD = ?
			   WHERE USERNAME = ?
			   """;

	public static final String DELETE_SQL = """
			DELETE FROM XCI_MEMBERS WHERE USERNAME = ?
			""";
	
	public static final String SELECT_SQL = """
			SELECT USERNAME, NAME, EMAIL, BIRTH FROM XCI_MEMBERS WHERE USERNAME = ?
			""";
}
