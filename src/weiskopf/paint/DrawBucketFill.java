package weiskopf.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import weiskopf.paint.message.BucketFillMessage;

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

		canvas.getModule().sendMessage(new BucketFillMessage(canvas, x, y, canvas.getColor().getRGB()));

	}

}
