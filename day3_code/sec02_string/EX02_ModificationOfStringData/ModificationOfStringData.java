package day3_code.sec02_string.EX02_ModificationOfStringData;

import java.util.Arrays;

public class ModificationOfStringData {

	public static void main(String[] args) {
		//문자열 수정
		String str1 = new String("안녕");
		String str2 = str1;
		
		str1 = "안녕하세요.";
		System.out.println(str1);
		System.out.println(str2);
		
		//배열 참조 자료형
		int[] array1 = new int[] {3,4,5};
		int[] array2 = array1;
		array1[0] = 6;
		array2[1] = 7;
		array1[2] = 8;
		
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		
	}

}
