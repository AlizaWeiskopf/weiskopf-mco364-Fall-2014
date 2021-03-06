package weiskopf.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class DrawLine implements DrawListener {

	private Canvas canvas;

	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public DrawLine(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
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
		endX = e.getX();
		endY = e.getY();
		canvas.incrementCounter();
		canvas.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics2D g) {
		if (!canvas.getClear()) {

			canvas.setGraphicsDetails(g);
			g.drawLine(startX, startY, endX, endY);

		} else {

			canvas.resetClear();

		}

	}

	public void draw() {
		Graphics2D g = (Graphics2D) canvas.getLayers()[canvas.getLayerSelected()].getGraphics();
		canvas.setGraphicsDetails(g);
		g.drawLine(startX, startY, endX, endY);
		canvas.repaint();
	}

}
