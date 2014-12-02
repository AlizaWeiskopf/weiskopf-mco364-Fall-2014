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
		if (!canvas.getClear()) {

			canvas.setGraphicsDetails(g);

			switch (shape) {
			case "Draw Rectangle":
				g.drawRect(startX, startY, endX - startX, endY - startY);
				break;

			case "Fill Rectangle":
				g.fillRect(startX, startY, endX - startX, endY - startY);
				break;

			case "Draw Oval":
				g.drawOval(startX, startY, endX - startX, endY - startY);
				break;

			case "Fill Oval":
				g.fillOval(startX, startY, endX - startX, endY - startY);
				break;
			}
		} else {

			canvas.resetClear();

		}

	}

	@Override
	public void draw() {// draws to image
		Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
		canvas.setGraphicsDetails(g);

		switch (shape) {
		case "Draw Rectangle":
			g.drawRect(startX, startY, endX - startX, endY - startY);
			break;

		case "Fill Rectangle":
			g.fillRect(startX, startY, endX - startX, endY - startY);
			break;

		case "Draw Oval":
			g.drawOval(startX, startY, endX - startX, endY - startY);
			break;

		case "Fill Oval":
			g.fillOval(startX, startY, endX - startX, endY - startY);
			break;
		}

		canvas.repaint();

	}

}
