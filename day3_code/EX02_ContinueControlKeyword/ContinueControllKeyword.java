package day3_code.EX02_ContinueControlKeyword;

public class ContinueControllKeyword {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			continue;
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");
			continue;
		}
		
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.print(i + " ");
		}
		System.out.println();

		// 다중 반복문에서 continue 사용
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 3) {
					continue;
				}
				System.out.println(i + ", " + j);
			}
		}
		System.out.println();
		
		POST1: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 3) {
					continue POST1;
				}
				System.out.println(i + ", " + j);
			}
		}
	}
	

}
