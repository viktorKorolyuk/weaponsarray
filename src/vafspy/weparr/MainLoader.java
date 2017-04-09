package vafspy.weparr;



public class MainLoader {
	// The Main Loader Is a simple way to replace a launcher temporarily.
	// Just set this as the main class.
	public MainLoader() {
		
		Features.load();
		switch(Features.getProperty("loader")) {
		case "0":
			new mainPass();
			break;
		case "1":
		default:
			new SecondLauncher();
			break;
		}
	
	}
	public static void main(String[] arg) {
		new MainLoader();	
	}
}
