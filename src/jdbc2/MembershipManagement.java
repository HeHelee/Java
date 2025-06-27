package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MembershipManagement {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private static final String USER = "ace";
	private static final String PASSWORD = "ace";

	private static Scanner sc = new Scanner(System.in);
	private static User loggedInUser = null;

	private static final UserService userService = UserService.getInstance();

	public static void main(String[] args) {
		while (true) {
			System.out.println("----------------");
			System.out.println("0. " + MessageUtil.get("menu.signup"));
			System.out.println("1. " + MessageUtil.get("menu.login"));
			System.out.println("2. " + MessageUtil.get("menu.exit"));
			System.out.println("----------------");
			System.out.print("입력 > ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 0 -> signUp();
			case 1 -> {
				if (login())
					afterLoginMenu();
			}
			case 2 -> System.out.println("프로그램을 종료합니다.");
			default -> System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private static void signUp() {
		System.out.print("id: ");
		String username = sc.nextLine();
		System.out.print("pw: ");
		String password = sc.nextLine();
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("이메일: ");
		String email = sc.nextLine();
		int birthYear;
		birthYear = getNumberInput();

		User user = new User(username, password, name, email, birthYear);

		if (userService.signUp(user)) {
			System.out.println("회원가입 성공.");
		} else {
			System.out.println("회원가입 실패.");
		}

	}

	private static int getNumberInput() {
		do {
			System.out.println("> ");
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능합니다.");
			}
		} while (true);
	}

	private static boolean login() {
		int attempts = 0;
		while (attempts < 3) {
			System.out.print("id: ");
			String username = sc.nextLine();
			System.out.print("pw: ");
			String password = sc.nextLine();

			loggedInUser = userService.login(username, password);
			if (loggedInUser != null) {
				System.out.println("로그인 성공: " + loggedInUser.getName());
				return true;
			} else {
				System.out.println("아이디 혹은 패스워드가 틀립니다.");
				attempts++;
			}
		}
		System.out.println("접속을 종료합니다.");
		return false;
	}

	private static void afterLoginMenu() {
		while (true) {
			System.out.println("----------------");
			System.out.println("0. 자기정보보기 및 수정");
			System.out.println("1. 회원 탈퇴");
			System.out.println("2. 회원 검색");
			System.out.println("3. 로그아웃");
			System.out.println("----------------");
			System.out.print("입력 > ");

			int choice = getNumberInput();

			switch (choice) {
			case 0 -> viewAndUpdateProfile();
			case 1 -> {
				deleteUser();
				loggedInUser = null;
				return;
			}
			case 2 -> searchUser();
			case 3 -> {
				loggedInUser = null;
				return;
			}
			default -> System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private static void viewAndUpdateProfile() {
		System.out.println("아이디: " + loggedInUser.getUsername());
		System.out.println("이름: " + loggedInUser.getName());
		System.out.println("이메일: " + loggedInUser.getEmail());
		System.out.println("생년: " + loggedInUser.getBirthYear());
		System.out.print("비밀번호를 변경하시겠습니까? (y/n) > ");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("y")) {
			System.out.print("새 비밀번호: ");
			String newPassword = sc.nextLine();
			try {
				userService.updatePassword(loggedInUser.getUsername(), newPassword);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void deleteUser() {
		System.out.print("정말로 탈퇴하시겠습니까? (y/n) ");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("y")) {
		   boolean result = userService.deleteUser(loggedInUser.getUsername());
		   if (result) {
			   System.out.println("회원 탈퇴가 완료되었습니다.");
		   }else {
			   System.out.println("회원 탈퇴에 실패했습니다.");
		   }
		}
	}

	private static void searchUser() {
	    System.out.print("검색할 아이디: ");
	    String username = sc.nextLine();

	    try {
	        User user = userService.searchUser(username);
	        if (user != null) {
	            System.out.println("아이디: " + user.getUsername());
	            System.out.println("이름: " + user.getName());
	            System.out.println("비밀번호: " + user.getPassword());
	            System.out.println("이메일: " + user.getEmail());
	            System.out.println("생년: " + user.getBirthYear());
	        } 
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
}



// userDAO - 제어문을 제거하는 것이 좋다.
