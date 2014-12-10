package weiskopf.paint.message;

import java.awt.Graphics2D;

public class ShapeMessage implements PaintMessage {

	private Type type;
	private int x;
	private int y;
	private int width;
	private int height;
	private int color;
	private int strokeSize;
	private boolean fill;

	public ShapeMessage(Type type, int x, int y, int width, int height, int color, int strokeSize, boolean fill) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.strokeSize = strokeSize;
		this.fill = fill;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getStrokeSize() {
		return strokeSize;
	}

	public void setStrokeSize(int strokeSize) {
		this.strokeSize = strokeSize;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public String toString() {
		String message = "SHAPE " + type + " " + x + " " + y + " " + width + " " + height + " " + color + " "
				+ strokeSize + " " + fill + "\n";
		return message;
	}

	@Override
	public void apply(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
