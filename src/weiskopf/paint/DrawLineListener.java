package weiskopf.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawLineListener implements MouseMotionListener {

	private Canvas canvas;
	private DetailsPanel panel;

	public DrawLineListener(Canvas canvas, DetailsPanel panel) {
		this.canvas = canvas;
		this.panel = panel;
	}

	@Override
	public void mouseDragged(MouseEvent e) {// hold down the button
		canvas.setPoint(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {// no clicking, mouse just moves
		canvas.reset();
	}

}
