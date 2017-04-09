package vafspy.weparr.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	ArrayList<Integer> pixs = new ArrayList<Integer>();
	int width, height;

	public ImagePanel(FileInputStream image) {
		super();
		BufferedInputStream buf = new BufferedInputStream(image);
		DataInputStream dis = new DataInputStream(buf);
		try {
			int width1 = dis.readUnsignedByte();
			int width2 = dis.readUnsignedByte();
			int width3 = dis.readUnsignedByte();
			int width4 = dis.readUnsignedByte();
			int height1 = dis.readUnsignedByte();
			int height2 = dis.readUnsignedByte();
			int height3 = dis.readUnsignedByte();
			int height4 = dis.readUnsignedByte();
			width = width1 * width2 * width3 + width4;
			height = height1 * height2 * height3 + height4;
			setPreferredSize(new Dimension(width, height));
			System.out.println(width + "  " + height);
			System.out.println(dis.available());
			while (dis.available() > 0) {
				pixs.add(dis.readUnsignedByte());
			}
			System.out.println(pixs.size());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// public ImagePanel(InputStream input) {
	// TODO Auto-generated constructor stub
	// }
	@Override
	public void paintComponent(Graphics comp) {
		super.paintComponent(comp);
		Graphics2D g = (Graphics2D) comp;
		int i = 0;
		int l = 0;
		while (i < width) {
			int j = 0;
			while (j < height) {
				int cv = pixs.get(l);
				g.setColor(new Color(cv, cv, cv));
				g.drawRect(i, j, 1, 1);
				j++;
				l++;
			}
			i++;
		}
	}
}
