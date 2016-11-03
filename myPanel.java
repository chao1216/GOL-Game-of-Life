import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.JPanel;

public class myPanel extends JPanel{

	private boolean[][] grid;
	
	public myPanel(boolean[][] newGrid){
		grid = newGrid;
	}

	public void setGrid(boolean[][] newGrid){
		grid = newGrid;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		int boxWidth = this.getWidth()/grid.length;
		int boxHeight = this.getHeight()/grid.length;
		
		for(int i=0; i< grid.length; i++){	
			for(int j=0; j<grid.length; j++){
				if(grid[i][j]==false){
					g.setColor(Color.BLUE);
					g.fillRect(i*boxWidth, j*boxHeight, boxWidth, boxHeight);

				}
			}
		}

		for(int i=0; i<grid.length; i++){
			g.setColor(new Color(0,0,0));
			g.drawLine(i*boxWidth,0,i*boxWidth,this.getHeight());
			g.drawLine(0,i*boxHeight,this.getWidth(), i*boxHeight);
		}


	}

}