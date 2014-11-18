package weiskopf.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class DrawListener implements MouseMotionListener, MouseWheelListener {

	private Canvas canvas;
	private DetailsPanel panel;

	public DrawListener(Canvas canvas, DetailsPanel panel) {
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

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		canvas.incrementStroke(e.getPreciseWheelRotation());
		int size = canvas.getStroke();
		if(canvas.getStroke() < 0){
			size = 0;
		}
		panel.getStrokeSize().setText("Stroke size: " + size);
	}

}
