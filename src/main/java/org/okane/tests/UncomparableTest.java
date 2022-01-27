package org.okane.tests;
import java.math.BigDecimal;


public class UncomparableTest {
	
	public static void main(String[] args) {
		long a = (1L << 54) + 1;
		double b = a;
		System.out.println("b == a is " + (b == a));
		System.out.println("(long) b < a is " + ((long) b < a));
	
		double c = 1e19;
		long d = 0;
		d += c;
		System.out.println("\nd < c is " + (d < c));
		System.out.println("d < (long) c is " + (d < (long) c));
	
		Double e = 0.0;
		Double f = 0.0;
		System.out.println("\ne <= f is " + (e <= f));
		System.out.println("e >= f is " + (e >= f));
		System.out.println("e == f is " + (e == f));
	
		BigDecimal x = new BigDecimal("0.0");
		BigDecimal y = BigDecimal.ZERO;
		System.out.println("\nx == y is " + (x == y));
		System.out.println("x.doubleValue() == y.doubleValue() is " + (x.doubleValue() == y.doubleValue()));
		System.out.println("x.equals(y) is " + x.equals(y));
		System.out.println("x.compareTo(y) == 0 is " + (x.compareTo(y) == 0));
	}
}
