package vafspy.weparr.components;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame{
	private static final long serialVersionUID = 1L;
	JPanel p = new NoisePanel();
	public Test() {
		super("LO");
		setSize(500,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(p);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Test();
	}
}
