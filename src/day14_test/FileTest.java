package day14_test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FileTest {

	public static void main(String[] args) {
		/*
		 * 1. dev/file/test 폴더를 생성 2. /dev/file/test/ 폴더에 난수 4자리를 발생시켜서 파일을 5개생성
		 * 0155.txt 7667.txt 9295.txt 0627.txt 0605.txt
		 * 
		 * 3. /dev/file/test2/ 폴더로 모든 파일을 복사 (2에서 파일 정보를 배열이나 컬렉션에 담지 말고, 디렉토리 정보를 읽어서
		 * 처리. File.listFiles())
		 * 
		 * 4. /dev/file/test2/ 폴더의 파일들을 확장자 제거 0155 7667 9295 0627 0605
		 */

		// 1.
		File newfile1 = new File("C:/dev/file/test");
		newfile1.mkdirs();

		File targetDir = new File("C:/dev/file/test2");
		if (!targetDir.exists()) {
			targetDir.mkdirs();
		}
		// 2.
		Set<String> generatedNumber = new HashSet<>();
		// 난수 발생
		Random random = new Random();

		while (generatedNumber.size() < 5) {
			int number = 1 + random.nextInt(9999);
			String filename = String.format("%04d.txt", number);

			// 중복 방지
			if (generatedNumber.add(filename)) {
				File file = new File(newfile1, filename);
				try {
					boolean created = file.createNewFile();
					System.out.println("생성됨: " + file.getAbsolutePath() + " → " + created);

					// 확장자 제거
					String nameWithoutExt = filename.substring(0, filename.lastIndexOf('.'));
					File targetFile = new File(targetDir, nameWithoutExt);

					// 복사
					Files.copy(file.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					System.out.println("복사됨: " + targetFile.getAbsolutePath());

				} catch (IOException e) {
					e.printStackTrace();
				}       
			}
		}
	}

}
