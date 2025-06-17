package day3_code.EX01_BreakControlKeyword;

public class BreakControlKeyword {

	public static void main(String[] args) {
		// 단일 반복문 탈출
		for (int i = 0; i < 10; i++) {
			System.out.println();
			break;
		}
		
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();

		//다중 반복문 탈출
		//1개의 반복문만 탈출할 때
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 2) {
					break;
				}
				System.out.println(i + ", " + j);
			}
		}
		System.out.println();
		
		//@break + Label 문으로 다중 반복문 탈출
		POST1: for(int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 2) {
					break POST1;
				}
				System.out.println(i + ", " + j);
			}
		}
		System.out.println();
		
		//@변숫값을 조정해 다중 반복문 탈출
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 2) {
					i = 100;
					break;
				}
				System.out.println(i + ", " + j);
			}
		}
		System.out.println();
	}

}
