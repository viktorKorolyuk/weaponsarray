package vafspy.weparr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.text.StyledDocument;

public class BinaryConverter2 extends JFrame {
	// Add a serialVersionUID: Takes care of those pesky warnings!
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	public JComboBox<String> comboBox;

	public int frameSx = 200;
	public int frameSy = 200;

	public JLabel titleText;
	public JLabel title;

	public JPanel main;
	public JTextPane data;
	public JTextField input;
	public JTextField output;
	public StyledDocument document;

	public static void main(String[] args) {
		new BinaryConverter2();
	}

	public BinaryConverter2() {
		frame = new JFrame();
		frame.setTitle("Binary Converter v2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		try {
			if (Features.nimbus()) {
				for (LookAndFeelInfo info : UIManager
						.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
						UIManager.setLookAndFeel(info.getClassName());
						break;
					}
				}
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
			}
		}

		input = new JTextField();
		input.setEditable(true);
		input.setCaretColor(Color.BLUE);
		input.setBounds(10, 90, 150, 25);
		input.setForeground(Color.BLACK);
		input.setCaretColor(Color.RED);
		input.setOpaque(true);
		input.setFont(new Font("Courier New", Font.BOLD, 12));
		input.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String binary1 = input.getText();
				try {
					doCommand(binary1);

					int i = Integer.parseInt(binary1); // hex to decimal
					String binary = Integer.toBinaryString(i); // decimal to
																// binary
					/**
					 * System.out.println("This is Binary: " + binary);
					 */
					try {
						input.setText("");
					} catch (Exception ex) {
					}

					data.setText("");
					data.setText(binary);
					input.selectAll();
					output.setText("");
					doCommand(binary1);
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(
							null,
							"Error: -->: "
									+ ex.getMessage()
									+ " |Please put digits as numbers do not work",
							"Alert", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		output = new JTextField();
		output.setEditable(true);
		output.setBounds(10, 130, 150, 25);
		output.setForeground(Color.BLACK);
		output.setCaretColor(Color.RED);
		output.setOpaque(true);
		output.setFont(new Font("Courier New", Font.BOLD, 12));
		output.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String binary2 = output.getText();
				try {
					doCommand(binary2);

					int i = Integer.parseInt(binary2); // hex to decimal
					String binary3 = Integer.toHexString(i); // decimal to
																// binary
					try {
						output.setText("");
					} catch (Exception ex) {
					}
					data.setText("");
					data.setText(binary3);
					output.selectAll();
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

		title = new JLabel();
		title.setText("10| Binary And Hex |01");
		title.setFont(new Font("Courier New", Font.BOLD, 15));
		title.setForeground(Color.BLACK);
		title.setBounds(5, 5, 500, 20);
		title.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				data.setText("Watcha looking at ya big baby?");

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

		});

		titleText = new JLabel();
		titleText.setText("");

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(540, 250, 100, 50);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainLoader();
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

		JButton btnGen = new JButton("1 - 2");
		btnGen.setBounds(10, 168, 90, 25);
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
					output.setText("");
				}

				catch (Exception ex) {
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

		JButton btnGen2 = new JButton("2 - 1");
		btnGen2.setBounds(100, 168, 90, 25);
		btnGen2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String binary2 = output.getText();
				try {
					doCommand(binary2);
					int i = Integer.parseInt(binary2); // hex to decimal
					String binary3 = Integer.toHexString(i); // decimal to
																// binary
					try {
						output.setText("");
					} catch (Exception ex) {
					}
					data.setText("");
					data.setText(binary3);
					output.selectAll();
					input.setText("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(
							null,
							"Error: "
									+ ex.getMessage()
									+ " Please put digits as numbers do not work",
							"Alert", JOptionPane.ERROR_MESSAGE);
				}
				output.selectAll();
			}
		});

		// Choices
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Bin", "Hex" }));
		comboBox.setBounds(100, 50, 70, 24);
		frame.getContentPane().add(comboBox);

		frame.getContentPane().add(btnGen2);

		frame.add(input, BorderLayout.SOUTH);
		frame.add(output, BorderLayout.SOUTH);
		frame.add(data, BorderLayout.SOUTH);
		frame.getContentPane().add(title);
		frame.setSize(frameSx, frameSy);
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
		}

		catch (Exception ex) {

		}
	}
}