package day2_code.operation;

import java.util.Scanner;

public class OpTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // System.in 표준 입력을 의미함.
		System.out.print("a : "); int a = sc.nextInt();
		System.out.print("b : "); int b = sc.nextInt();
		
		System.out.println(a > b);
		System.out.println(a >= b);
		System.out.println(a < b);
		System.out.println(a <= b);
		System.out.println(a == b);
		System.out.println(a != b);

	}
}
