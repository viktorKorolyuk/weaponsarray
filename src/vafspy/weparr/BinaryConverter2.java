package vafspy.weparr;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.text.StyledDocument;


public class BinaryConverter2 extends JFrame {
	// Add a serialVersionUID: Takes care of those pesky warnings!
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	public JComboBox<String> comboBox;
	public JLabel bin;
	public JLabel title;
	public JLabel bin2;
	public JPanel main;
	public JTextPane data;
	public JTextField input;
	public JTextField input2;
	//public JScrollPane scrollpane;
	public StyledDocument document;
	public static void main(String[] args)
	{
		new BinaryConverter2();
		}
		public BinaryConverter2()
		{	frame = new JFrame();
			frame.setTitle("Binary Converter v1.5");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}catch(Exception ex){}
		
			data = new JTextPane();
			data.setEditable(false);
			data.setBounds(78, 230, 450, 100);
			data.setText("Your answer will go here");
			//	data.setSize(5,5);
			data.setForeground(Color.BLUE);
			data.setBackground(Color.WHITE);
	//		data.setBorder(border);
		data.setFont(new Font("Courier New", Font.BOLD, 12));
		data.setOpaque(true);
		
		//document = data.getStyledDocument();
		
		input = new JTextField();
		input.setEditable(true);
		input.setCaretColor(Color.BLUE);
		input.setBounds(78, 131, 194, 25);
		input.setForeground(Color.BLACK);
		input.setCaretColor(Color.RED);
		input.setOpaque(true);
		input.setFont(new Font("Courier New", Font.BOLD, 12));
		input.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String binary1 = input.getText();
				try{
					  doCommand(binary1);
					
				    int i = Integer.parseInt(binary1);               //hex to decimal
				    String binary = Integer.toBinaryString(i);       //decimal to binary
				    /**
				    System.out.println("This is Binary: " + binary);
				    */
				    try {input.setText("");}
				    catch (Exception ex) {}
				  
				    data.setText("");
				    data.setText(binary);
				input.selectAll();
				input2.setText("");
				 doCommand(binary1);
				}
				
				catch(Exception ex) {
					 JOptionPane.showMessageDialog(null,"Error: -->: " + ex.getMessage() + " |Please put digits as numbers do not work", "Alert", JOptionPane.ERROR_MESSAGE);
				 }
			}	
		});
		//input.getText();
		
		
		title = new JLabel();
		title.setText("10| Binary And Hex |01");
		title.setFont(new Font("Courier New", Font.BOLD, 35));
		title.setForeground(Color.BLACK);
		title.setBounds(78, 10, 500, 100);
		title.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				data.setText("Watcha looking at ya big baby?");
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		input2 = new JTextField();
		input2.setEditable(true);
		input2.setBounds(300, 131, 194, 25);
		//input.setSize(120, 20);
		//input.setBorder(null);
		
		//input.getContentPane().setBackground(new Color(50,50,50));
		
		//input2.setBackground(new Color(255,0,0));
		input2.setForeground(Color.BLACK);
		input2.setCaretColor(Color.RED);
		input2.setOpaque(true);
		input2.setFont(new Font("Courier New", Font.BOLD, 12));
		//input.getText();
		input2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{	String binary2 = input2.getText();
				 try {
					doCommand(binary2);
					
				 int i = Integer.parseInt(binary2);               //hex to decimal
				    String binary3 = Integer.toHexString(i);       //decimal to binary
				    /**
				    System.out.println("This is Binary: " + binary3);
				    */
				    try {input2.setText("");}
				    catch (Exception ex) {}
				    data.setText("");
				    data.setText(binary3);
				    input2.selectAll();	
				    input.setText("");
				 }
				 catch(Exception ex) {
					 JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage() + " Please put digits as numbers do not work", "Alert", JOptionPane.ERROR_MESSAGE);
				 }}});
		

		JLabel bin = new JLabel("Binary");
		bin.setBounds(78, 104, 70, 15);
		
		JLabel bin2 = new JLabel("Hex to Text");
		bin2.setBounds(300, 104, 80, 30);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(540, 250, 100, 50);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new mainPass();
				frame.dispose();
				}
			});
		
		frame.add(btnBack);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(540, 310, 100, 50);
		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			//	new mainPass();
				frame.dispose();
				}
			});
		
		frame.add(btnQuit);
		
		JButton btnGen = new JButton("Generate Binary");
		btnGen.setBounds(77, 168, 150, 25);
		btnGen.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				String binary1 = input.getText();
				try{
					doCommand(binary1);
				    int i = Integer.parseInt(binary1);               //hex to decimal
				    String binary = Integer.toBinaryString(i);       //decimal to binary
				    /**
				    System.out.println("This is Binary: " + binary);
				    */
				    try {input.setText("");}
				    catch (Exception ex) {}
				    data.setText("");
				    data.setText(binary);
				input.selectAll();
				input2.setText("");
				}
				
				catch(Exception ex) {
					 JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage() + "Please put digits as numbers do not work", "Alert", JOptionPane.ERROR_MESSAGE);
				 }
			}	
		});
		
	   frame.getContentPane().add(btnGen);
			
	   JButton btnGen2 = new JButton("Generate Hex");
		btnGen2.setBounds(300, 168, 150, 25);
		
		btnGen2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				String binary2 = input2.getText();
				 try {
					 doCommand(binary2);
				 int i = Integer.parseInt(binary2);               //hex to decimal
				    String binary3 = Integer.toHexString(i);       //decimal to binary
				    /**
				    System.out.println("This is Binary: " + binary3);
				    */
				    try {input2.setText("");}
				    catch (Exception ex) {}
				    data.setText("");
				    data.setText(binary3);
				    input2.selectAll();
				    input.setText("");
				 }
				 catch(Exception ex) {
					 JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage() + " Please put digits as numbers do not work", "Alert", JOptionPane.ERROR_MESSAGE);
				 }
				 input2.selectAll();	
			}
		});
		/**
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hi", "Yo"}));
		comboBox.setBounds(326, 75, 50, 24);
		//comboBox.set
		frame.getContentPane().add(comboBox);
		*/
		
	   frame.getContentPane().add(btnGen2);
			
		frame.add(input, BorderLayout.SOUTH);
		frame.add(input2, BorderLayout.SOUTH);
		frame.add(data, BorderLayout.SOUTH);
		frame.getContentPane().add(title);
		frame.getContentPane().add(bin);
		frame.getContentPane().add(bin2);
		//frame.getContentPane().setBackground(new Color(201,201,201));
		frame.setSize(660, 380);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public void doCommand(String binary1)
	{
		final String[] commands = binary1.split(" ");
		 try
			{
				if (commands[0].equalsIgnoreCase("close"))
				{
					data.setText("Hacker");
					JOptionPane.showMessageDialog(null, "Accses Granted", "Alert", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, "Nope", "Alert", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, "Its just a binary converter - geez - Stop being a big baby", "Alert", JOptionPane.INFORMATION_MESSAGE);
					//JOptionPane.showMessageDialog(null, "Installing Virus...101010101", "Alert", JOptionPane.INFORMATION_MESSAGE);
					
					frame.dispose();
					JOptionPane.showMessageDialog(null, "Program Chrased :-( (Change to linux so that its dosn't crash)", "Alert", JOptionPane.ERROR_MESSAGE);
					JOptionPane.showMessageDialog(null, "Thanks To all the people who dodn't help me make this, because you made me want to do it", "Thanks", JOptionPane.INFORMATION_MESSAGE);
				}
					//JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);	
			}
		 
			catch (Exception ex)
			{
				
			}
		 }}