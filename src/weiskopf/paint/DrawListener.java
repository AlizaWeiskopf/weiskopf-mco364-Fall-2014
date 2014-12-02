package weiskopf.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface DrawListener extends MouseListener, MouseMotionListener {


	// any class that implements DrawListener has to include all methods from
	// MouseListener and MouseMotionListener
	
	
	public void drawPreview(Graphics2D g);
	/*
	 * draws preview, and then when release mouse actually gets drawn to
	 * buffered image in canvas for line - there is no preview for shape there
	 * is something
	 */
	
	public void draw();

}
