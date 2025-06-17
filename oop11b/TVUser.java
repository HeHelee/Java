package oop11b;

public class TVUser {

	public static void main(String[] args) {
		TV tv = TvFactory.getTV();
		tv.setSpeaker(SpeakerFactory.getSpeaker()); //new HarmanSpeaker();
		tv.powerOn();
		tv.channelUp();
		tv.channelUp();
		tv.soundUp();
		tv.soundUp();
		tv.powerOff();

	}
	

}

//LgTV에 OrangeSpeaker 연결하기
