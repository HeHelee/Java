package day14_sec02_fileinputoutputstream.files;

import java.io.File;
import java.nio.charset.Charset;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStream_3 {

	public static void main(String[] args) throws IOException {
		//1.입력 파일 생성
		File infile = new File("src/day14_sec02_fileinputoutputstream/files/FileInputStream2");
		//2. n-byte 단위 읽기 (byte[]의 처음 위치에서부터 읽은 데이터 저장)
		InputStream is2 = new FileInputStream(infile);
		byte[] byteArray1 = new byte[9];
		int count1;
		while((count1 = is2.read(byteArray1)) != -1) {
			String str = new String(byteArray1,0,count1,Charset.forName("UTF-8"));
			System.out.print(str);
			System.out.println(": count1 = " + count1);
		}    
		is2.close();
		System.out.println();
		System.out.println();
		//3. n-byte 단위 읽기
		InputStream is3 = new FileInputStream(infile);
		byte[] byteArray2 = new byte[9];
		int offset = 3;       
		int length = 6;
		int count2 = is3.read(byteArray2,offset,length);
		String str = new String(byteArray2, 0, offset+count2, Charset.defaultCharset());
		System.out.println(str);
		is3.close();

	}

}
