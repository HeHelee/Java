package day7_sec03_throwsexcepton.EX01_ThrowsException_1;

//1. 하위 메서드에 직접 예외를 처리할 때
class A {
	void abc() {
		bcd();
	}
	void bcd() {
		try {
			Thread.sleep(1000); //일반 예외 처리 : InterruptedException JVM에서 1초동안 동작안하도록 멈춰놓음.
		}catch(InterruptedException e) {
		}
	}
}

//2. 예외를 호출 메서드로 전가할 때
class B {
	void abc() {
		try {
			bcd();
		}catch (InterruptedException e) {
			
		}
	}
	void bcd() throws InterruptedException {
		Thread.sleep(1000);
	}
}
public class ThrowsException_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
