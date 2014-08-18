package vafspy.weparr;

import java.awt.Color;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author viktor
 * 
 */

public class WorldClock {

	//private static final long serialVersionUID = 1L;

	public JFrame f = new JFrame("World Clock");

	public JPanel btm = new JPanel();
	public JPanel timezNow = new JPanel();
	public JPanel timezThere = new JPanel();
	public JLabel timeHere = new JLabel();
	public Date date = new Date();
	Thread run;

	public static void main(String[] args) {
		new WorldClock();
	}

	public WorldClock() {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);

		timezNow.setBounds(0, 0, 400, 300);
		timezNow.add(timeHere);
		timezNow.setLayout(new BoxLayout(timezNow, BoxLayout.Y_AXIS));
		timezNow.setBorder(BorderFactory.createRaisedBevelBorder());
		timezNow.setBackground((Color.gray));

		// timezThere.setSize(400, 300);
		timezThere.setBorder(BorderFactory.createLoweredBevelBorder());
		timezThere.setBackground(Color.red);

		// top.setLayout(gridlayout);

		btm.setBounds(0, 300, 800, 300);
		btm.setBorder(BorderFactory.createRaisedBevelBorder());
		btm.setBackground(Color.darkGray);

		f.add(timezNow);
		f.add(btm);
		f.setBackground(Color.black);

		f.setSize(800, 600);
		f.setVisible(true);
		f.setLocationRelativeTo(null);

		mytime();
	}

	public void mytime() {
		run = new Thread(new mytimers());
		run.start();
	}

	class mytimers implements Runnable {

		@Override
		public void run() {
			while (true) {
				date = new Date(); // This refreshes the date
				int strSecInt = date.getSeconds();
				String strSec = Integer.toString(strSecInt);

				int strMinInt = date.getMinutes();
				String strMin = Integer.toString(strMinInt);

				int strHrInt = date.getHours();
				String strHr = Integer.toString(strHrInt - 12);

				timeHere.setText(strHr + ":" + strMin + ":" + strSec);

				// Check if it works
				// System.out.println(strDate);
			}

		}

	}

}
