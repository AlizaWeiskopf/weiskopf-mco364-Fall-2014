package weiskopf.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	private int x;
	private int y;
	private int previousX;
	private int previousY;
	private BufferedImage image;
	private int counter;

	public Canvas() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);// A =
																			// alpha
																			// =
																			// transparent
																			// pixels
		counter = 0;
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
		g.setColor(Color.GREEN);
		if (counter != 0) {
			if (x == previousX + 1 && y == previousY + 1) {
				g.fillOval(x, y, 10, 10);
			} else {
				g.drawLine(previousX + 1, previousY + 1, x, y);
			}
		} else {
			g.fillOval(x, y, 10, 10);
		}

		counter++;
		repaint();
	}

}
