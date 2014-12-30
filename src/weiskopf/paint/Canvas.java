package weiskopf.paint;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.net.ConnectException;

import javax.swing.JComponent;

import weiskopf.paint.message.LoopbackNetworkModule;
import weiskopf.paint.message.NetworkModule;
import weiskopf.paint.message.OnlineNetworkModule;

public class Canvas extends JComponent implements MouseWheelListener {

	private Client client;
	private NetworkModule module;

	private BufferedImage image;
	private DrawListener listener;
	private DetailsPanel detailsPanel;
	private OptionsPanel optionsPanel;

	private Color color;
	private int stroke;
	private int counter;
	private boolean clear;

	public Canvas(Paint paint) {

		try {
			client = new Client(this);
			module = new OnlineNetworkModule(client);
		} catch (Exception ex) {
			if (ex instanceof ConnectException) {
				module = new LoopbackNetworkModule(this);
			}
		}

		// use buffered image b/c when you call repaint the canvas will clear -
		// so need to draw to image and then draw that to canvas
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);// A =
																			// alpha
																			// =
																			// transparent
																			// pixels

		setColor(Color.GREEN);
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
			g.drawImage(image, 0, 0, null);
			listener.drawPreview((Graphics2D) g);

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

	public BufferedImage getImage() {
		return image;
	}

	public int getCounter() {
		return counter;
	}

	public void incrementCounter() {
		counter++;
	}

	public boolean getClear() {
		return clear;
	}

	public void setClear(boolean wasClicked) {
		clear = wasClicked;
	}

	public Client getClient() {
		return client;
	}

	public NetworkModule getModule() {
		return module;
	}

	/*
	 * public void clear() { clear = true; image = new BufferedImage(800, 600,
	 * BufferedImage.TYPE_INT_ARGB); repaint();
	 * 
	 * }
	 */

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
