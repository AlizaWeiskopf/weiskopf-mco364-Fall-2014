package weiskopf.paint;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Queue;

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

		// get the color of the pixel you clicked
		int clickedColor = canvas.getImage().getRGB(x, y);

		Queue<Point> points = new LinkedList<Point>();
		points.add(new Point(x, y));

		while (!points.isEmpty()) {
			Point p = points.remove();
			int x = (int) p.getX();
			int y = (int) p.getY();
			if (canvas.contains(p)) {// point is on the screen
				if (canvas.getImage().getRGB(x, y) == clickedColor) {// color
																		// matches
					canvas.getImage().setRGB(x, y, canvas.getColor().getRGB());
					points.add(new Point(x + 1, y));
					points.add(new Point(x - 1, y));
					points.add(new Point(x, y + 1));
					points.add(new Point(x, y - 1));
				}
			}
		}

		canvas.incrementCounter();
		canvas.repaint();

	}

}
