package vafspy.weparr.cnvlib;

public class Hexadecimal implements Type {

	@Override
	public int toInt(String val) {
		return Integer.parseInt(val, 16);
	}

	@Override
	public String fromInt(int num) {
		return Integer.toHexString(num);
	}

}