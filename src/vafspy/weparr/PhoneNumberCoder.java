package vafspy.weparr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class PhoneNumberCoder extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel pnl = new JPanel();
	JLabel inlbl = new JLabel("Input Phone #:");
	JTextField in = new JTextField(30);
	JButton go = new JButton("Decode!");

	public PhoneNumberCoder() {
		super("Letters-In-Phone-Numbers Decoder");
		setSize(560, 50);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new mainPass();
			}
		});
		add(pnl);
		pnl.add(inlbl);
		pnl.add(in);
		pnl.add(go);
		go.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String d = decode(in.getText());
					JOptionPane
							.showMessageDialog(
									null,
									"Success decoding phone number!\n" +
									"Original: " + in.getText() + "\n" +
									"Decoded: " + d,
									"Decoded!",
									JOptionPane.ERROR_MESSAGE);
				} catch (Exception err) {
					err.printStackTrace();
					JOptionPane
							.showMessageDialog(
									null,
									"There was an error decoding the phone number! It may be invalid or use" +
									"wierd characters. printing stack trace to terminal.",
									"ERROR!",
									JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		setVisible(true);

	}

	public String decode(String number) {
		String str = number.replaceAll("-", "");
		String reconstructed = "";
		for (String retval : str.split("")) {
			String regx = retval.replaceAll("[a-zA-Z]", "is_a_letter");
			if (regx.equals("is_a_letter")) {
				// Convert this one
				switch (retval.toLowerCase()) {
				case "a":
				case "b":
				case "c":
					reconstructed += "2";
					break;
				case "d":
				case "e":
				case "f":
					reconstructed += "3";
					break;
				case "g":
				case "h":
				case "i":
					reconstructed += "4";
					break;
				case "j":
				case "k":
				case "l":
					reconstructed += "5";
					break;
				case "m":
				case "n":
				case "o":
					reconstructed += "6";
					break;
				case "p":
				case "q":
				case "r":
				case "s":
					reconstructed += "7";
					break;
				case "t":
				case "u":
				case "v":
					reconstructed += "8";
					break;
				case "w":
				case "x":
				case "y":
				case "z":
					reconstructed += "9";
					break;
				default:
					break;
				}
			} else {
				reconstructed += retval;
			}
		}
		if (reconstructed.length() == 10) {
			reconstructed = reconstructed.substring(0, 3) + "-"
					+ reconstructed.substring(3, 6) + "-"
					+ reconstructed.substring(6, 10);
		} else if (reconstructed.length() == 11
				&& reconstructed.startsWith("1")) {
			reconstructed = "1-" + reconstructed.substring(1, 4) + "-"
					+ reconstructed.substring(4, 7) + "-"
					+ reconstructed.substring(7, 11);
		}
		return reconstructed;
	}

	public static void main(String[] args) {
		new PhoneNumberCoder();
	}

}
