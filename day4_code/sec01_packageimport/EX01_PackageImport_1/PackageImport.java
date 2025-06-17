package day4_code.sec01_packageimport.EX01_PackageImport_1;

public class PackageImport {

	public static void main(String[] args) {
		//객체 생성
		//A a = new A();
		day4_code.sec01_packageimport.common.A a = new day4_code.sec01_packageimport.common.A();
		
		//멤버 활용
		System.out.println(a.m);
		System.out.println(a.n);
		System.out.println();

	}

}
