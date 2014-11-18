package weiskopf.paint;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	private int x;
	private int y;
	private int previousX;
	private int previousY;
	private BufferedImage image;
	private int counter;
	private Color color;
	private int stroke;

	public Canvas() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);// A =
																			// alpha
																			// =
																			// transparent
																			// pixels
		counter = 0;
		setColor(Color.GREEN);
		stroke = 5;
		
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void incrementStroke(double increment){
		stroke += increment;

	}
	
	public int getStroke(){
		return stroke;
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		if (counter != 0) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, null);

		}

	}

	public void setPoint(int endX, int endY) {
		// save previous point
		previousX = x;
		previousY = y;

		this.x = endX;
		this.y = endY;

		// draw to the image and then when call repaint redraws image on the
		// JComponent
		Graphics g = image.getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);

		if (counter != 0) {
			if (x == previousX + 1 && y == previousY + 1) {
				g2.fillOval(x, y, stroke, stroke);
			} else {
				if(stroke < 0){
					stroke = 0;
				}
				g2.setStroke(new BasicStroke(stroke));
				g2.drawLine(previousX + 1, previousY + 1, x, y);
			}
		} else {
			g2.fillOval(x, y, stroke, stroke);
		}

		counter++;
		repaint();
	}

	public void reset() {
		counter = 0;
	}

}
