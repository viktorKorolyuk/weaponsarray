package vafspy.weparr.customCode;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

/**
 * An addition to the Java Swing JFrame object which allows dragging.
 * Recommended when frame decoration is false.
 * 
 * @author Viktor Korolyuk
 */

public class Draggable {

	boolean mouseDown = false;
	double xDif;
	double yDif;
	JFrame frame;

	/**
	 * Allows the JFrame (Java Swing) to be dragged.
	 * 
	 * @param jFrame
	 *            Current frame instance
	 */
	public Draggable(JFrame jFrame) {
		frame = jFrame;

		frame.addMouseListener(new MouseListener() {

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

		frame.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				// move();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// Set frame position when
				move();
			}
		});
	}

	/**
	 * Calculates delta between mouse position and frame position.
	 */
	void startMoving() {
		xDif = MouseInfo.getPointerInfo().getLocation().x - frame.getX();
		yDif = MouseInfo.getPointerInfo().getLocation().y - frame.getY();
		mouseDown = true;
	}

	/**
	 * Stops frame from moving after mouse is released.
	 */
	void stopMoving() {
		mouseDown = false;
	}

	/**
	 * Calculates frame position based on pre-calculated deltas and current mouse
	 * position.
	 */
	void move() {
		if (!mouseDown)
			return;
		frame.setLocation((int) (MouseInfo.getPointerInfo().getLocation().x - xDif),
				(int) (MouseInfo.getPointerInfo().getLocation().y - yDif));

	}

}
