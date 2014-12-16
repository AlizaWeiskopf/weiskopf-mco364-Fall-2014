package weiskopf.paint;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;

public class DrawBucketFill implements DrawListener {

	private Canvas canvas;

	private int x;
	private int y;

	public DrawBucketFill(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();
		draw();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
		canvas.setGraphicsDetails(g);

		Robot r;
		Color firstClickColor;
		try {
			r = new Robot();
			firstClickColor = r.getPixelColor(x, y);
			fill(x, y, g, firstClickColor);// draw the point
			canvas.incrementCounter();
			canvas.repaint();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// get the color of the pixel you clicked
		// int pixelClickedColor = canvas.getImage().getRGB(x, y);

		// fill(x, y, g, pixelClickedColor);// draw the point

		// paint all surrounding pixels that
		// are same color as where you clicked with color of pen
		// stop when you reach a pixel that is not same color

		// code to calculate surrounding points
		/*
		 * x++; y++;
		 * 
		 * int nextPixelColor = canvas.getImage().getRGB(x, y); while
		 * (nextPixelColor == pixelClickedColor) { g.drawLine(x, y, x, y); x++;
		 * y++; nextPixelColor = canvas.getImage().getRGB(x, y); }
		 */

		// check color of point = if color == pixelClickedColor
		// draw it also

	}

	public void fill(int x, int y, Graphics g, Color firstClickColor) {
		if (canvas.contains(new Point(x, y))) {

			Robot r;
			try {
				r = new Robot();
				Color pixelColor = r.getPixelColor(x, y);
				// int pixelColor = canvas.getImage().getRGB(x,y);

				if (pixelColor.equals(firstClickColor)) {
					g.drawLine(x, y, x, y);// draw the point
					fill(x, y + 1, g, firstClickColor);
					fill(x, y - 1, g, firstClickColor);
					fill(x + 1, y, g, firstClickColor);
					fill(x - 1, y, g, firstClickColor);
				}
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
