package weiskopf.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class DrawBucketFill implements DrawListener{
	
	private Canvas canvas;
	
	private int x;
	private int y;
	
	public DrawBucketFill(Canvas canvas){
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
		Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
		canvas.setGraphicsDetails(g);
		
		//get the color of the pixel you clicked
		int pixelClickedColor = canvas.getImage().getRGB(x, y);
	
		do{
			//paint that pixel plus all surrounding pixels that
			//are same color as where you clicked with color of pen
			//stop when you reach a pixel that is not same color
			g.drawLine(x,y,x,y);//draw the point
			
			//code to calculate surrounding points
			
			//check color of point = if color == pixelClickedColor
			//draw it also
			
		
		}while(canvas.getImage().getRGB(x, y) == pixelClickedColor);
		canvas.incrementCounter();
		canvas.repaint();
		
	}

}
