package vafspy.weparr.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class NoisePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	@Override
	public void paintComponent(Graphics gn) {
		Graphics2D g = (Graphics2D)gn;
		int width = getWidth() - 1;
		int height = getHeight() - 1;
		int i = 0;
		while(i < width) {
			int j = 0;
			while(j < height) {
				int cv = (int) (Math.random() * 255);
				g.setColor(new Color(cv,cv,cv));
				g.drawRect(i, j, 1, 1);
				j++;
			}
			i++;
		}
	}
}
