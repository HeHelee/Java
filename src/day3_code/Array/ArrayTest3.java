package day3_code.Array;

public class ArrayTest3 {

	public static void main(String[] args) {
		int [][] score = {
				{100, 90, 80, 70}, 
				{90, 80, 70, 60},
				{80,70,60,50}
		};
	
		System.out.println("국어\t영어\t수학\t철학\t총점\t평균");
		for (int row = 0; row < score.length; row++) {
			int sum = 0;
			double avg = 0.0;
			for (int col = 0; col <score[row].length; col++) {
				System.out.print(score[row][col] + "\t");
			    sum += score[row][col];
			    avg = sum / score[row].length;
			}
			System.out.print(sum + "\t");
			System.out.print(avg);

			System.out.println();
		}
		System.out.println("종료");
	}

}
