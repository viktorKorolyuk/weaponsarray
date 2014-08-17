package vafspy.weparr.cnvlib;

public class Decimal implements Type {

	@Override
	public int toInt(String val) throws Exception{
		return Integer.parseInt(val);
	}

	@Override
	public String fromInt(int num) {
		return "" + num + "";
	}

}
