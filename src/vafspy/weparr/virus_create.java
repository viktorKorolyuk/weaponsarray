package vafspy.weparr;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.text.StyledDocument;

public class virus_create {
	public JFrame frame;

	public JLabel bin;
	public JLabel title;
	public JLabel bin2;
	public JTextPane data;
	public JTextField input;
	public JTextField input2;
	public StyledDocument document;
	public JComboBox<String> choices;

	public static void main(String[] args) {
		new virus_create();
	}

	public virus_create() {
		frame = new JFrame();
		frame.setTitle("'Hacks'");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception ex) {
				}
		}

		data = new JTextPane();
		data.setEditable(false);
		data.setOpaque(true);
		data.setFont(new Font("Courier New", Font.BOLD, 12));

		title = new JLabel();
		title.setText("Virus Creator");
		title.setFont(new Font("Courier New", Font.BOLD, 20));
		title.setBounds(70, 10, 700, 100);

		ImageIcon Logo = new ImageIcon("src/icon.png");

		JButton quit = new JButton();
		quit.setText("Quit");
		quit.setBounds(500, 310, 90, 30);
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.add(quit);

		JButton logo = new JButton(Logo);
		logo.setEnabled(true);
		logo.setBounds(400, 50, 185, 200); // x ,y , hight, length
		logo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"This Aplication Was Created By r0ut3rK3y", "Alert",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JButton register = new JButton();
		register.setText("Create");
		register.setEnabled(true);
		register.setBounds(170, 300, 200, 40); // x ,y , height, length
		register.setLocation(100, 300);
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new virus();
				frame.dispose();
			}
		});
		frame.add(title);
		frame.add(logo);
		frame.add(register);
		frame.add(data);
		frame.setSize(660, 370);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

	}

}
