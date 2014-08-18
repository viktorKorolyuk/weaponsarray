package vafspy.weparr;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class SecondLauncher extends JFrame {
	private static final long serialVersionUID = 1L;

	JPanel pnl = new JPanel();

	JComboBox<String> selection = new JComboBox<String>();
	JButton launch = new JButton("Launch");
	JButton help = new JButton("Help/About");
	JEditorPane area;

	public void loadOptions() {
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
		selection.setModel(new DefaultComboBoxModel<String>(modeltemp
				.toArray(new String[0])));
	}

	public SecondLauncher() {
		super("Weapons Array");
		setSize(500, 36);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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

		add(pnl);
		loadOptions();
		pnl.add(selection);
		launch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch ((String) selection.getSelectedItem()) {
				case "Two-way Converter":
					new ConverterTwoWay();
					dispose();
					break;
				case "System Info":
					SystemInfo.main(new String[1]);
					dispose();
					break;
				case "Calculator":
					new CalculatorPage();
					dispose();
					break;
				case "Console":
					new Console();
					dispose();
					break;
				case "Fork Bomb":
					new virus2();
					dispose();
					break;
				case "Virus":
					JOptionPane
							.showMessageDialog(
									null,
									"This Is VERY dangerous if handled incorrectly \n and I am not Responsible for any damage done",
									"Alert", JOptionPane.INFORMATION_MESSAGE);
					new virus_create();
					dispose();
					break;
				case "Binary Converter v2":
					new BinaryConverter2();
					dispose();
					break;
				case "Letters-In-Phone-Numbers Decoder":
					new PhoneNumberCoder();
					dispose();
					break;
				default:
					break;
				}

			}

		});
		pnl.add(launch);
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SecondLauncherInfo();

			}

		});
		pnl.add(help);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SecondLauncher();

	}

}

class SecondLauncherInfo extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel pnl = new JPanel();
	JEditorPane area = new JEditorPane();
	JScrollPane scrolltext = new JScrollPane(area);

	public SecondLauncherInfo() {
		super("Help/Info");
		setSize(500, 250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		area.setEditorKit(JEditorPane
				.createEditorKitForContentType("text/html"));
		area.setEditable(false);
		area.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						URI u;
						try {
							u = e.getURL().toURI();
							desktop.browse(u);
						} catch (IOException | URISyntaxException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		java.net.URL infourl = getClass()
				.getResource("/resources/infodoc.html");
		if (infourl != null) {
			try {
				area.setPage(infourl);
			} catch (IOException e) {
				System.err.println("Can't read help file.");
			}
		} else {
			System.err.println("Can't read help file.");
		}
		add(scrolltext);
		setVisible(true);
	}
}
