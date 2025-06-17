package day6_code.oop11;

public interface TV {
	public default void setSpeaker(Speaker speaker) {};
	public void powerOn();
	public void powerOff();
	public void soundUp();
	public void soundDown();
	public void channelUp();
	public void channelDown();
}
