package vafspy.weparr.games;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RockPaperScissors extends JFrame {
	JPanel pnl = new JPanel();
	JTextArea gameArea = new JTextArea(10, 10);
	JLabel lbl = new JLabel("");
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new RockPaperScissors();
	}

	public RockPaperScissors() {
		super("title");
		setSize(500, 500);
		this.setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		gameArea.setMargin(new Insets(12, 12, 12, 12));

		pnl.setBackground(new Color(255,102,102));
		pnl.add(gameArea);

		add(pnl);
		setVisible(true);
	}

}
