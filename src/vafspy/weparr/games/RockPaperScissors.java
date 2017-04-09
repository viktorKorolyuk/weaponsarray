package vafspy.weparr.games;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RockPaperScissors extends JFrame {
	JPanel pnl = new JPanel();
	JTextArea gameArea = new JTextArea(10, 10);
	JLabel lbl = new JLabel("Hello world");
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new RockPaperScissors();
	}

	public RockPaperScissors() {
		setTitle("Title");
		setSize(500, 500);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		gameArea.setMargin(new Insets(12, 12, 12, 12));

		pnl.setBackground(Color.BLUE);
		pnl.add(gameArea);

		add(gameArea);
		setVisible(true);
	}

}
