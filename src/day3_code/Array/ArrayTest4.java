package day3_code.Array;

public class ArrayTest4 {

	public static void main(String[] args) {
		int[][][] score = { 
				{ { 100, 90, 80, 70 }, { 90, 80, 70, 60 }, { 80, 70, 60, 50 } },
				{ { 100, 100, 90, 80 }, { 100, 90, 80, 70 }, { 90, 80, 70, 60 } } };

		System.out.println("국어\t영어\t수학\t철학\t총점\t평균");
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				int sum = 0;
				double avg = 0.0;
				for (int k = 0; k < score[i][j].length; k++) {
					System.out.print(score[i][j][k] + "\t");
					sum += score[i][j][k];
					avg = (double)sum / score[i][j].length;
				}
				System.out.print(sum + "\t" + avg);
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("종료");
	}

}
