package weiskopf.paint;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

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
		setPoint(e.getX(), e.getY());

	}

	@Override
	public void mouseMoved(MouseEvent e) { // no clicking, mouse just moves
		canvas.reset();

	}

	@Override
	public void drawPreview() {
		// TODO Auto-generated method stub

	}

	public void setPoint(int endX, int endY) {
		// save previous point
		previousX = x;
		previousY = y;

		this.x = endX;
		this.y = endY;

		// draw to the image and then when call repaint redraws image on the
		// JComponent

		if (canvas.getCounter() != 0) {
			Graphics2D g2 = canvas.getAndSetGraphics();
			g2.drawLine(previousX + 1, previousY + 1, x, y);
		}

		canvas.incrementCounter();
		canvas.repaint();
	}

}
