package weiskopf.paint.message;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

import weiskopf.paint.Canvas;

public class BucketFillMessage implements PaintMessage {

	private Canvas canvas;

	private int x;
	private int y;
	private int color;

	public BucketFillMessage(Canvas canvas, int x, int y, int color) {
		this.canvas = canvas;
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String toString() {
		String message;
		message = "BUCKET_FILL " + x + " " + y + " " + color + "\n";
		return message;
	}

	@Override
	public void apply(Graphics2D g) {

		BufferedImage image = canvas.getImage();

		// get the color of the pixel you clicked
		int clickedColor = 0;
		if ((x < canvas.getImage().getWidth() && y < canvas.getImage().getHeight())) {
			clickedColor = image.getRGB(x, y);
		}

		Queue<Point> points = new LinkedList<Point>();
		points.add(new Point(x, y));

		while (!points.isEmpty()) {
			Point p = points.remove();
			int x = (int) p.getX();
			int y = (int) p.getY();

			// checking that point is on canvas
			// checking that color of point matches color of point clicked
			// and that it's also not the same color as the color to be painted
			if (x >= 0 && x < canvas.getImage().getWidth() && y >= 0 && y < canvas.getImage().getHeight()
					&& image.getRGB(x, y) == clickedColor && image.getRGB(x, y) != color) {

				image.setRGB(x, y, color);
				points.add(new Point(x + 1, y));
				points.add(new Point(x - 1, y));
				points.add(new Point(x, y + 1));
				points.add(new Point(x, y - 1));

			}

		}

	}

}
