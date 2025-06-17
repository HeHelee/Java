package day6_code.oop11;

public class MartialSpeaker implements Speaker {

	@Override
	public void soundUp() {
		System.out.println("MartialSpeaker : 소리를 키웁니다.");
	}

	@Override
	public void soundDown() {
		System.out.println("MartialSpeaker : 소리를 줄입니다.");		
	}

}
