package day4_code.sec05_thismethod.EX01_ThisMethod_1;

// 클래스의 정의
class A {
	A() {
		System.out.println("첫 번째 생성자");
	}
	A(int a) {
		this();
		System.out.println("두 번째 생성자");
	}
}

public class ThisMethod_1 {

	public static void main(String[] args) {
		//객체 생성
		A a1 = new A();
		System.out.println();
		A a2 = new A(3);

	}

}
