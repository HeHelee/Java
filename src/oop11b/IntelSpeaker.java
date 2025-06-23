package oop11b;

public class IntelSpeaker implements Speaker{
	public IntelSpeaker() {
		System.out.println("제품이 생성됨.");
	}

	@Override
	public void soundUp() {
		System.out.println("IntelSpeaker : 소리를 키웁니다.");

	}

	@Override
	public void soundDown() {
		System.out.println("InterSpeaker : 소리를 줄입니다.");

	}

}
