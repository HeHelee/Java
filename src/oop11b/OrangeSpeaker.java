package oop11b;

public class OrangeSpeaker implements Speaker {
	public OrangeSpeaker() {
		System.out.println("제품이 생성됨.");
	}

	@Override
	public void soundUp() {
		System.out.println("OrangeSpeaker : 소리를 키웁니다.");
	}

	@Override
	public void soundDown() {
		System.out.println("OrangeSpeaker : 소리를 줄입니다.");
	}

}
