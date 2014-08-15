package vafspy.weparr.cnvlib;

import java.util.HashMap;

public class Converter {
	// Create HashMap of objects
	HashMap<String, Type> types = new HashMap<String, Type>();
	// Populate map on initialization
	public Converter() {
		types.put("bin",new Binary());
		types.put("hex", new Hexadecimal());
		types.put("dec", new Decimal());
		types.put("oct", new Octal());
	}
	// Conversion method.
	public String convert(String from, String to, String value) {
		int middle;
		Type typeto = types.get(to);
		Type typefrom = types.get(from);
		middle = typefrom.toInt(value);
		return typeto.fromInt(middle);
	}
}
