package vafspy.weparr;

import java.io.IOException;
import java.util.Properties;

public class Features {
	public static boolean isloaded = false;
	public static Properties features = new Properties();

	public static void load() {
		if (!isloaded) {
			try {
				features.load(new Features().getClass().getResourceAsStream(
						"/resources/features.properties"));
				isloaded = true;
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	public static String getProperty(String property) {
		return features.getProperty(property);
	}

	public static boolean nimbus() {
		return Boolean.parseBoolean(getProperty("nimbus"));
	}
}
