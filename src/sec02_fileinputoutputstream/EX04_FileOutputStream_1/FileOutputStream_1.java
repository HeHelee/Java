package sec02_fileinputoutputstream.EX04_FileOutputStream_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStream_1 {

	public static void main(String[] args) throws IOException {
		File outFile = new File("src/day14_sec02_fileinputoutputstream/files/FileInputStream2");

		try (OutputStream os1 = new FileOutputStream(outFile);) {
			os1.write('J');
			os1.write('A');
			os1.write('V');
			os1.write('A');
			os1.write('\r'); // 생략 가능
			os1.write('\n'); // 개행
			os1.flush();
			os1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (OutputStream os2 = new FileOutputStream(outFile, true);) {
			// 2. n-byte 단위 쓰기

			byte[] byteArray1 = "Hello!".getBytes();
			os2.write(byteArray1);
			os2.write('\n');
			os2.flush();
			os2.close();
			// 3.n-byte 단위 쓰기
			OutputStream os3 = new FileOutputStream(outFile, true);
			byte[] byteArray2 = "Better the last smaile than the first laugher".getBytes();
			os3.write(byteArray2, 7, 8);
			os3.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
