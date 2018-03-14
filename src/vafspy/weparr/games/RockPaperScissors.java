package vafspy.weparr.games;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class RockPaperScissors extends JFrame {
	JPanel gameHolder;
	JTextArea gameArea;
	JScrollPane scrollPane;
	JButton rock, paper, scissors;
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new RockPaperScissors();
	}

	public RockPaperScissors() {
		super("title");
		setSize(1000, 500);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		gameHolder = new JPanel();
		gameHolder.setBackground(Color.decode("#111111"));
		
		gameArea = new JTextArea();
		gameArea.setLineWrap(true);
		gameArea.setColumns(getWidth()/gameArea.getFont().getSize());
		gameArea.setRows(getHeight()/gameArea.getFont().getSize()/2);
		
		scrollPane = new JScrollPane(gameArea);
		scrollPane.setBorder(new Border() {
			
			@Override
			public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isBorderOpaque() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Insets getBorderInsets(Component c) {
				// TODO Auto-generated method stub
				Insets inset = new Insets(1, 1, 1, 1);
				return inset;
			}
		});
		
		// Add the game to a panel for easier UI handling.
		gameHolder.add(scrollPane);
		
		// Appending items to window
		add(gameHolder);
		setVisible(true);
	}

}
