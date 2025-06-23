package day3_code.Array;

public class Hello {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "]" + args[i]);
		}

		System.out.println();
		for (String str : args) {
			System.out.println(str);
		}
	}
}
