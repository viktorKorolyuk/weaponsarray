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

import vafspy.weparr.customCode.Draggable;

public class BinaryConverter extends JFrame {
	// Add a serialVersionUID: Takes care of those pesky warnings!
	private static final long serialVersionUID = 1L;
	public JComboBox<String> comboBox;
	public JLabel bin;
	public JLabel title;
	public JLabel bin2;
	public JPanel main;
	public JTextPane data;
	public JTextField input;
	public JTextField input2;
	public Color textColor = Color.decode("#eeeeee");
	public JButton btnQuit, btnBack;

	public static void main(String[] args) {
		new BinaryConverter();
	}

	public BinaryConverter() {
		setTitle("Binary Converter v1.5");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setUndecorated(true); // my favorite piece of code

		setSize(660, 380);

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
		title.setFont(new Font("Sans Serif", Font.PLAIN, 35));
		title.setForeground(textColor);
		title.setBounds(78, 10, 500, 100);

		data = new JTextPane();
		data.setEditable(false);
		data.setBounds(78, 230, 450, 100);
		data.setText("Your answer will go here");
		data.setForeground(Color.BLACK);
		data.setBackground(Color.WHITE);
		data.setFont(new Font("Sans-Serif", Font.PLAIN, 12));
		data.setOpaque(true);

		input = new JTextField();
		input.setEditable(true);
		input.setCaretColor(Color.BLUE);
		input.setBounds(78, 131, 194, 25);
		input.setForeground(Color.BLACK);
		input.setCaretColor(Color.RED);
		input.setOpaque(true);
		input.setFont(new Font("Courier New", Font.PLAIN, 12));
		input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String binary1 = input.getText();
				calculateBin(binary1);
			}
		});

		input2 = new JTextField();
		input2.setEditable(true);
		input2.setBounds(300, 131, 194, 25);
		input2.setForeground(Color.BLACK);
		input2.setCaretColor(Color.RED);
		input2.setOpaque(true);
		input2.setFont(new Font("Courier New", Font.PLAIN, 12));
		input2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String binary2 = input2.getText();
				try {
					calculateHex(binary2);
				} catch (Exception ex) {
					showErrorMessage(ex);
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
		btnBack.setBounds(getWidth() - 200, 0, 100, 30);
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
				dispose();
			}
		});

		add(btnBack);

		btnQuit = new JButton("Quit");
		btnQuit.setBounds(getWidth() - 100, 0, 100, 30);
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
				dispose();
			}
		});

		add(btnQuit);

		JButton btnGen = new JButton("Generate Binary");
		btnGen.setBounds(77, 168, 150, 25);
		btnGen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String binary1 = input.getText();
				try {
					calculateBin(binary1);
				} catch (Exception ex) {
					showErrorMessage(ex);
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
					showErrorMessage(ex);
				}
				input2.selectAll();
			}
		});

		getContentPane().add(btnGen);
		getContentPane().add(btnGen2);
		add(input, BorderLayout.SOUTH);
		add(input2, BorderLayout.SOUTH);
		add(data, BorderLayout.SOUTH);
		getContentPane().add(title);
		getContentPane().add(bin);
		getContentPane().add(bin2);
		setResizable(false);
		setVisible(true);
		getContentPane().setBackground(Color.decode("#333333"));

		// Center the JFrame
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

		// Make a new Draggable instance to allow user to drag JFrame around environment
		new Draggable(this);

	}

	void calculateHex(String binary2) {
		int i = Integer.parseInt(binary2); // hex to decimal
		String binary3 = Integer.toHexString(i); // decimal to

		input2.setText("");
		data.setText(binary3);
		input2.selectAll();
		input.setText("");
	}

	void calculateBin(String binary1) {
		int i = Integer.parseInt(binary1); // hex to decimal
		String binary = Integer.toBinaryString(i); // decimal to
													// binary
		input.setText("");
		data.setText(binary);
		input.selectAll();
		input2.setText("");
	}

	private void showErrorMessage(Exception ex) {
		JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage() + ". Verify input is valid", "Alert",
				JOptionPane.ERROR_MESSAGE);
	}
}