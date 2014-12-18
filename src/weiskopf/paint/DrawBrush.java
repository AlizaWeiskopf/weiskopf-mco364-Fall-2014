package weiskopf.paint;

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
		// no preview for brush

	}

	@Override
	public void draw() {

		// draw to the image and then when call repaint redraws image on the
		// JComponent

		if (canvas.getCounter() != 0) {
			Graphics2D g = (Graphics2D) canvas.getLayers()[canvas.getLayerSelected()].getGraphics();
			canvas.setGraphicsDetails(g);
			g.drawLine(previousX + 1, previousY + 1, x, y);
		}

		canvas.incrementCounter();
		canvas.repaint();

	}

}
