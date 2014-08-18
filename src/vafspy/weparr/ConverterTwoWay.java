package vafspy.weparr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import vafspy.weparr.cnvlib.Converter;

public class ConverterTwoWay extends JFrame implements ActionListener {
	// Add a serialVersionUID: Takes care of those pesky warnings!
	private static final long serialVersionUID = 1L;

	Converter cnv = new Converter();

	// Define JFrame elements
	// First, the JPanel
	JPanel pnl = new JPanel();
	// Now, add the drop-downs area.
	JLabel typelabel = new JLabel("Conversion:");
	JComboBox<String> frombox = new JComboBox<String>(new String[] { "bin",
			"hex", "dec", "oct" });
	JLabel tolabel = new JLabel("to");
	JComboBox<String> tobox = new JComboBox<String>(new String[] { "bin",
			"hex", "dec", "oct" });
	JLabel fromfieldtxt = new JLabel("Data to convert:");
	JTextField fromtext = new JTextField(10);
	// Now, the convert button!
	JButton convertbtn = new JButton("---  ---  ---  CONVERT  ---  ---  ---");

	// Construction time! (this is the constructor)
	public ConverterTwoWay() {
		super("Two-way Converter");
		setSize(250, 95);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		try {
			if(Features.nimbus()) {
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
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new MainLoader();
			}
		});

		// Add a JPanel
		add(pnl);
		// Now add the contents.
		pnl.add(typelabel);
		pnl.add(frombox);
		pnl.add(tolabel);
		pnl.add(tobox);
		pnl.add(fromfieldtxt);
		pnl.add(fromtext);
		pnl.add(convertbtn);
		convertbtn.addActionListener(this);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ConverterTwoWay();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// Convert and show!
		try {
			String converted = cnv.convert((String) frombox.getSelectedItem(), (String) tobox.getSelectedItem(), fromtext.getText());
			JOptionPane.showMessageDialog(this, "Original(in " + frombox.getSelectedItem() + "): " + fromtext.getText() + "  Converted to " + tobox.getSelectedItem() + ": " + converted, "Conversion results", JOptionPane.PLAIN_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Number formatting error! Number may be too long or in incorrect format.", "Conversion Error.", JOptionPane.ERROR_MESSAGE);
		}
	}
}
