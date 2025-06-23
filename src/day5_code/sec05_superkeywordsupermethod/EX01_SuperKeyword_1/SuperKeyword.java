package day5_code.sec05_superkeywordsupermethod.EX01_SuperKeyword_1;

class A {
	void abc() {
		System.out.println("A 클래스의 abc()");
	}
}
class B extends A {
	void abc() {
		System.out.println("B 클래스의 abc()");
	}
	
	void bcd() {
		abc();
	}
}

public class SuperKeyword {

	public static void main(String[] args) {
		//객체 생성
		B bb = new B();
		
		//메서드 생성
		bb.bcd();

	}

}
