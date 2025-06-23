package day2_code.sec01_operator_1.EX02_BitwiseOperator;

public class BItwiseOperator {

	public static void main(String[] args) {
		//자바 메서드로 진법 변환
		int data = 13;
		System.out.println(Integer.toBinaryString(data));
		System.out.println(Integer.toOctalString(data));
		System.out.println(Integer.toHexString(data));
		System.out.println();
		
		System.out.println(Integer.parseInt("1101",2));
		System.out.println(Integer.parseInt("15", 8));
		System.out.println(Integer.parseInt("0D", 16));
		
		//다양한 진법 표현
		System.out.println(13);
		System.out.println(0b1101);
		System.out.println(015);
		System.out.println(0x0D);
		System.out.println();
		
		//비트 연산자
		System.out.println(3 & 10);
		
		System.out.println(3 | 10);
		
		System.out.println(3 ^ 10);
		
		System.out.println(~3);
		

	}

}
