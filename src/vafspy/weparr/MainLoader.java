package vafspy.weparr;

public class MainLoader {
	// The Main Loader Is a simple way to replace a launcher temporarily.
	// Just set this as the main class.
	public MainLoader() {
		
		main(new String[0]);
	}
	public static void main(String[] arg) {
		
		Features.load();
		switch(Features.getProperty("loader")) {
		case "0":
			mainPass.main(arg);
			break;
		case "1":
		default:
			SecondLauncher.main(arg);
			break;
		}
	}
}
