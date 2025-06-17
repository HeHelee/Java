package day6_code.sec02_interface.EX01_InterfaceCharacteristics;

interface A {
	public static final int a = 3;
	public abstract void abc();
}
interface B {
	int b = 3;
	void bcd();
}

public class InterfaceCharacteristics {

	public static void main(String[] args) {
		//static 자동 추가 확인
		System.out.println(A.a);
		System.out.println(B.b);
		
		//final 자동 추가 확인
		//A.a = 5;
		//B.b = 7;

	}

}
