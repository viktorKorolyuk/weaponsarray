package vafspy.weparr;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

// Used for Logo: import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.StyledDocument;

public class virus {
	public JFrame frame;

	public JLabel bin;
	public JLabel title;
	public JButton negative;
	public JButton yes;
	public JLabel bin2;
	public JTextPane data;
	public JTextField input;
	public JTextField input2;
	public StyledDocument document;
	public JComboBox<String> choices;

	public static void main(String[] args) {
		new virus();
	}

	public virus() {
		frame = new JFrame();
		frame.setTitle("Death Virus");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
		}
		data = new JTextPane();
		data.setEditable(false);
		data.setOpaque(true);
		data.setFont(new Font("Courier New", Font.BOLD, 12));

		title = new JLabel();
		title.setText("Are You An Idiot?");
		title.setFont(new Font("Courier New", Font.BOLD, 20));
		title.setForeground(new Color(255, 255, 255));
		title.setBounds(70, 10, 700, 100);

		// ImageIcon Logo = new ImageIcon("src/icon.png");

		yes = new JButton();
		yes.setText("Yes");
		yes.setBounds(500, 310, 90, 30);
		yes.setLocation(500, 300);
		yes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Finaly Youre Truthfull!",
						"Alert", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null,
						"Too bad youre still getting the virus", "Alert",
						JOptionPane.INFORMATION_MESSAGE);
				still();
			}
		});
		frame.add(yes);

		negative = new JButton();
		negative.setText("No");
		negative.setEnabled(true);
		negative.setBounds(170, 300, 200, 40); // x ,y , hight, length
		negative.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				noNo();
			}
		});
		negative.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				noNo();
				System.out.println("Done \n");

			}

		});

		frame.add(title);
		frame.add(negative);
		frame.add(data);
		frame.setSize(660, 390);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setVisible(true);

	}

	public void noNo() {

		Random rand = new Random();

		int x1 = rand.nextInt(660) + 1;
		int y1 = rand.nextInt(349) + 1;
		System.out.println(x1 + " : " + y1);
		/*
		 * Why are these here? They are just taking up space and adding compile
		 * warnings. commenting out! Double x = new
		 * Double(negative.getAlignmentX()); Double y = new
		 * Double(negative.getAlignmentY()); int x2 = x.intValue(); int y2 =
		 * y.intValue();
		 */

		negative.setBounds(x1 / 2, y1 / 2, 200, 40);
	}

	public void still() {

		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);

		// -______________-

		new virus2();
		frame.dispose();

	}

}
