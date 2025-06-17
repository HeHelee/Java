package day6_code.oop11;

public class LgTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LgTV : 전원을 켭니다.");
		
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV : 전원을 끕니다.");
		
	}

	@Override
	public void soundUp() {
		System.out.println("LgTV : 소리를 키웁니다.");
		
	}

	@Override
	public void soundDown() {
		System.out.println("LgTV : 소리를 줄입니다.");
		
	}

	@Override
	public void channelUp() {
		System.out.println("LgTV: 채널을 올립니다.");
		
	}

	@Override
	public void channelDown() {
		System.out.println("LgTV: 채널을 내립니다.");
		
	}

}
