package vafspy.weparr.games;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RockPaperScissors extends JFrame {
	JPanel gameHolder;
	TextArea gameArea;
	JScrollPane scrollPane;
	JButton rock_btn, paper_btn, scissors_btn;
	final String[] RPS_OPTIONS = {"Rock", "Paper", "Scissors"};

	private static final long serialVersionUID = 1L;

	public RockPaperScissors() {
		super("title");

		GridBagConstraints c = new GridBagConstraints();
		JPanel x = new JPanel();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());

		gameArea = new TextArea();
		rock_btn = new JButton("Rock");
		paper_btn = new JButton("Paper");
		scissors_btn = new JButton("Scissors");

		rock_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playGame(0);
			}
		});

		paper_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playGame(1);
			}
		});

		scissors_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playGame(2);
			}
		});

		x.add(rock_btn);
		x.add(paper_btn);
		x.add(scissors_btn);

		c.gridx = 0;
		c.gridy = 0;

		add(gameArea, c);

		c.gridy = 100;

		add(x, c);

		pack();
		setResizable(false);
	}

	protected void playGame(int player) {

		int computer = (int) (Math.random() * 3);
		
		String comp = "Computer chose: " + RPS_OPTIONS[computer];
		String pla = "You chose: " + RPS_OPTIONS[player];
		String result = "";
		
		System.out.println(computer);
		
		String[] options = {"Paper beats rock.", "Rock beats scissors.", "Scissors beats paper."};
		
		if(player == computer) result = "Tie. Both players chose " + RPS_OPTIONS[0] + ".";
		switch (player) {
		case 0:
			switch (computer) {
			case 1: result = options[0] + " Computer wins."; break;
			case 2: result = options[1] + " Player wins."; break;
			}
			break;
		case 1:
			switch (computer) {
			case 0: result = options[0] + " Player wins."; break;
			case 2: result = options[2] + " Computer wins."; break;
			}
			break;
		case 2:
			switch (computer) {
			case 0: result = options[1] + " Computer wins."; break;
			case 1: result = options[2] + " Player wins."; break;
			}
		}
		gameArea.drawBoard(pla, comp, result);
	}

	public static void main(String[] args) {
		RockPaperScissors window = new RockPaperScissors();
		window.setVisible(true);
	}

	class TextArea extends JTextArea {

		private static final long serialVersionUID = 1L;
		private final int WIDTH;
		private final int HEIGHT;
		private final String NAME = "Rock. Paper. Scissors";
		private String border = "";

		public TextArea(int charWidth, int height) {
			super();
			WIDTH = charWidth;
			HEIGHT = height;

			setEditable(false);

			drawBoard();
		}

		public TextArea() {
			super();

			WIDTH = 60;
			HEIGHT = 10;

			setEditable(false);
			drawBoard();
		}

		public void drawBoard(String... input) {
			clearBoard();

			// Create a 'border' string to prevent future looping and uneeded
			// print-to-text-area
			if (border.equals(""))
				for (int i = 0; i < WIDTH; i++)
					border += "-";

			// line=0
			print(border);

			// line=2
			print("\n\t\t" + NAME + "\n");

			int line = HEIGHT - 3;
			// This section must fill height-3 lines

			for (String print : input) {
				if (line >= HEIGHT)
					break;
				print(print, true);
				line++;
			}

			for (int i = HEIGHT - line; i != 0; i--) {
				print("\n");
			}

			// line=HEIGHT-1
			print(border);
		}

		public void clearBoard() {
			setText("");
			// drawBoard();
		}

		public <E> void setText(E t) {
			super.setText(t.toString());
		}

		<E> void print(E s) {
			this.append(s.toString());
		}

		<E> void print(E s, boolean newline) {
			if (newline) {
				append(s.toString() + "\n");
				return;
			}

			print(s);
		}

	}
}
