package vafspy.weparr.customCode;

public class MathEval {

	static double parse(String s) {

		s = evalBrackets(s);
		return Double.MAX_VALUE;
	}

	private static String evalBrackets(String s) {
		return s;
	}

}
