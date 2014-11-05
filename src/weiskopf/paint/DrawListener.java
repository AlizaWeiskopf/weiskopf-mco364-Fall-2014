package weiskopf.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawListener implements MouseMotionListener {

	private Canvas canvas;

	public DrawListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent e) {// hold down the button
		canvas.setPoint(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {// no clicking
		// TODO Auto-generated method stub

	}

}
