package vafspy.weparr.customCode;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Draggable extends JFrame{

	/**
	 * stop complaining
	 */
	private static final long serialVersionUID = 1L;
	boolean mouseDown = false;
	double xDif;
	double yDif;
	JFrame frame;
	
	public Draggable(JFrame s){
		frame = s;
		s.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				stopMoving();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				startMoving();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		s.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				//move();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				move();
			}
		});
	}
	public void startMoving(){
		xDif = MouseInfo.getPointerInfo().getLocation().x - frame.getX();
		yDif = MouseInfo.getPointerInfo().getLocation().y - frame.getY();
		mouseDown = true;
	}
	public void stopMoving(){
		mouseDown = false;
	}
	public void move(){
		if(!mouseDown) return;
		frame.setLocation((int)(MouseInfo.getPointerInfo().getLocation().x - xDif), (int)(MouseInfo.getPointerInfo().getLocation().y -yDif));
	}
	

}
