package vafspy.weparr;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenRecorder {
	public int b =1;
	
public static void main(String[] args){
	int a = 1;	
	while (a<2){
		new ScreenRecorder();
		a++;
		}
	}
	public ScreenRecorder(){
		
		
		String one = Integer.toString(b);
		
	captureScreen(one);
	}
	
	public void captureScreen(String one) {
		
		 while (b<5){
	       try{
	       BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	       ImageIO.write(image, "png", new File("/home/viktor/Documents"+ b +".png"));
	       }
	       catch (IOException ex){}
	       catch (AWTException ex){}
	 b++;
	   }
	}
	
}
