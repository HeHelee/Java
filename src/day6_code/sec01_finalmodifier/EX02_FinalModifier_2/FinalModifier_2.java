package day6_code.sec01_finalmodifier.EX02_FinalModifier_2;

class A {
	void abc() {}
	final void bcd() {}
}
	

class B extends A{
	void abc() {}
//	void bcd() {} //final 메소드는 오버라이딩 불가능

}
final class C {
	
}
// final class는 상속 불가능

class FinalModifier_2 {


	public static void main(String[] args) {
		

	}

}
