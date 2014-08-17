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
	public int b = 1;
	public boolean go;
	public String username = System.getProperty("user.name");
	Thread run;
	public String one;
	
	JButton start = new JButton();
	JButton stop = new JButton();
	
public static void main(String[] args){
		new ScreenRecorder();
	}
	public ScreenRecorder(){
		
		super("Hi");
		setSize(400,400);
		setVisible(true);
		getContentPane().setLayout(null);
		add(start);
		start.setBounds(6, 7, 50, 100);
		start.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				captureScreen(one);
			}
		});
		add(stop);
		stop.setBounds(50, 50, 50, 100);
		stop.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
					run.stop();	
					deleteDirectory(new File("/tmp/recordings/" + username));
			}
		});
		
	}
	
	public void captureScreen(String one) {
		run = new Thread(new ScreenCapturing());
		run.start();
	}
	
	// REFERENCE: http://stackoverflow.com/questions/3775694/deleting-folder-from-java
	public static boolean deleteDirectory(File dir) {
	    if(! dir.exists() || !dir.isDirectory())    {
	        return false;
	    }

	    String[] files = dir.list();
	    for(int i = 0, len = files.length; i < len; i++)    {
	        File f = new File(dir, files[i]);
	        if(f.isDirectory()) {
	            deleteDirectory(f);
	        }else   {
	            f.delete();
	        }
	    }
	    return dir.delete();
	}
}
class ScreenCapturing implements Runnable {
	
	public String username = System.getProperty("user.name");
	
	@Override
	public void run() {
		
	int count = 1;
	new File("/tmp/recordings/" + username).mkdirs();
		while (true){
		       try{
		    	  // TimeUnit.NANOSECONDS.sleep(1);
		       BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		       new File("/tmp/recordings/" + username).mkdirs();
		       ImageIO.write(image, "png", new File("/tmp/recordings/"+ username + "/" + count +".png"));
		       }
		       catch (IOException ex){}
		       catch (AWTException ex){} catch (Exception ex) {
			
				ex.printStackTrace();
			}
		       count++;
		   }
	}
}
