package jdbc2;
import lombok.Data;

@Data
class User {
	private String username;
	private String password;
	private String name;
	private String email;
	private int birthYear;

	public User() {}
	public User(String username, String password, String name, String email, int birthYear) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.birthYear = birthYear;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
}
