package weiskopf.paint;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Stack;

public class DrawBucketFill implements DrawListener {

	private Canvas canvas;
	private Stack<Point> pixelStack;

	private Graphics2D g;
	private int pixelClickedColor;

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
		g = (Graphics2D) canvas.getImage().getGraphics();
		canvas.setGraphicsDetails(g);

		// get the color of the pixel you clicked
		pixelClickedColor = canvas.getImage().getRGB(x, y);

		// paint all surrounding pixels that
		// are same color as where you clicked with color of pen
		// stop when you reach a pixel that is not same color

		pixelStack = new Stack();
		pixelStack.push(new Point(x, y));

		fill(x, y);// draw the point

		canvas.incrementCounter();
		canvas.repaint();

	}

	public void fill(int x, int y) {
		// check color of point = if color == pixelClickedColor
		// draw it also

		if (canvas.contains(new Point(x, y))) {
			int nextPixelColor = canvas.getImage().getRGB(x, y);

			if (nextPixelColor == pixelClickedColor) {
				g.drawLine(x, y, x, y);// draw the point
				fill(x, y + 1);
				fill(x, y - 1);
				fill(x + 1, y);
				fill(x - 1, y);
			}
			/*
			 * } catch (AWTException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */

		}
	}

}
