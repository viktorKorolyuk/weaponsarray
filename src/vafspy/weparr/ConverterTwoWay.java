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

import vafspy.weparr.cnvlib.Converter;

public class ConverterTwoWay extends JFrame implements ActionListener{
	// Add a serialVersionUID: Takes care of those pesky warnings!
	private static final long serialVersionUID = 1L;
	
		Converter cnv = new Converter();
	
		// Define JFrame elements
		// First, the JPanel
		JPanel pnl = new JPanel();
		// Now, add the drop-downs area.
		JLabel typelabel = new JLabel("Conversion:");
		JComboBox<String> frombox = new JComboBox<String>(new String[]{"bin","hex","dec","oct"});
		JLabel tolabel = new JLabel("to");
		JComboBox<String> tobox = new JComboBox<String>(new String[]{"bin","hex","dec","oct"});
		JLabel fromfieldtxt = new JLabel("Data to convert:");
		JTextField fromtext = new JTextField(10);
		// Now, the convert button!
		JButton convertbtn = new JButton("---  ---  ---  CONVERT  ---  ---  ---");
		// Construction time! (this is the constructor)
	public ConverterTwoWay() {
		super("Two-way Converter");
		setSize(250, 90);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		        new mainPass();
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
		JOptionPane.showMessageDialog(this,
			    "Original(in " + frombox.getSelectedItem() + "): " + fromtext.getText() + "  Converted to " + tobox.getSelectedItem() + ": " + cnv.convert((String)frombox.getSelectedItem(), (String)tobox.getSelectedItem(), fromtext.getText()),
			    "Conversion results",
			    JOptionPane.PLAIN_MESSAGE);
	}
}
