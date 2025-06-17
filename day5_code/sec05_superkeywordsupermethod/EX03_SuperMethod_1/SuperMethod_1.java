package day5_code.sec05_superkeywordsupermethod.EX03_SuperMethod_1;

class A {
	A() {
		System.out.println("A 생성자");
	}
}
class B extends A {
	B() {
		super(); //생략했을 때 컴파일러가 자동 추가
		System.out.println("B 생성자");
	}
}
class C {
	C(int a) {
		System.out.println("C 생성자");
	}
}
class D extends C{
	D() {
		super(3);
	}
}



public class SuperMethod_1 {

	public static void main(String[] args) {
		//A 객체 생성
		A aa = new A();
		System.out.println();
		
		//B 객체 생성
		B bb = new B();

	}

}
