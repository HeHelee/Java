package day3_code.sec02_string.EX05_MethodOfString_1;

public class MethodString_1 {

	public static void main(String[] args) {
		// 문자열 길이
		String str1 = "Hello Java!";
		String str2 = "안녕하세요. 반갑습니다.";
		System.out.println(str1.length());
		System.out.println(str2.length());
		System.out.println();
		
		// 문자열 검색
		// @charAt
		System.out.println(str1.charAt(1));
		System.out.println(str2.charAt(1));
		System.out.println();
		
		// @indexOf(), lastIndexOf()
		System.out.println(str1.indexOf('a'));
		System.out.println(str1.lastIndexOf('a'));
		System.out.println(str1.indexOf('a',8));
		System.out.println(str1.lastIndexOf('a',8));
		System.out.println(str1.indexOf("Java"));
		System.out.println(str1.lastIndexOf("Java"));
		System.out.println(str2.indexOf("하세요"));
		System.out.println(str2.lastIndexOf("하세요"));
		System.out.println(str1.indexOf("Bye"));
		System.out.println(str2.lastIndexOf("고맙습니다."));
		System.out.println();

	}

}
