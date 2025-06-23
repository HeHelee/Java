package day7_sec04_userexception.EX02_ExceptionMethod_1;

public class ExceptionMethod_1 {

	public static void main(String[] args) {
		//1. 예외 처리를 생성했을 때 메시지를 전달하지 않은 경우
		try {
			throw new Exception();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//2. 예외 객체를 생성했을 떄 메시지를 전달했을 경우
		try {
			throw new Exception("예외 메시지");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
