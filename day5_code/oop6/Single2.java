package day5_code.oop6;
/*
Singleton Pattern:
하나의 클래스에 대해 오직 하나의 인스턴스만 생성되도록 보장하고, 그 인스턴스를 전역에서 공유하도록 만드는 디자인 패턴.

구현 단계
1. 생성자를 private으로 감춰 외부에서 직접 생성하지 못하도록 막는다.
2. 자기 자신을 참조하는 private static (final) 인스턴스를 클래스 내부에 선언.
3. 정적 메서드 (getInstance())를 통해 단 하나의 인스턴스를 외부에 제공.
4. Class명.getInstance()로 어디서든 동일한 인스턴스를 사용 가능.
 */

public class Single2 {
	// Eager Initialization : 조기 초기화
	private static final Single2 single = new Single2();
	private Single2() {}
	public static Single2 getInstance() { //사용하기 전에 미리 만들어놈
			return single;
	}

}
