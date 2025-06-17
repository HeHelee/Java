package day3_code.control;

import java.util.Scanner;

public class SwichTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    System.out.print("점수 입력: ");
		int score = sc.nextInt();
		switch (score / 10) {
		case 10,9 -> System.out.println("A");
		case 8 -> System.out.println("B");
		case 7 -> System.out.println("C");
		case 6 -> System.out.println("D");
		default-> System.out.println("F");
		}
		System.out.println("종료");
	}
}
