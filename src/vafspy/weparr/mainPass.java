package vafspy.weparr;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.StyledDocument;




public class mainPass
{
	public JFrame frame;

	public JLabel bin;
	public JLabel title;
	public JLabel bin2;
//	public JPanel main;
	public JTextPane data;
	public JTextField input;
	public JTextField input2;
	//public JScrollPane scrollpane;
	public StyledDocument document;
	public JComboBox<String> choices;
	
	public static void main(String[] args){
		new mainPass();
	}
	
public mainPass() {
	frame = new JFrame();
	frame.setTitle("Weapons array");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}catch(Exception ex){}
	
	//frame.setSize(5, 5);
	data = new JTextPane();
	data.setEditable(false);
	data.setOpaque(true);
	data.setFont(new Font("Courier New", Font.BOLD, 12));
	
	title = new JLabel();
	title.setText("Weapon Array");
	title.setFont(new Font("Courier New", Font.BOLD, 20));
	title.setBounds(70,10, 700, 100);
	
	
	
	JButton quit = new JButton();
	quit.setText("Quit");
	quit.setBounds(500, 310, 90, 30);
	quit.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e)
		{frame.dispose();}});
	frame.add(quit);
	
	
	JButton logo = new JButton();
	try {
		Image img = ImageIO.read(this.getClass().getResource("/resources/icon.png"));
		logo.setIcon(new ImageIcon(img));
	} catch (IOException ex) {
	}
	//logo.setText("Register 'Hacks'");
	logo.setEnabled(true);
	logo.setBounds(400,50,185,200); // x ,y , height, length
	logo.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "This Aplication Was Created By r0ut3rK3y", "Alert", JOptionPane.INFORMATION_MESSAGE);
			//frame.dispose();
			
		}
		
	});
	
	JButton register = new JButton();
	register.setText("Register 'Hacks'");
	register.setEnabled(true);
	register.setBounds(170,300,200,40); // x ,y , hight, length
	register.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch((String)choices.getSelectedItem()) {
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
				JOptionPane.showMessageDialog(null, "This Is VERY dangerous if handled incorrectly \n and I am not Responsible for any damage done", "Alert", JOptionPane.INFORMATION_MESSAGE);
				new virus_create();
				frame.dispose();
				break;
			default:
				break;
			}
		}
	});
	
	choices = new JComboBox<String>();
	choices.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose:","System Info","Two-way Converter","Binary to ...","Calculator","Console","DoS/DDos (Not working)","Fork Bomb","Virus"}));
	choices.setBounds(56, 100, 300, 20);
	choices.setOpaque(true);
	
	choices.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
	});
		frame.add(choices);
		frame.add(title);
		frame.add(logo);
		frame.add(register);
		frame.add(data);
	frame.setSize(660, 380);
	frame.getContentPane().setBackground(new Color(163,163,163));
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	frame.setVisible(true);
	}
	
}
