package weiskopf.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import weiskopf.paint.message.LineMessage;

public class DrawBrush implements DrawListener {

	private Canvas canvas;

	private int previousX;
	private int previousY;
	private int x;
	private int y;

	public DrawBrush(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) { // hold down button
		// save previous point
		previousX = x;
		previousY = y;

		x = e.getX();
		y = e.getY();

		draw();

	}

	@Override
	public void mouseMoved(MouseEvent e) { // no clicking, mouse just moves
		canvas.reset();

	}

	@Override
	public void drawPreview(Graphics2D g) {
		// no previews in networking (or for brush)

	}

	@Override
	public void draw() {

		if (canvas.getCounter() != 0) {

			LineMessage m = new LineMessage(previousX, previousY, x, y, canvas.getColor().getRGB(),
					canvas.getStrokeSize());
			canvas.getModule().sendMessage(m);

		}

		canvas.incrementCounter();
		canvas.repaint();

	}

}
