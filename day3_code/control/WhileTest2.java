package day3_code.control;

import java.util.Scanner;

public class WhileTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가위바위보 게임을 할거에요. (0은 종료,가위는 1번, 바위는 2번, 보는 3번을 입력해주세요.)");

		while (true) {
			int human = sc.nextInt();

			// 종료 조건
			if (human == 0) {
				System.out.println("종료");
				break;
			}
			if (human < 1 || human > 3) {
				System.out.println("범위를 벗어났습니다.");
				break;
			}

			int com = (int) (Math.random() * 3) + 1;

			if (human == com) {
				System.out.println("비겼습니다.");
			} else if (human == 1 && com == 3 || human == 2 && com == 1 || human == 3 && com == 2) {
				System.out.println("이겼습니다.");
			} else {
				System.out.println("졌습니다.");
			}

		}
	}

}
