package vafspy.weparr.cnvlib;

import java.util.HashMap;

public class Converter {
	HashMap<String, Type> types = new HashMap<String, Type>();
	public Converter() {
		types.put("bin",new Binary());
		types.put("hex", new Hexadecimal());
		types.put("dec", new Decimal());
	}
	public String convert(String from, String to, String value) {
		return "";
	}
}
