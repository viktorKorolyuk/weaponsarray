package vafspy.weparr;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class CalculatorPage extends JFrame {
	// Add a serialVersionUID: Takes care of those pesky warnings!
	private static final long serialVersionUID = 1L;
	public JFrame f;
	public JComboBox<String> op;
	public JTextField input1;
	public JTextField input2;
	public JTextPane answer;
	public JLabel answerlbl;

	public static void main(String[] args) {

		new CalculatorPage();
	}

	public CalculatorPage() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception ex) {
				}
		}
		f = new JFrame();
		f.setTitle("CalcUlatorz");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new mainPass();
			}
		});
		f.getContentPane().setLayout(null);

		JButton equals = new JButton("Equals");
		equals.setBounds(3, 150, 100, 30); // x y(down) length height
		equals.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((String) op.getSelectedItem()).equals("Add: +")) {
					add();
				}
				if (((String) op.getSelectedItem()).equals("Subtract: -")) {
					sub();
				}
				if (((String) op.getSelectedItem()).equals("Divide: %")) {
					div();
				}
				if (((String) op.getSelectedItem()).equals("Multyply: x")) {
					mul();
				}
			}
		});

		op = new JComboBox<>();
		op.setModel(new DefaultComboBoxModel<String>(new String[] { "Choose:",
				"Add: +", "Subtract: -", "Divide: %", "Multyply: x" }));
		op.setBounds(120, 30, 130, 50);

		op.setOpaque(true);

		input1 = new JTextField();
		input1.setBounds(10, 30, 100, 20);
		input1.setForeground(Color.BLACK);
		input1.setCaretColor(Color.GREEN);
		input1.setOpaque(true);
		input1.setFont(new Font("Courier New", Font.BOLD, 12));

		input2 = new JTextField();
		input2.setBounds(260, 30, 100, 20);
		input2.setForeground(Color.BLACK);
		input2.setCaretColor(Color.GREEN);
		input2.setOpaque(true);
		input2.setFont(new Font("Courier New", Font.BOLD, 12));

		answerlbl = new JLabel();
		answerlbl.setText("Answer");
		answerlbl.setBounds(40, 260, 100, 30);
		answerlbl.setFont(new Font("Courier New", Font.BOLD, 12));

		answer = new JTextPane();
		answer.setEditable(false);
		answer.setBounds(40, 300, 300, 100);
		answer.setOpaque(true);

		f.add(op);
		f.add(answerlbl);
		f.add(answer);
		f.add(input1);
		f.add(input2);
		f.add(equals);
		f.setSize(400, 500);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public void add() {
		try {
			String inputs1 = input1.getText();
			String inputs2 = input2.getText();

			int one = Integer.parseInt(inputs1);
			int two = Integer.parseInt(inputs2);
			int finalnum = (one += two);

			System.out.println(finalnum);
			String finalnumb = Integer.toString(finalnum);
			answer.setText(finalnumb);
		} catch (Exception ex) {
			JOptionPane
					.showMessageDialog(
							null,
							"Error --> "
									+ ex
									+ " In short Form the digit was too big and/or you used a letter or any other key that isnt a number",
							"Alert :(", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void sub() {
		try {
			String inputs1 = input1.getText();
			String inputs2 = input2.getText();

			int one = Integer.parseInt(inputs1);
			int two = Integer.parseInt(inputs2);
			int finalnum = (one -= two);

			System.out.println(finalnum);
			String finalnumb = Integer.toString(finalnum);
			answer.setText(finalnumb);
		} catch (Exception ex) {
			JOptionPane
					.showMessageDialog(
							null,
							"Error --> "
									+ ex
									+ " In short Form the digit was too big and/or you used a letter or any other key that isnt a number",
							"Alert :(", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void div() {
		try {
			String inputs1 = input1.getText();
			String inputs2 = input2.getText();

			int one = Integer.parseInt(inputs1);
			int two = Integer.parseInt(inputs2);
			int finalnum = (one /= two);

			System.out.println(finalnum);
			String finalnumb = Integer.toString(finalnum);
			answer.setText(finalnumb);
		} catch (Exception ex) {
			JOptionPane
					.showMessageDialog(
							null,
							"Error --> "
									+ ex
									+ " In short Form the digit was too big and/or you used a letter or any other key that isnt a number",
							"Alert :(", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void mul() {
		try {
			String inputs1 = input1.getText();
			String inputs2 = input2.getText();

			int one = Integer.parseInt(inputs1);
			int two = Integer.parseInt(inputs2);
			int finalnum = (one *= two);

			System.out.println(finalnum);
			String finalnumb = Integer.toString(finalnum);
			answer.setText(finalnumb);
		} catch (Exception ex) {
			JOptionPane
					.showMessageDialog(
							null,
							"Error --> "
									+ ex
									+ " In short Form the digit was too big and/or you used a letter or any other key that isnt a number",
							"Alert :(", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
