package weiskopf.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class DrawShape implements DrawListener {

	private Canvas canvas;
	private String shape;

	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public DrawShape(Canvas canvas, String shape) {
		this.canvas = canvas;
		this.shape = shape;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
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
	public void mouseReleased(MouseEvent e) {// only once released actually draw
												// to image
		endX = e.getX();
		endY = e.getY();
		draw();

	}

	@Override
	public void mouseDragged(MouseEvent e) {// as you drag,draw a preview
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
	public void drawPreview(Graphics2D g) {// draws preview to canvas

		int minX = Math.min(startX, endX);
		int minY = Math.min(startY, endY);
		int maxX = Math.max(startX, endX);
		int maxY = Math.max(startY, endY);

		int width = maxX - minX;
		int height = maxY - minY;

		if (!canvas.getClear()) {

			canvas.setGraphicsDetails(g);

			switch (shape) {
			case "Draw Rectangle":
				g.drawRect(minX, minY, width, height);
				break;

			case "Fill Rectangle":
				g.fillRect(minX, minY, width, height);
				break;

			case "Draw Oval":
				g.drawOval(minX, minY, width, height);
				break;

			case "Fill Oval":
				g.fillOval(minX, minY, width, height);
				break;
			}
		} else {

			canvas.resetClear();

		}

	}

	@Override
	public void draw() {// draws to image

		int minX = Math.min(startX, endX);
		int minY = Math.min(startY, endY);
		int maxX = Math.max(startX, endX);
		int maxY = Math.max(startY, endY);

		int width = maxX - minX;
		int height = maxY - minY;

		Graphics2D g = (Graphics2D) canvas.getLayers()[canvas.getLayerSelected()].getGraphics();
		canvas.setGraphicsDetails(g);

		switch (shape) {

		case "Draw Rectangle":
			g.drawRect(minX, minY, width, height);
			break;

		case "Fill Rectangle":
			g.fillRect(minX, minY, width, height);
			break;

		case "Draw Oval":
			g.drawOval(minX, minY, width, height);
			break;

		case "Fill Oval":
			g.fillOval(minX, minY, width, height);
			break;
		}

		canvas.repaint();

	}

}
