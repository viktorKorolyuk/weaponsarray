package vafspy.weparr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Test javadoc comment lol.
 * 
 * @author viktor
 *
 */
public class Console {
	public static void main(String[] args) {
		new Console();
	}

	public JFrame frame;
	public JTextPane console;
	public JTextField input;
	public JScrollPane scrollpane;

	public StyledDocument document;

	boolean trace = false;

	public Console() {
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

		frame = new JFrame();
		frame.setTitle("Console");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		console = new JTextPane();
		console.setEditable(false);
		console.setFont(new Font("Courier New", Font.BOLD, 12));
		console.setOpaque(false);

		document = console.getStyledDocument();

		input = new JTextField();
		input.setEditable(true);
		input.setBackground(new Color(50, 50, 50));
		input.setForeground(Color.white);
		input.setCaretColor(Color.GREEN);
		input.setOpaque(false);
		input.setFont(new Font("Courier New", Font.BOLD, 12));

		input.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String text = input.getText();

				if (text.length() > 1) {
					print(text + "\n", false, new Color(255, 0, 0));
					doCommand(text);
					input.selectAll();
				}
			}
		});
		input.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

		});
		scrollpane = new JScrollPane(console);
		scrollpane.setBorder(null);
		scrollpane.setOpaque(false);
		scrollpane.getViewport().setOpaque(false);

		frame.add(input, BorderLayout.SOUTH);
		frame.add(scrollpane, BorderLayout.CENTER);
		frame.getContentPane().setBackground(new Color(50, 50, 50));

		frame.setSize(660, 350);
		frame.setLocationRelativeTo(null);

		frame.setResizable(false);
		frame.setVisible(true);

		// Starting Message

		println("Starting Console ", trace, new Color(255, 0, 0));
		println("Console Started \n ", trace, new Color(0, 200, 0));
		println("Enter command to start: ", trace, new Color(0, 200, 0));
		try {

			String username = System.getProperty("user.name");
			String ip = InetAddress.getLocalHost().getHostAddress();

			System.out.println(username + "'s Ip: " + ip);
		} catch (Exception ex) {
		}
	}

	public void scrollTop() {
		console.setCaretPosition(0);
	}

	public void scrollBottom() {
		console.setCaretPosition(console.getDocument().getLength());
	}

	public void print(String s, boolean trace) {
		print(s, trace, new Color(255, 255, 255));
	}

	public void print(String s, boolean trace, Color c) {
		Style style = console.addStyle("Style", null);
		StyleConstants.setForeground(style, c);

		if (trace) {
			Throwable t = new Throwable();
			StackTraceElement[] elements = t.getStackTrace();
			String caller = elements[0].getClassName();

			s = caller + "-->" + s;
		}

		try {
			document.insertString(document.getLength(), s, style);
		} catch (Exception ex) {
		}
	}

	public void println(String s, boolean trace) {
		println(s, trace, new Color(255, 255, 255));
	}

	public void println(String s, boolean trace, Color c) {
		print(s + "\n", trace, c);
	}

	public void clear() {
		try {
			document.remove(0, document.getLength());
		} catch (Exception ex) {
		}

	}

	public void help() {
		println("Help: ", trace, new Color(0, 200, 0));
	}

	public void getip() {
		try {
			// reference:
			// http://stackoverflow.com/questions/2939218/getting-the-external-ip-address-in-java
			URL whatismyip = new URL("http://htmlguy.cu.cc/ip_finder_for_weaponsarray.php");
			BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
			String ip = in.readLine();
			// reference:
			// http://stackoverflow.com/questions/8765578/get-local-ip-address-without-connecting-to-the-internet
			System.out.println("second");
			Socket s = new Socket("google.ca", 80);
			String ip2 = s.getLocalAddress().getHostAddress();
			s.close();
			String ip3 = InetAddress.getLoopbackAddress().getHostAddress();
			String ip4 = InetAddress.getLoopbackAddress().getCanonicalHostName();

			String username = System.getProperty("user.name");
			System.out.println(username);
			System.out.println("find ip: " + ip);
			println("\n Found your IP addresses: ", trace, new Color(0, 200, 0));
			println("Remote IP: " + ip, trace, new Color(0, 200, 0));
			println("local LAN IP: " + ip2, trace, new Color(0, 200, 0));
			println("localhost IP: " + ip3, trace, new Color(0, 200, 0));
			println("localhost name: " + ip4, trace, new Color(0, 200, 0));

			// Print IPs found to file!
			try (PrintStream outiplog = new PrintStream(
					new FileOutputStream("/home/" + username + "/Desktop/iplog.txt"))) {
				outiplog.println("\n Found your IP addresses: ");
				outiplog.println("Remote IP: " + ip);
				outiplog.println("local LAN IP: " + ip2);
				outiplog.println("localhost IP: " + ip3);
				outiplog.println("localhost name: " + ip4);
				outiplog.close();
			}
		} catch (Exception ex) {
			println("Error -->" + ex.getMessage(), trace, new Color(255, 155, 155));

		}
	}

	public void hack() {
		println("Started Hacking interface", trace, new Color(255, 255, 255));
	}

	public void doCommand(String s) {

		final String[] commands = s.split(" ");

		try {
			if (commands[0].equalsIgnoreCase("clear")) {
				clear();
			}

			if (commands[0].equalsIgnoreCase("cls")) {
				clear();
			}
			if (commands[0].equalsIgnoreCase("getip")) {
				getip();
			}
			if (commands[0].equalsIgnoreCase("help")) {
				help();
			}
			if (commands[0].equalsIgnoreCase("hack")) {
				hack();
			}
			if (commands[0].equalsIgnoreCase("what_is_your_opinion_on_me?")) {
				clear();
				frame.setSize(700, 700);
				println("You are a big MEANIE, and she is very Selfish", trace, new Color(255, 0, 0));
				input.setVisible(true);
			} else if (commands[0].equalsIgnoreCase("popup")) {
				String message = "";

				for (int i = 1; i < commands.length; i++) {
					message += commands[1];

					if (i != commands.length - 1) {
						message += " ";
					}
				}
				JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
				println(" \n \nPopup Generated:", trace);
			}
		}

		catch (Exception ex) {
			println("Error -->" + ex.getMessage(), trace, new Color(255, 155, 155));
			println("Do 'help' for commands", trace);
		}
	}

}
