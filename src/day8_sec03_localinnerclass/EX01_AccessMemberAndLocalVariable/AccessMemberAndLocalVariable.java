package day8_sec03_localinnerclass.EX01_AccessMemberAndLocalVariable;

class A {
	int a = 3;
	void abc() {
		int b = 5; //final로 정의됨
		//지역 이너 클래스
		class B {
			void bcd() {
				System.out.println(a);
				System.out.println(b);
				a = 5;
			//	b = 7;
			}
		}
		B bb = new B();
		bb.bcd();
	}
}
public class AccessMemberAndLocalVariable {

	public static void main(String[] args) {
		// 객체 생성 및 메서드 호출
		A a = new A ();
		a.abc();

	}

}
