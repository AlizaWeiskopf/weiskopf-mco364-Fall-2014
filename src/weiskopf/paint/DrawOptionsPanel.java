package weiskopf.paint;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawOptionsPanel extends JPanel{
	
	private Canvas canvas;
	
	private JButton brush;
	private JButton drawRect;
	private JButton fillRect;
	private JButton drawOval;
	private JButton fillOval;
	private JButton drawLine;
	
	public DrawOptionsPanel(Canvas canvas){
		this.canvas = canvas;
		
		brush = new JButton("Brush");
		drawRect = new JButton("Draw Rectangle");
		fillRect = new JButton("Fill Rectangle");
		drawOval = new JButton("Draw Oval");
		fillOval = new JButton("Fill Oval");
		drawLine = new JButton("Draw Line");
		
		SelectDrawListener drawType = new SelectDrawListener();
		brush.addActionListener(drawType);
		drawRect.addActionListener(drawType);
		fillRect.addActionListener(drawType);
		drawOval.addActionListener(drawType);
		fillOval.addActionListener(drawType);
		drawLine.addActionListener(drawType);
		
		//this.setLayout(new GridLayout(10,-5));
		add(brush);
		add(drawRect);
		add(fillRect);
		add(drawOval);
		add(fillOval);
		add(drawLine);
	}
	
	private class SelectDrawListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(((JButton)e.getSource()).getText()){
			
			case "Brush":
				DrawBrush brush = new DrawBrush(canvas);
				canvas.addDrawListener(brush);
				break;
				
			case "Draw Rectangle":
				DrawRectangle drawRect = new DrawRectangle(canvas);
				canvas.addDrawListener(drawRect);
				break;
				
			case "Fill Rectangle":
				FillRectangle fillRect = new FillRectangle(canvas);
				canvas.addDrawListener(fillRect);
				break;
				
			case "Draw Oval":
				DrawOval drawOval = new DrawOval(canvas);
				canvas.addDrawListener(drawOval);
				break;
				
			case "Fill Oval":
				FillOval fillOval = new FillOval(canvas);
				canvas.addDrawListener(fillOval);
				break;
				
			case "Draw Line":
				DrawLine drawLine = new DrawLine(canvas);
				canvas.addDrawListener(drawLine);
				break;
			}
			
		}
		
	}

}
