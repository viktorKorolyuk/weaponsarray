package vafspy.weparr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Games extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel pnl = new JPanel();
	JButton rps = new JButton("Rock Paper Scissors");
	public Games() {
		super("WeaponsArray Games");
		setSize(500, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new MainLoader();
			}
		});
		add(pnl);
		rps.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new RockPaperScissors();
				dispose();
			}
			
		});
		pnl.add(rps);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Games();
	}
}
