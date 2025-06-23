package day8_sec04_annonymousclass.EX02_AnnonymousClss_2;

class A {
	C c = new C() {
		public void bcd() {
			System.out.println("익명 이너 클래스");
		}
	};

	void abc() {
		c.bcd();
	}
}

interface C {
	public abstract void bcd();
}

public class AnnonymouseClass_2 {

	public static void main(String[] args) {
		// 객체 생성 및 메서드 호출
		A a = new A();
		a.abc();

	}

}
