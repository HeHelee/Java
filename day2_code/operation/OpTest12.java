package day2_code.operation;

import java.util.Scanner;

public class OpTest12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = -5;
		
		// 나머지 연산 주의 !! 음수값을 나머지 연산 적용시 반드시 절대값을 먼저 취해야 함!
		System.out.println(Math.abs(a) % 2 == 1? "홀수입니다." : "짝수입니다.");
	
	}

}