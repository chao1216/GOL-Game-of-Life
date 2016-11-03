import java.awt.*;
import objectdraw.*;
import javax.swing.*

public class Conway extends WindowController{
	protected FilledRect rect;
	protected FramedRect border;
	protected static final int ROW = 50;
	protected static final int COL = 50;
	protected static final int LEFT = 0;
	protected static final int TOP = 0;
	protected static final int SIZE = 20;
	protected boolean[][] world = new boolean[ROW][COL];
	//protected boolean[][] currentMove = new boolean[100][200];
	//protected boolean[][] nextMove = new boolean[100][200];


	public void begin(){
		for(int i=0; i<ROW; i++){
			for(int j=0; j<COL; j++){
				world[i][j] = false;
			}
		}

		for(int row=0; row<ROW; row++){
			for(int col=0; col<COL; col++){
				/*rect[row][col] = new FramedRect(LEFT+col*SIZE, TOP+row*SIZE, SIZE, SIZE, canvas);
				rect[row][col].setColor(Color.BLUE);*/
				rect = new FilledRect(LEFT+col*SIZE, TOP+row*SIZE, SIZE, SIZE, canvas);
				border = new FramedRect(LEFT+col*SIZE, TOP+row*SIZE, SIZE, SIZE, canvas);
				rect.setColor(Color.BLUE);
			}
		}
	}

	public void onMouseClick(Location point){
		if(rect.contains(point)){
			rect.setColor(Color.YELLOW);
		}
	}

	public static void main(String[] args){
		new Conway().startController(600,600);
	}
	
}