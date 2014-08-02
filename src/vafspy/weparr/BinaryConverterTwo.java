package vafspy.weparr;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.*;

public class BinaryConverterTwo implements ActionListener{

	private JFrame binconv;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BinaryConverterTwo window = new BinaryConverterTwo();
					window.binconv.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BinaryConverterTwo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		binconv = new JFrame();
		binconv.setTitle("BinConv 2");
		binconv.setBounds(100, 100, 200, 168);
		binconv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		binconv.getContentPane().setLayout(null);
		try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}catch(Exception ex){}
		JLabel lblNewLabel = new JLabel("10| Binary + Hex\n |01");
		lblNewLabel.setBounds(9, 10, 285, 26);
		lblNewLabel.setFont(new Font("Courier 10 Pitch", Font.BOLD, 13));
		binconv.getContentPane().add(lblNewLabel);
		
		JLabel lblDecimalTo = new JLabel("Decimal To:");
		lblDecimalTo.setFont(new Font("Dialog", Font.BOLD, 13));
		lblDecimalTo.setBounds(13, 40, 92, 15);
		binconv.getContentPane().add(lblDecimalTo);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Bin", "Hex"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(106, 35, 76, 24);
		binconv.getContentPane().add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(9, 103, 170, 26);
		binconv.getContentPane().add(textField_1);
		textField_1.setEditable(false);
		
		textField = new JTextField();
		textField.setBounds(9, 64, 170, 26);
		binconv.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String type = (String)comboBox.getSelectedItem();
				boolean docontinue = true;
				try { 
			        Integer.parseInt(textField.getText()); 
			    } catch(NumberFormatException err) { 
			    	JOptionPane.showMessageDialog(null,"Error: " + err.getMessage() + "Please put digits as numbers do not work", "Alert", JOptionPane.ERROR_MESSAGE);
			    	docontinue = false;
			    }
				if(docontinue){
					switch (type) {
					case "Bin":
						textField_1.setText(Integer.toBinaryString(Integer.parseInt(textField.getText())));
						break;
					case "Hex":
						textField_1.setText(Integer.toHexString(Integer.parseInt(textField.getText())));
						break;
					default:
						break;
					}
				}
			}
			
		});
		
		JLabel lblNewLabel_1 = new JLabel("↓");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel_1.setBounds(83, 89, 70, 15);
		binconv.getContentPane().add(lblNewLabel_1);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(this);
		btnQuit.setBounds(12, 130, 70, 25);
		binconv.getContentPane().add(btnQuit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		btnBack.setBounds(100, 130, 76, 25);
		binconv.getContentPane().add(btnBack);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Quit") {
			binconv.dispose();
		} else if(e.getActionCommand() == "Back") {
			new mainPass();
			binconv.dispose();
		}
	}
}
