import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GOL implements MouseListener, ActionListener{

	protected static final int WIDTH = 50;
	protected static final int HEIGHT = 50;
	protected JFrame frame = new JFrame("Conway's game of life");
	protected boolean[][] grid = new boolean[WIDTH][HEIGHT]; //PASS IT IN TO PANEL
	protected myPanel panel = new myPanel(grid);
	protected boolean running = false;
	protected JButton next = new JButton("Next");
	//protected JButton start = new JButton("Start");
	//protected JButton stop = new JButton("Stop");
	protected Container container = new Container(); // used to contain buttons;
	protected Coordinate liveCell;

	
	public GOL(){
		frame.setSize(500,500);
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);

		//create the south container to add things to it
		container.setLayout(new GridLayout(1,3));
		container.add(next);
		next.addActionListener(this);
		/*container.add(start);
		start.addActionListener(this);
		container.add(stop);
		stop.addActionListener(this);*/
		frame.add(container, BorderLayout.SOUTH);

		panel.addMouseListener(this);//add mouse listener for the panel
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args){
		new GOL();
	}

	public void mouseClicked(MouseEvent ev){
		//System.out.println(ev.getX() + "," + ev.getY());
		int col = ev.getY() / (panel.getHeight()/HEIGHT);
		int row = ev.getX() / (panel.getWidth()/WIDTH);
		liveCell = new Coordinate(row, col);
		frame.repaint();
	}

	public void mousePressed(MouseEvent ev){
		
	}

	public void mouseEntered(MouseEvent ev){

	}

	public void mouseExited(MouseEvent ev){
		
	}

	public void mouseReleased(MouseEvent ev){
	
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(next)){
			next();
			frame.repaint();
		}
	}

	public void next(){
		boolean[][] newGrid = new boolean[grid.length][grid.length];
		for(int x=0; x<grid.length; x++){
			for(int y=0; y<grid.length; y++){
				int neighborCount = 0; 
				if(y > 0 && grid[x][y-1]==true){
					neighborCount++;
				}
				if(y > 0 && x < grid.length-1 && grid[x+1][y-1]==true){
					neighborCount++;
				}
				if(x < grid.length-1 && grid[x+1][y]==true){
					neighborCount++;
				}
				if(y < grid.length-1 && x < grid.length-1 && grid[x+1][y+1] == true){
					neighborCount++;
				}
				if(y < grid.length-1 && grid[x][y+1]==true){
					neighborCount++;
				}
				if(x > 0 && y < grid.length-1 && grid[x-1][y+1]==true){
					neighborCount++;
				}
				if(x > 0 && grid[x-1][y]==true){
					neighborCount++;
				}
				if(x > 0 && y > 0 && grid[x-1][y-1]==true){
					neighborCount++;
				}

				if(grid[x][y]==true){ //if it's alive
					if(neighborCount == 2 || neighborCount == 3){ //if it has two or three neighbors
						newGrid[x][y] = true;
					}
					else{
						newGrid[x][y] = false;
					}
				}
				else{
					if(neighborCount == 3){
						newGrid[x][y] = true;
					}
					else{
						newGrid[x][y] = false;
					}
				}
			}
		}
		grid = newGrid;
		panel.setGrid(newGrid);
	}
}