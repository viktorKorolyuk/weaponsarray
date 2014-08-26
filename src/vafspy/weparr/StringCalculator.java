package vafspy.weparr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import htmlguy.jlib.StringMath;

public class StringCalculator extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel pnl = new JPanel();
	JTextField equation = new JTextField("Enter Mathematical Expression Here!");
	JButton calc = new JButton("Calculate!");

	public StringCalculator() {
		super("Adv. Math Calculator");
		setSize(250,100);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new MainLoader();
			}
		});
		add(pnl);
		pnl.add(equation);
		calc.addActionListener(this);
		pnl.add(calc);
		setVisible(true);
	}

	public static void main(String[] args) {
		new StringCalculator();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			double g = new StringMath().parse(equation.getText());
			JOptionPane
			.showMessageDialog(
					null,
					"Equation Value: " + g,
					"Equation Results", JOptionPane.ERROR_MESSAGE);
		} catch (ScriptException e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Evaluation Error! Unable to evaluate equation!",
							"EVALUATION ERROR!", JOptionPane.ERROR_MESSAGE);
		}

	}
}
