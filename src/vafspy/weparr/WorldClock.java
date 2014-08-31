package vafspy.weparr;

import java.awt.Color;
import java.util.Calendar;
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
			Calendar calendar = Calendar.getInstance();
			
			while (true) {
				calendar.setTime(new Date());
				int hours = calendar.get(Calendar.HOUR_OF_DAY);
				int minutes = calendar.get(Calendar.MINUTE);
				int seconds = calendar.get(Calendar.SECOND);
				String strSec = Integer.toString(seconds);
				String strMin = Integer.toString(minutes);
				boolean pm = false;
				boolean isampm = true;
				if(hours == 12 && minutes == 0 || hours == 24 && minutes == 0) {
					/*
					 * If it is 12:00, set isampm to false.
					 * This is because 12:00 is never AM or PM. This switches it
					 * so that it uses "MIDNIGHT" and "NOON" instead.
					 * Please read more on the GMT website: http://tiny.cc/gmtAMPM
					 */
					isampm = false;
				}
				if(hours > 12) {
					/*
					 * This section checks if it is PM (hours > 12) and if so, it subtracts
					 * 12 from the hours variable, and sets pm to true, which signifies
					 * that it is either PM or MIDNIGHT.
					 */
					hours = hours - 12;
					pm = true;
				}
				String strHr = Integer.toString(hours);
				/*
				 * Use AM and PM times (or NOON and MIDNIGHT)
				 * The statement to check AM/PM/NOON/MIDNIGHT is as follows:
				 * (isampm ? (pm ? " PM" : " AM") : (pm ? " MIDNIGHT" : " NOON"))
				 * this means the following:
				 * if isampm, go to the AM/PM switch
				 * otherwise, go to the NOON/MIDNIGHT switch
				 * The AM/PM switch is as follows: '(pm ? " PM" : " AM")' and means:
				 * if is pm, add " PM" to the string, otherwise add " AM"
				 * The NOON/MIDNIGHT switch is as follows: '(pm ? " MIDNIGHT" : " NOON")' and means:
				 * if is pm, add " MIDNIGHT" to the string, otherwise add " NOON"
				 */
				timeHere.setText(strHr + ":" + strMin + ":" + strSec + (isampm ? (pm ? " PM" : " AM") : (pm ? " MIDNIGHT" : " NOON")));
			}

		}

	}

}
