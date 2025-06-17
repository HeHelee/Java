package day2_code.operation;

import java.util.Scanner;

public class OpTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // System.in 표준 입력을 의미함.
		System.out.print("a : "); int a = sc.nextInt();
		System.out.print("b : "); int b = sc.nextInt();

		System.out.println(a + "+" + b + "=" + (a + b));
		System.out.println(a + "-" + b + "=" + (a - b));
		System.out.println(a + "*" + b + "=" + (a * b));
		System.out.println(a + "/" + b + "=" + (a / (double) b)); // 정수와 정수의 연산 결과는 정수
		System.out.println(a + "%" + b + "=" + (a % b)); // 괄호 안치면 문자 나옴.
		sc.close();
		System.out.println("종료");

	}

}
