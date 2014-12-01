package weiskopf.paint;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class DrawRectangle implements DrawListener{
	
	private  Canvas canvas;
	private Rectangle rect;
	
	//private boolean drawn;
	
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	
	private int previousEndX;
	private int previousEndY;
	
	public DrawRectangle(Canvas canvas){
		this.canvas = canvas;
		//drawn = false;
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
		startX = e.getX();
		startY = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		endX = e.getX();
		endY = e.getY();
		draw();
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//endX = e.getX();
		//endY = e.getY();
		//draw();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawPreview() {
		
		Graphics g = canvas.getImage().getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		
		int stroke = canvas.getStroke();
		if (stroke < 0) {
			stroke = 0;
		}
		BasicStroke s = new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g2.setStroke(s);
		g2.setColor(canvas.getColor());
		
		if(canvas.getCounter() != 0){
		if(rect == null){
		rect = new Rectangle(startX, startY, endX, endY);
		g2.draw(rect);
		previousEndX = endX;
		previousEndY = endY;

		}else{
			g2.setBackground(canvas.getBackground());
			g2.clearRect(startX, startY, previousEndX, previousEndY);
			g2.drawRect(startX,  startY, endX, endY);
			previousEndX = endX;
			previousEndY = endY;
		}
		}
		canvas.incrementCounter();
		canvas.repaint();
		
	}
	
	public void draw(){
		Graphics2D g2 = canvas.getAndSetGraphics();
		g2.drawRect(startX, startY, endX - startX, endY - startY);

		canvas.incrementCounter();
		canvas.repaint();
	}

}
