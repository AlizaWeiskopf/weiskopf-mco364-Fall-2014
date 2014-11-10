package weiskopf.paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ColorPanel extends JPanel {

	private JButton red;
	private JButton blue;
	private JButton green;
	private Canvas canvas;

	public ColorPanel(Canvas canvas) {
		red = new JButton("RED");
		blue = new JButton("BLUE");
		green = new JButton("GREEN");
		this.canvas = canvas;
		
		ChooseColorListener color = new ChooseColorListener();
		red.addActionListener(color);
		blue.addActionListener(color);
		green.addActionListener(color);
		
		this.add(red);
		this.add(blue);
		this.add(green);
	}

	private class ChooseColorListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton colorChosen = (JButton)e.getSource();
			if(colorChosen == red){
				canvas.setColor(Color.RED);
			}else{
				if(colorChosen == blue){
					canvas.setColor(Color.BLUE);
				}else{
					if(colorChosen == green){
						canvas.setColor(Color.GREEN);
					}
				}
			}
			
		}

	 }

}
