package weiskopf.paint;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class StrokeSizeListener implements MouseWheelListener {

	private Canvas canvas;
	private DetailsPanel panel;

	public StrokeSizeListener(Canvas canvas, DetailsPanel panel) {
		this.canvas = canvas;
		this.panel = panel;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		canvas.incrementStroke(e.getPreciseWheelRotation());
		int size = canvas.getStroke();
		if (canvas.getStroke() < 0) {
			size = 0;
		}
		panel.getStrokeSize().setText("Stroke size: " + size);
	}

}
