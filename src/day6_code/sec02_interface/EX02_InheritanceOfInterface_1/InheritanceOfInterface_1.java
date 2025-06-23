package day6_code.sec02_interface.EX02_InheritanceOfInterface_1;

interface A {}
interface B {}

//단일 인터페이스 상속
class C implements A {
	
}
//다중 인터페이스 상속
class D implements A,B {
	
}
//클래스와 인터페이스를 한번에 상속
class E extends C implements A,B {
	
}

public class InheritanceOfInterface_1 {

	public static void main(String[] args) {
		
	}

}
