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

public class Canvas extends JComponent implements MouseWheelListener{
	
	private BufferedImage image;
	private DetailsPanel panel;
	private OptionsPanel drawPanel;
	private Color color;
	private int stroke;

	/*private int x;
	private int y;
	private int previousX;
	private int previousY;*/
	private DrawListener listener;
	private int counter;
	

	public Canvas(Paint paint) {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);// A =
																			// alpha
																			// =
																			// transparent
																			// pixels
		counter = 0;
		setColor(Color.GREEN);
		stroke = 5;
		
		panel = new DetailsPanel(this);
		paint.add(panel, BorderLayout.SOUTH);
		
		drawPanel = new OptionsPanel(this);
		paint.add(drawPanel, BorderLayout.NORTH);
		
		addMouseWheelListener(this);


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

	public int getStroke() {
		return stroke;
	}
	
	public BufferedImage getImage(){
		return image;
	}
	
	public int getCounter(){
		return counter;
	}
	
	public void incrementCounter(){
		counter++;
	}
	
	public void clear(){
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (counter != 0) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, null);
			//listener.drawPreview((Graphics2D) g);

		}

	}

	public void reset() {
		counter = 0;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		incrementStroke(e.getPreciseWheelRotation());
		int size = getStroke();
		if(size < 0){
			size = 0;
		}
		panel.getStrokeSize().setText("Stroke size: " + size);
		
	}

	public void addDrawListener(DrawListener listener) {
		this.removeMouseListener(this.listener);
		this.removeMouseMotionListener(this.listener);
		
		this.listener =  listener;
		addMouseListener(listener);
		addMouseMotionListener(listener);
		
	}
	
	public Graphics2D getAndSetGraphics(){
		Graphics g = image.getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		int stroke = getStroke();
		if (stroke < 0) {
			stroke = 0;
		}
		BasicStroke s = new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g2.setStroke(s);
		g2.setColor(getColor());
		return g2;
	}

}
