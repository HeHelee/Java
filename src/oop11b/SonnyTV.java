package oop11b;

public class SonnyTV implements TV{
	private Speaker speaker;
	public SonnyTV() {
		System.out.println("제품이 생성됨.");
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void powerOn() {
		System.out.println("SonnyTV: 전원을 켭니다.");
	}

	public void powerOff() {
		System.out.println("SonnyTV: 전원을 끕니다..");
	}

	public void channelUp() {
		System.out.println("SonnyTV: 채널을 올립니다.");
	}

	public void channelDown() {
		System.out.println("SonnyTV: 채널을 내립니다..");
	}

	public void soundUp() {
		if (speaker == null) {
			System.out.println("SonnyTV: 소리를 키웁니다.");
		} else {
			speaker.soundUp();
		}
	}

	public void soundDown() {
		if (speaker == null) {
			System.out.println("SamsungTV: 소리를 줄입니다");
		} else {
			speaker.soundDown();
		}
	}

}
