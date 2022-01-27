package org.okane.tests;
import static java.lang.System.out;

public class DoubleTests {
	public static void main(String[] args) {
		out.println("Max Value: " + Double.MAX_VALUE);
		out.println("-ve Max Value:" + -Double.MAX_VALUE);
		out.println("Max Value + 2: " + (Double.MAX_VALUE + 2));
		out.println("-ve Max Value - 2: " + (-Double.MAX_VALUE - 2));
		out.println("Max Value + 20000: " + (Double.MAX_VALUE + 20000));
		out.println("-ve Max Value - 20000: " + (-Double.MAX_VALUE - 20000));
		out.println("Max Value + 200000000: " + (Double.MAX_VALUE + 200000000));
		out.println("-ve Max Value - 200000000: " + (-Double.MAX_VALUE - 200000000));
		out.println("Max Value + 1%: " + (Double.MAX_VALUE + (Double.MAX_VALUE / 100)));
		out.println("-ve Max Value - 1%: " + (-Double.MAX_VALUE - (Double.MAX_VALUE / 100)));
		out.println("Max Value + 0.01%: " + (Double.MAX_VALUE + (Double.MAX_VALUE / 10000)));
		out.println("-ve Max Value - 0.01%: " + (-Double.MAX_VALUE - (Double.MAX_VALUE / 10000)));
		out.println("Max Value + 0.0001%: " + (Double.MAX_VALUE + (Double.MAX_VALUE / 1000000)));
		out.println("-ve Max Value - 0.0001%: " + (-Double.MAX_VALUE - (Double.MAX_VALUE / 1000000)));
		out.println("Max Value + 0.00000001%: " + (Double.MAX_VALUE + (Double.MAX_VALUE / 10000000000l)));
		out.println("-ve Max Value - 0.00000001%: " + (-Double.MAX_VALUE - (Double.MAX_VALUE / 10000000000l)));
		out.println("Max Value + 0.000000000001%: " + (Double.MAX_VALUE + (Double.MAX_VALUE / 100000000000000l)));
		out.println("-ve Max Value - 0.000000000001%: " + (-Double.MAX_VALUE - (Double.MAX_VALUE / 100000000000000l)));
	}
}
