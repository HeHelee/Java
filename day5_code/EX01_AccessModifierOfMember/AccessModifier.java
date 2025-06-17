package day5_code.EX01_AccessModifierOfMember;

import day5_code.EX01_AccessModifierOfMember.pack1.A;
import day5_code.EX01_AccessModifierOfMember.pack1.B;
import day5_code.EX01_AccessModifierOfMember.pack2.C;
import day5_code.EX01_AccessModifierOfMember.pack2.D;

public class AccessModifier {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		
		a.print();
		b.print();
		c.print();
		d.print();

	}

}
