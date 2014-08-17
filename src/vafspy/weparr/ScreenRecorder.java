package vafspy.weparr;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ScreenRecorder extends JFrame{
	private static final long serialVersionUID = 1L;
	public int b =1;
	public String username = System.getProperty("user.name");
	public String one;
	public Thread mt = new Thread();
	
	JButton start = new JButton();
	
public static void main(String[] args){
		new ScreenRecorder();
	}
	public ScreenRecorder(){
		
		super("Hi");
		setSize(400,400);
		setVisible(true);
		getContentPane().setLayout(null);
		add(start);
		start.setBounds(6, 7, 6, 6);
		start.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				captureScreen(one);
			}
		});
		
		
		
		
		String one = Integer.toString(b);
	
	
	}
	
	public void captureScreen(String one) {
		mt.start();
		
		 for (int i = 0; i < 50; i++){
	       try{
	    	  // TimeUnit.NANOSECONDS.sleep(1);
	       BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	       ImageIO.write(image, "png", new File("/home/"+ username +"/Documents/"+ i +".png"));
	       }
	       catch (IOException ex){}
	       catch (AWTException ex){} catch (Exception ex) {
		
			ex.printStackTrace();
		}
	   }
	}
	
}
