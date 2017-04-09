package vafspy.weparr.cnvlib;

public class Binary implements Type {

	@Override
	public int toInt(String val) throws Exception {
		return Integer.parseInt(val, 2);
	}

	@Override
	public String fromInt(int num) {
		return Integer.toBinaryString(num);
	}

}
