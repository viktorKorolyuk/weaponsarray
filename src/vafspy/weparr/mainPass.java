package vafspy.weparr;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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

import vafspy.weparr.components.NoisePanel;

public class mainPass {
	public JFrame frame;

	public JLabel bin;
	public JLabel title;
	public JLabel bin2;
	public JTextPane data;
	public JTextField input;
	public JTextField input2;
	public StyledDocument document;
	public JComboBox<String> choices;
	JPanel main = new JPanel();

	public static void main(String[] args) {
		new mainPass();
	}

	public mainPass() {
		frame = new JFrame();
		frame.setTitle("Weapons array");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(main);
		main.setLayout(null);

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

		data = new JTextPane();
		data.setEditable(false);
		data.setOpaque(true);
		data.setFont(new Font("Courier New", Font.BOLD, 12));

		title = new JLabel();
		title.setText("Weapon Array");
		title.setFont(new Font("Courier New", Font.BOLD, 20));
		title.setBounds(70, 10, 700, 100);
		title.setForeground(Color.white);

		JButton quit = new JButton();
		quit.setText("Quit");
		quit.setBounds(500, 310, 90, 30);
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		main.add(quit);

		JButton logo = new JButton();
		try {
			Image img = ImageIO.read(this.getClass().getResource(
					"/resources/icon.png"));
			logo.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		logo.setEnabled(true);
		logo.setBounds(400, 50, 185, 200); // x ,y , height, length
		logo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"This Aplication Was Created By r0ut3rK3y", "Alert",
						JOptionPane.INFORMATION_MESSAGE);

			}

		});

		JButton register = new JButton();
		register.setText("Register 'Hacks'");
		register.setEnabled(true);
		register.setBounds(170, 300, 200, 40); // x ,y , hight, length
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch ((String) choices.getSelectedItem()) {
				case "Two-way Converter":
					new ConverterTwoWay();
					frame.dispose();
					break;
				case "System Info":
					SystemInfo.main(new String[1]);
					frame.dispose();
					break;
				case "Calculator":
					new CalculatorPage();
					frame.dispose();
					break;
				case "Console":
					new Console();
					frame.dispose();
					break;
				case "Fork Bomb":
					new virus2();
					frame.dispose();
					break;
				case "Virus":
					JOptionPane
							.showMessageDialog(
									null,
									"This Is VERY dangerous if handled incorrectly \n and I am not Responsible for any damage done",
									"Alert", JOptionPane.INFORMATION_MESSAGE);
					new virus_create();
					frame.dispose();
					break;
				case "Binary Converter v2":
					new BinaryConverter2();
					frame.dispose();
					break;
				case "Letters-In-Phone-Numbers Decoder":
					new PhoneNumberCoder();
					frame.dispose();
					break;
				default:
					break;
				}
			}
		});

		choices = new JComboBox<String>();
		ArrayList<String> modeltemp = new ArrayList<String>();
		modeltemp.add("Choose:");
		modeltemp.add("System Info");
		modeltemp.add("Two-way Converter");
		if (Boolean.parseBoolean(Features.getProperty("legacy"))) {
			modeltemp.add("Binary to ...");
			if (Boolean.parseBoolean(Features.getProperty("notworking"))) {
				modeltemp.add("Binary Converter v2");
			}
		}
		modeltemp.add("Calculator");
		modeltemp.add("Console");
		modeltemp.add("Letters-In-Phone-Numbers Decoder");
		if (Boolean.parseBoolean(Features.getProperty("fakevirus"))) {
			modeltemp.add("Fork Bomb");
			modeltemp.add("Virus");
			if (Boolean.parseBoolean(Features.getProperty("notworking"))) {
				modeltemp.add("Dos/DDos (Not working)");
			}
		}
		choices.setModel(new DefaultComboBoxModel<String>(modeltemp
				.toArray(new String[0])));
		choices.setBounds(56, 100, 300, 20);
		choices.setOpaque(true);

		choices.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		main.add(choices);
		main.add(title);
		main.add(logo);
		main.add(register);
		main.add(data);
		frame.setSize(660, 380);
		main.setBackground(new Color(163, 163, 163));
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
