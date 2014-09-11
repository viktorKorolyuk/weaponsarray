package vafspy.weparr;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RockPaperScissors extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int CONSOLE_HEIGHT = 9;
	CountDownLatch latch = new CountDownLatch(1);
	int select = 0;
	JPanel p = new JPanel();
	JTextArea jta = new JTextArea(10, 61);
	JButton rock = new JButton("Rock");
	JButton paper = new JButton("Paper");
	JButton scissors = new JButton("Scissors");
	RPSUI ui;

	public RockPaperScissors() {
		super("Rock Paper Scissors [best 2 out of 3]");
		// Rock Paper Scissors does NOT set it's own look and feel for sizing
		// reasons
		// Open MainLoader when X is pressed.
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new Games();
			}
		});

		setSize(500, 270);

		add(p);

		jta.setFont(new Font("Monospaced", Font.PLAIN, 12));
		p.add(jta);
		setRPSEnabled(false);
		rock.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				select = 0;
				latch.countDown();
			}
			
		});
		paper.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				select = 1;
				latch.countDown();
			}
			
		});
		scissors.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				select = 2;
				latch.countDown();
			}
			
		});
		p.add(rock);
		p.add(paper);
		p.add(scissors);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

		while (true) {
			play();
		}

	}

	public static void main(String[] args) {
		new RockPaperScissors();
	}

	private void play() {
		ui = new RPSUI();
		ui.clear(jta);
		ui.println(jta, "Weapons Array Rock Paper Scissors [BEST 2 OUT OF 3]");
		ui.println(jta, "The first one to gain 2 points more than his/her opponent wins!");
		ui.println(jta, "Starting game...");
		boolean over = false;
		int user, enemy, userselect, enemyselect;
		String nme, usr;
		user = enemy = userselect = enemyselect = 0;
		while(!over) {
			userselect = select();
			Random r = new Random();
			int low = 0;
			int high = 2;
			enemyselect = r.nextInt(high-low) + low;
			switch(enemyselect) {
			case 0:
				nme = "rock";
				break;
			case 1:
				nme = "paper";
				break;
			case 2:
				nme = "scissors";
				break;
			default:
				nme = "ERROR OCCURRED!";
				break;
			}
			switch(userselect) {
			case 0:
				usr = "rock";
				break;
			case 1:
				usr = "paper";
				break;
			case 2:
				usr = "scissors";
				break;
			default:
				usr = "ERROR OCCURRED!";
				break;
			}
			ui.println(jta, "You chose " + usr + ", and the comp chose " + nme + "...");
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {}
			if (userselect == enemyselect) {
				user++;
				enemy++;
			} else if (userselect == 0 && enemyselect == 1) {
				enemy++;
			} else if (userselect == 0 && enemyselect == 2) {
				user++;
			} else if (userselect == 1 && enemyselect == 0) {
				user++;
			} else if (userselect == 1 && enemyselect == 2) {
				enemy++;
			} else if (userselect == 2 && enemyselect == 0) {
				enemy++;
			} else if (userselect == 2 && enemyselect == 1) {
				user++;
			}
			ui.setScores(jta, user, enemy);
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {}
			if (userselect == enemyselect) {
				ui.println(jta, "DRAW: YOU AND COMP BOTH GAIN 1 POINT");
			} else if (userselect == 0 && enemyselect == 1) {
				ui.println(jta, "paper covers rock, COMP GAINS ONE POINT");
			} else if (userselect == 0 && enemyselect == 2) {
				ui.println(jta, "rock beats scissors, YOU GAIN ONE POINT");
			} else if (userselect == 1 && enemyselect == 0) {
				ui.println(jta, "paper covers rock, YOU GAIN ONE POINT");
			} else if (userselect == 1 && enemyselect == 2) {
				ui.println(jta, "scissors cuts paper, COMP GAINS ONE POINT");
			} else if (userselect == 2 && enemyselect == 0) {
				ui.println(jta, "rock beats scissors, COMP GAINS ONE POINT");
			} else if (userselect == 2 && enemyselect == 1) {
				ui.println(jta, "scissors cut paper, YOU GAIN ONE POINT");
			}
			if(user == enemy - 2) {
				over = true;
				ui.println(jta, "COMP WINS!!!");
			}
			if(enemy == user - 2) {
				over = true;
				ui.println(jta, "YOU WIN!!!");
			}
		}
		ui.println(jta, "Press a button to play again.");
		select();
	}
	private int select() {
		latch = new CountDownLatch(1);
		ui.println(jta, "Choose rock/paper/scissors:");
		ui.setTakingInput(jta, true);
		setRPSEnabled(true);
		try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		ui.setTakingInput(jta, false);
		setRPSEnabled(false);
		return select;
	}
	private void setRPSEnabled(boolean tf) {
		rock.setEnabled(tf);
		paper.setEnabled(tf);
		scissors.setEnabled(tf);
	}
}

class RPSUI {
	/*
	 * RPSUI contains methods for updating different sections of the Rock Paper
	 * Scissors Textual User Interface. This includes the status bar at the
	 * bottom ('USER: x - COMP: x')
	 */
	String score_user = "0";
	String score_comp = "0";
	String taking_input = "n";
	String[] console_contents = new String[RockPaperScissors.CONSOLE_HEIGHT];
	int outbuff_length = 0; // How many occupied lines in console_contents?

	private String renderConsole() {
		String console = "";
		int i = 0;
		while (i < console_contents.length) {
			if (console_contents[i] == null) {
				console_contents[i] = "";
			}
			console += console_contents[i] + "\n";
			i++;
		}
		return console;
	}

	private String renderStats() {
		return "USER: " + score_user + (score_user.length() > 1 ? "" : " ")
				+ "    |    COMP:  " + score_comp
				+ (score_comp.length() > 1 ? "" : " ")
				+ "      |    TAKING INPUT: " + taking_input;
	}

	private void update(JTextArea jta) {
		jta.setText(renderConsole()
				+ "------------------------------------------------------------------\n       "
				+ renderStats() + "       ");
	}

	private String insertper(String text, String insert, int period) {
		StringBuilder builder = new StringBuilder(text.length()
				+ insert.length() * (text.length() / period) + 1);

		int index = 0;
		String prefix = "";
		while (index < text.length()) {
			// Don't put the insert in the very first iteration.
			// This is easier than appending it *after* each substring
			builder.append(prefix);
			prefix = insert;
			builder.append(text.substring(index,
					Math.min(index + period, text.length())));
			index += period;
		}
		return builder.toString();
	}
	
	private String[] shiftArray(String[] a, int howmany) {
		int i = 0;
		while(i < howmany) {
			int j = 0;
			while(j < a.length) {
				if(j == a.length - 1) {
					a[j] = "";
				} else {
					a[j] = a[j + 1];
				}
				j++;
			}
			i++;
		}
		return a;
	}

	public void println(JTextArea jta, String line) {
		/*
		 * Prints the contents to the console area
		 */
		int lines = 1, startpos = 0;
		if(line.length() > 61) {
			lines = (int) Math.floor(line.length() / 64 + 1);
		}
		if(lines > 1) {
			line = insertper(line, "\n", 64);
		}
		if(outbuff_length > RockPaperScissors.CONSOLE_HEIGHT - lines) {
			console_contents = shiftArray(console_contents, lines);
			startpos = RockPaperScissors.CONSOLE_HEIGHT - lines;
		} else {
			startpos = outbuff_length;
			outbuff_length = outbuff_length + lines;
		}
		String[] multiline_print = line.split("\n");
		int i = 0;
		while(i < multiline_print.length) {
			console_contents[startpos + i] = multiline_print[i];
			i++;
		}
		update(jta);
	}
	
	public void setTakingInput(JTextArea jta, boolean yn) {
		taking_input = yn ? "y" : "n";
		update(jta);
	}

	public void setScores(JTextArea jta, int user, int comp) {
		score_user = "" + user;
		score_comp = "" + comp;
		update(jta);
	}
	public void clear(JTextArea jta) {
		/*
		 * Clear clears the UI contents but not the UI. resets it to
		 * blank/default for the system.
		 */
		console_contents = new String[RockPaperScissors.CONSOLE_HEIGHT];
		outbuff_length = 0;
		score_user = "0";
		score_comp = "0";
		taking_input = "n";
		update(jta);
	}
}