package vafspy.weparr.cnvlib;

public class Hexadecimal implements Type {

	@Override
	public int toInt(String val) throws Exception {
		return Integer.parseInt(val, 16);
	}

	@Override
	public String fromInt(int num) {
		return Integer.toHexString(num);
	}

}