package vafspy.weparr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.StyledDocument;

public class BinaryConverter extends JFrame {
	// Add a serialVersionUID: Takes care of those pesky warnings!
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	public JComboBox<String> comboBox;
	public JLabel bin;
	public JLabel title;
	public JLabel bin2;
	public JPanel main;
	public JTextPane data;
	public JTextField input;
	public JTextField input2;
	public StyledDocument document;

	public static void main(String[] args) {
		new BinaryConverter();
	}

	public BinaryConverter() {
		frame = new JFrame();
		frame.setTitle("Binary Converter v1.5");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
		}

		data = new JTextPane();
		data.setEditable(false);
		data.setBounds(78, 230, 450, 100);
		data.setText("Your answer will go here");
		data.setForeground(Color.BLUE);
		data.setBackground(Color.WHITE);
		data.setFont(new Font("Courier New", Font.BOLD, 12));
		data.setOpaque(true);

		input = new JTextField();
		input.setEditable(true);
		input.setCaretColor(Color.BLUE);
		input.setBounds(78, 131, 194, 25);
		input.setForeground(Color.BLACK);
		input.setCaretColor(Color.RED);
		input.setOpaque(true);
		input.setFont(new Font("Courier New", Font.BOLD, 12));
		input.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String binary1 = input.getText();
				String binary = "";
				try {
					doCommand(binary1);
					int i = Integer.parseInt(binary1); // hex to decimal
					binary = Integer.toBinaryString(i); // decimal to binary
					input.setText("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(
							null,
							"Error: -->: "
									+ ex.getMessage()
									+ " |Please enter numbers as digits, words do not work.",
							"Conversion Error.", JOptionPane.ERROR_MESSAGE);
				}
				data.setText("");
				data.setText(binary);
				input.selectAll();
				input2.setText("");
				doCommand(binary1);
			}
		});
		title = new JLabel();
		title.setText("10| Binary And Hex |01");
		title.setFont(new Font("Courier New", Font.BOLD, 35));
		title.setForeground(Color.BLACK);
		title.setBounds(78, 10, 500, 100);
		input2 = new JTextField();
		input2.setEditable(true);
		input2.setBounds(300, 131, 194, 25);
		input2.setForeground(Color.BLACK);
		input2.setCaretColor(Color.RED);
		input2.setOpaque(true);
		input2.setFont(new Font("Courier New", Font.BOLD, 12));
		input2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String binary2 = input2.getText();
				try {
					doCommand(binary2);

					int i = Integer.parseInt(binary2); // hex to decimal
					String binary3 = Integer.toHexString(i); // decimal to
																// binary
					try {
						input2.setText("");
					} catch (Exception ex) {
					}
					data.setText("");
					data.setText(binary3);
					input2.selectAll();
					input.setText("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(
							null,
							"Error: "
									+ ex.getMessage()
									+ " Please put digits as numbers do not work",
							"Alert", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JLabel bin = new JLabel("dec->bin");
		bin.setBounds(78, 104, 70, 15);

		JLabel bin2 = new JLabel("hex->dec");
		bin2.setBounds(300, 104, 80, 30);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(540, 250, 100, 50);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new mainPass();
				frame.dispose();
			}
		});

		frame.add(btnBack);

		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(540, 310, 100, 50);
		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.add(btnQuit);

		JButton btnGen = new JButton("Generate Binary");
		btnGen.setBounds(77, 168, 150, 25);
		btnGen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String binary1 = input.getText();
				try {
					doCommand(binary1);
					int i = Integer.parseInt(binary1); // hex to decimal
					String binary = Integer.toBinaryString(i); // decimal to
																// binary
					try {
						input.setText("");
					} catch (Exception ex) {
					}
					data.setText("");
					data.setText(binary);
					input.selectAll();
					input2.setText("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(
							null,
							"Error: "
									+ ex.getMessage()
									+ "Please put digits as numbers do not work",
							"Alert", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		frame.getContentPane().add(btnGen);
		JButton btnGen2 = new JButton("Generate Hex");
		btnGen2.setBounds(300, 168, 150, 25);

		btnGen2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String binary2 = input2.getText();
				try {
					doCommand(binary2);
					int i = Integer.parseInt(binary2); // hex to decimal
					String binary3 = Integer.toHexString(i); // decimal to
																// binary
					try {
						input2.setText("");
					} catch (Exception ex) {
					}
					data.setText("");
					data.setText(binary3);
					input2.selectAll();
					input.setText("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(
							null,
							"Error: "
									+ ex.getMessage()
									+ " Please put digits as numbers do not work",
							"Alert", JOptionPane.ERROR_MESSAGE);
				}
				input2.selectAll();
			}
		});

		frame.getContentPane().add(btnGen2);
		frame.add(input, BorderLayout.SOUTH);
		frame.add(input2, BorderLayout.SOUTH);
		frame.add(data, BorderLayout.SOUTH);
		frame.getContentPane().add(title);
		frame.getContentPane().add(bin);
		frame.getContentPane().add(bin2);
		frame.setSize(660, 380);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public void doCommand(String binary1) {
		final String[] commands = binary1.split(" ");
		try {
			if (commands[0].equalsIgnoreCase("close")) {
				data.setText("Hacker");
				JOptionPane.showMessageDialog(null, "Accses Granted", "Alert",
						JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "Nope", "Alert",
						JOptionPane.INFORMATION_MESSAGE);
				JOptionPane
						.showMessageDialog(
								null,
								"Its just a binary converter - geez - Stop being a big baby",
								"Alert", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
				JOptionPane
						.showMessageDialog(
								null,
								"Program Chrased :-( (Change to linux so that its dosn't crash)",
								"Alert", JOptionPane.ERROR_MESSAGE);
				JOptionPane
						.showMessageDialog(
								null,
								"Thanks To all the people who dodn't help me make this, because you made me want to do it",
								"Thanks", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception ex) {
		}
	}
}