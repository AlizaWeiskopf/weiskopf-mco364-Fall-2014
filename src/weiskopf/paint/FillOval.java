package weiskopf.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class FillOval implements DrawListener {

	private Canvas canvas;

	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public FillOval(Canvas canvas) {
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
	public void mousePressed(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		endX = e.getX();
		endY = e.getY();
		draw();

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
	public void drawPreview() {
		// TODO Auto-generated method stub

	}

	public void draw() {
		Graphics2D g2 = canvas.getAndSetGraphics();
		g2.fillOval(startX, startY, endX - startX, endY - startY);

		canvas.incrementCounter();
		canvas.repaint();
	}

}
