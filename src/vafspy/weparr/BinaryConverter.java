package vafspy.weparr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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

import vafspy.weparr.customCode.Draggable;

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
	public Color textColor = Color.decode("#eeeeee");
	public JButton btnQuit, btnBack;

	public static void main(String[] args) {
		new BinaryConverter();
	}

	public BinaryConverter() {
		frame = new JFrame();
		frame.setTitle("Binary Converter v1.5");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true); // my favorite piece of code

		frame.setSize(660, 380);

		try {
			if (Features.nimbus()) {
				for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
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
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
			}
		}

		title = new JLabel();
		title.setText("10| Binary And Hex |01");
		title.setFont(new Font("Sans Serif", Font.BOLD, 35));
		title.setForeground(textColor);
		title.setBounds(78, 10, 500, 100);

		data = new JTextPane();
		data.setEditable(false);
		data.setBounds(78, 230, 450, 100);
		data.setText("Your answer will go here");
		data.setForeground(Color.BLACK);
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
					int i = Integer.parseInt(binary1); // hex to decimal
					binary = Integer.toBinaryString(i); // decimal to binary
					input.setText("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Error: -->: " + ex.getMessage() + " |Please enter numbers as digits, words do not work.",
							"Conversion Error.", JOptionPane.ERROR_MESSAGE);
				}
				data.setText("");
				data.setText(binary);
				input.selectAll();
				input2.setText("");
			}
		});

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
					calculateHex(binary2);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Error: " + ex.getMessage() + " Please put digits as numbers do not work", "Alert",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		bin = new JLabel("dec->bin");
		bin.setBounds(78, 104, 70, 15);
		bin.setForeground(textColor);

		bin2 = new JLabel("hex->dec");
		bin2.setBounds(300, 104, 80, 30);
		bin2.setForeground(textColor);

		btnBack = new JButton("Back");
		btnBack.setBounds(frame.getWidth() - 200, 0, 100, 30);
		btnBack.setOpaque(true);
		btnBack.setBorder(null);
		btnBack.setBackground(Color.decode("#555555"));
		btnBack.setForeground(textColor);

		btnBack.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnBack.setBackground(Color.decode("#555555"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnBack.setBackground(Color.decode("#444444"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainLoader();
				frame.dispose();
			}
		});

		frame.add(btnBack);

		btnQuit = new JButton("Quit");
		btnQuit.setBounds(frame.getWidth() - 100, 0, 100, 30);
		btnQuit.setOpaque(true);
		btnQuit.setBorder(null);
		btnQuit.setBackground(Color.decode("#ff6666"));
		btnQuit.setForeground(textColor);

		btnQuit.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnQuit.setBackground(Color.decode("#ff6666"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnQuit.setBackground(Color.decode("#444444"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

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
					calculateBin(binary1);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Error: " + ex.getMessage() + "Please put digits as numbers do not work", "Alert",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnGen2 = new JButton("Generate Hex");
		btnGen2.setBounds(300, 168, 150, 25);
		btnGen2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String binary2 = input2.getText();
				try {
					calculateHex(binary2);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Error: " + ex.getMessage() + " Please put digits as numbers do not work", "Alert",
							JOptionPane.ERROR_MESSAGE);
				}
				input2.selectAll();
			}
		});

		frame.getContentPane().add(btnGen);
		frame.getContentPane().add(btnGen2);
		frame.add(input, BorderLayout.SOUTH);
		frame.add(input2, BorderLayout.SOUTH);
		frame.add(data, BorderLayout.SOUTH);
		frame.getContentPane().add(title);
		frame.getContentPane().add(bin);
		frame.getContentPane().add(bin2);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.decode("#333333"));

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		new Draggable(frame); // make a new draggable instance
	}

	void calculateHex(String binary2) {
		int i = Integer.parseInt(binary2); // hex to decimal
		String binary3 = Integer.toHexString(i); // decimal to

		input2.setText("");
		data.setText("");
		data.setText(binary3);
		input2.selectAll();
		input.setText("");
	}

	void calculateBin(String binary1) {
		int i = Integer.parseInt(binary1); // hex to decimal
		String binary = Integer.toBinaryString(i); // decimal to
													// binary
		input.setText("");
		data.setText("");
		data.setText(binary);
		input.selectAll();
		input2.setText("");
	}
}