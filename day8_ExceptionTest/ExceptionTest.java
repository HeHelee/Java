package day8_ExceptionTest;
import java.util.Random;
import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		// int n = (int)(Math.random() * 99) + 1;
		Random random = new Random();
		int n = random.nextInt(99) + 1;
		int you = 0;
		int count = 0;

		try (Scanner sc = new Scanner(System.in);) {
			while (true) {
				System.out.print("1부터 99사이의 정수를 입력하세요 > ");
				if (!sc.hasNextInt()) {
					System.out.println("값이 잘못 입력되었습니다.");
					sc.nextLine();
					continue;
				}
				you = sc.nextInt();
				sc.nextLine();
				count ++;
				if (!(1 <= you && you <= 99)) {
					System.out.println("값의 범위가 틀렸습니다. 1 <= x <= 99 사이의 정수로 입력");
				} else if (you != n) {
					System.out.println("입력 값은 " + you + "입니다.");
					if (you > n) {
						System.out.println("Down");
					}else {
					    System.out.println("Up");
					}
				} else {
					System.out.println("맞았습니다. 컴퓨터가 생각하던 값은 " + n + "입니다.");  
				    System.out.println("당신은 " + count + "번 만에 맞추셨습니다.");
				    printAttemtMessage(count);
					break;
				}

			}
		}
		System.out.println("종료");

	}

	private static void printAttemtMessage(int count) {
	    switch (count) {
	    case 1:
	    case 2:
	    case 3:
	    case 4:
	    	System.out.println("Great~!");
	    	break;
	    case 5:
	    case 6:
	    case 7:
	    case 8:
	    	System.out.println("Good~!");
	    	break;
	    case 9:
	    case 10:
	    case 11:
	    case 12:
	    	System.out.println("그럭저럭이네");
	    	break;
	    case 13:
	    case 14:
	    case 15:
	    case 16:
	    	System.out.println("아쉽네요.");
	    	break;
	    default :
	    	System.out.println("분발하세요.");
	    	break;
	    }
		
	}

}
