package vafspy.weparr.components;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Maker {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("/tmp/noise.wai");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream dos = new DataOutputStream(bos);
			int height1 = 175;
			int height2 = 2;
			int height3 = 2;
			int height4 = 0;
			int height = height1 * height2 * height3 + height4;
			int width1 = 175;
			int width2 = 2;
			int width3 = 2;
			int width4 = 0;
			int width = width1 * width2 * width3 + width4;
			dos.writeByte(width1);
			dos.writeByte(width2);
			dos.writeByte(width3);
			dos.writeByte(width4);
			dos.writeByte(height1);
			dos.writeByte(height2);
			dos.writeByte(height3);
			dos.writeByte(height4);
			int i = 0;
			while(i < width) {
				int j = 0;
				while(j < height) {
					dos.writeByte((int)(Math.random()*255));
					j++;
				}
				i++;
			}
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
