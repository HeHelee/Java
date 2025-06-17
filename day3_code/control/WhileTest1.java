package day3_code.control;

public class WhileTest1 {

	public static void main(String[] args) {
		/*
		for (int n = 1; n <= 3; n++) {
			System.out.println((n*10)+":"+"sysone");
		}
		*/
		int n = 1;
		int sum = 0;
		while (n <= 1000) {
		if (n % 3 == 0) {
			sum += n;
		   }
		n++;
		}
		System.out.println(sum);
		System.out.println("종료");

	}

}
