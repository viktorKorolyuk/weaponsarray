package vafspy.weparr.cnvlib;

public class Octal implements Type {

	@Override
	public int toInt(String val) throws Exception {
		return Integer.parseInt(val, 8);
	}

	@Override
	public String fromInt(int num) {
		return Integer.toOctalString(num);
	}

}
