package oop11b;

public interface TV {
	public default void setSpeaker(Speaker speaker) {};
	public void powerOn();

	public void powerOff();

	public void channelUp();

	public void channelDown();

	public void soundUp();

	public void soundDown();
}
