package day4_code.method;

import java.util.Scanner;

public class ScissorsGame {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) { // try with resources
			System.out.println("가위는 1, 바위는 2, 보는 3을 입력 > ");
			int you = sc.nextInt();
			int com = (int) (Math.random() * 3) + 1;

			System.out.print("You : ");
			printCaption(you);
			System.out.print("Com : ");
			printCaption(com);

			logic(you, com);

		}

	}

	private static void logic(int you, int com) {
		System.out.print("결과는 : ");
		if (you == com) {
			System.out.println("비겼습니다.");
		} else if (you == 1 && com == 3 || you == 2 && com == 1 || you == 3 && com == 2) {
			System.out.println("이겼습니다.");
		} else {
			System.out.println("졌습니다.");
		}

	}

	private static void printCaption(int you) {
		switch (you) {
		case 1:
			System.out.println("가위");
			break;
		case 2:
			System.out.println("바위");
			break;
		case 3:
			System.out.println("보");
			break;
		}
	}

	private static String caption(int val) {
		switch (val) {
		case 1:
			return "가위";
		case 2:
			return "바위";
		case 3:
			return "보";
		default:
			return "에러";
		}
	}
}
