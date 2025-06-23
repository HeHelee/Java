package day9_sec01_theneedforthread.EX01_TheNeedForThread;

public class TheNeedForThread {

	public static void main(String[] args) {
		// 비디오 프레임 (1~5)
		int[] intArray = { 1, 2, 3, 4, 5 };
		// 자막 번호 하나 ~ 다섯
		String[] strArray = { "하나", "둘", "셋", "넷", "다섯" };
		// 비디오 프레임 출력
		for (int i = 0; i < intArray.length; i++) {
			System.out.println("(비디오 프레임) " + intArray[i]);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
		// 자막 번호 출력
		for (int i = 0; i < strArray.length; i++) {
			System.out.println("(자막 번호) " + strArray[i]);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}

	}

}
