package day6_code.sec01_finalmodifier.EX01_FinalModifier_1;

class A1 {
	int a = 3;
	final int b = 5;
	A1() {
		
	}
}
class A2 {
	int a;
	final int b;
	A2() {
		a = 3;
		b = 5;
	}
}
class A3 {
	int a = 3;
	final int b = 5;
	A3() {
		a = 5;
	}
}
class B {
	void bcd() {
		int a = 3;
		final int b = 5;
		a = 7;
	}
}

public class FinalModifier_1 {

	public static void main(String[] args) {
		//객체 생성
		A1 a1 = new A1();
		A2 a2 = new A2();
		
		//필드값 변경
		a1.a = 7;
		//a1.b = 9;
		a2.a = 7;
		//a2.b = 9; final 필드는 한번 정해진 값을 변경할 수 없음.
		

	}

}
