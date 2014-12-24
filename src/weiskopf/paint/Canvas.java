package weiskopf.paint;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent implements MouseWheelListener {

	private BufferedImage[] layers;

	private int layerSelected;

	private DrawListener listener;
	private DetailsPanel detailsPanel;
	private OptionsPanel optionsPanel;

	private Color color;
	private int stroke;
	private int counter;
	private boolean clear;

	public Canvas(Paint paint) {

		// setBackground(new Color(Color.TRANSLUCENT));

		// use buffered image b/c when you call repaint the canvas will clear -
		// so need to draw to image and then draw that to canvas
		// A = alpha = transparent pixels
		layers = new BufferedImage[4];
		for (int i = 0; i < 4; i++) {
			layers[i] = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		}

		setColor(Color.GREEN);
		layerSelected = 0;
		stroke = 5;
		counter = 0;
		clear = false;

		addDrawListener(new DrawBrush(this));
		addMouseWheelListener(this);

		optionsPanel = new OptionsPanel(this);
		paint.add(optionsPanel, BorderLayout.NORTH);

		detailsPanel = new DetailsPanel(this);
		paint.add(detailsPanel, BorderLayout.SOUTH);

	}

	@Override
	protected void paintComponent(Graphics g) {

		if (counter != 0) {
			super.paintComponent(g);
			for (int i = 0; i < 4; i++) {
				g.drawImage(layers[i], 0, 0, null);
				if (i == layerSelected) {
					listener.drawPreview((Graphics2D) g);
				}
			}

		}

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void incrementStroke(double increment) {
		stroke += increment;

	}

	public int getStrokeSize() {
		return stroke;
	}

	public BufferedImage[] getLayers() {
		return layers;
	}

	public int getCounter() {
		return counter;
	}

	public void incrementCounter() {
		counter++;
	}

	public int getLayerSelected() {
		return layerSelected;
	}

	public void setLayerSelected(int layerSelected) {
		this.layerSelected = layerSelected;
	}

	public boolean getClear() {
		return clear;
	}

	public void resetClear() {
		clear = false;
	}

	public void clear() {
		clear = true;
		layers[layerSelected] = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		counter++;
		repaint();
	}

	public void reset() {
		counter = 0;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		incrementStroke(e.getPreciseWheelRotation());
		int size = getStrokeSize();
		if (size < 0) {
			size = 0;
		}
		detailsPanel.getStrokeSize().setText("Stroke size: " + size);

	}

	public void addDrawListener(DrawListener listener) {
		this.removeMouseListener(this.listener);
		this.removeMouseMotionListener(this.listener);

		this.listener = listener;
		addMouseListener(listener);
		addMouseMotionListener(listener);

	}

	public void setGraphicsDetails(Graphics2D g) {

		int stroke = getStrokeSize();
		if (stroke < 0) {
			stroke = 0;
		}
		BasicStroke s = new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g.setStroke(s);
		g.setColor(getColor());
	}

}
