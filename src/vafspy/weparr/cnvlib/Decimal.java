package vafspy.weparr.cnvlib;

public class Decimal implements Type {

	@Override
	public int toInt(String val) {
		return Integer.parseInt(val);
	}

	@Override
	public String fromInt(int num) {
		return "" + num + "";
	}

}
