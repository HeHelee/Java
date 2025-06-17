package day6_code.oop11;

public class AppleTV implements TV {
	public void powerOn() {
		System.out.println("AppleTV: 전원을 켭니다.");
	}
	public void powerOff() {
		System.out.println("AppleTV: 전원을 끕니다.");
	}
	public void soundUp() {
		System.out.println("AppleTV: 소리를 키웁니다.");
	}
	public void soundDown() {
		System.out.println("AppleTV: 소리를 줄입니다.");
	}
	public void channelUp() {
		System.out.println("AppleTV: 채널을 올립니다.");
	}
	public void channelDown() {
		System.out.println("AppleTV: 채널을 내립니다.");
	}

}
