package day5_code.EX01_AccessModifierOfMember.pack1;

public class B {
	public void print() {
		//객체 생성
		A a = new A();
		
		//맴버 활용
		System.out.print(a.a + " ");
		System.out.print(a.b + " ");
		System.out.print(a.c + " ");
		System.out.println();
	}

}
