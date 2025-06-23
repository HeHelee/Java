package day8_sec04_annonymousclass.EX01_AnnonymousClass_1;

class A {
	C c = new B(); //업캐스팅
	void abc() {
		c.bcd();
	}
	class B implements C {
		public void bcd() {
			System.out.println("인스턴스 이너 클래스");
		}
	}
}
interface C {
	public abstract void bcd();
}

public class AnnonymouseClass_1 {

	public static void main(String[] args) {
		//객체 생성 및 메서드 호출
		A a = new A();
		a.abc();
	}
}
