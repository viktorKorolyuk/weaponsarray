package vafspy.weparr;

public class MainLoader {
	// The Main Loader Is a simple way to replace a launcher temporarily.
	// Just set this as the main class.
	public static void main(String[] args) {
		Features.load();
		switch(Features.getProperty("loader")) {
		case "0":
			mainPass.main(args);
			break;
		case "1":
		default:
			SecondLauncher.main(args);
			break;
		}
	}
}
