package day5_code.oop10;

class A {
	int a = 3;
	int b = 4;
}
class B {
	int a = 3;
	int b = 4;
	
	public String toString() {
		return "필드값 (a,b) = " + a + " " + b;
	}
}

public class HashCodeTest {

	public static void main(String[] args) {
		//객체 생성
		A a = new A();
		B b = new B();
		
		//메서드 호출
		System.out.printf("%x\n", a.hashCode());
		System.out.println(a.toString());
		System.out.println(b);

	}
}
