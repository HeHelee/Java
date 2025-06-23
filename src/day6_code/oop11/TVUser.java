package day6_code.oop11;

import java.io.FileInputStream;
import java.util.Properties;

public class TVUser {

	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/day5_code.oop11/product.properties"));
		String tvName = prop.getProperty("tv");
		Class tvClass = Class.forName(tvName);
		String speakerName = prop.getProperty("speaker");
		Class speakerClass = Class.forName(speakerName);
		
	    TV tv = (TV)tvClass.getConstructor().newInstance(); //new SamsungTV //다운캐스팅
	    tv.setSpeaker((Speaker)speakerClass.getConstructor().newInstance());
		tv.powerOn();
		tv.channelUp();
		tv.channelUp();
		tv.soundUp();
		tv.powerOff();
	}
}
