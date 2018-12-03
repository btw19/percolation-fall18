import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast{

	public PercolationBFS(int n) {
		super(n);
	}
	
	@Override
	protected void dfs(int row, int col) {
		
		int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};
        
		// out of bounds?
		if (! inBounds(row,col)) return;
		
		// full or open, don't process
		if (isFull(row, col) || !isOpen(row, col))
			return;
		int size = myGrid.length;
		
		Queue<Integer> qi = new LinkedList<>();
		myGrid[row][col] = FULL;
		qi.add(row*size + col);
		while (qi.size() > 0) {
			int value = qi.remove();
			for (int k=0; k < rowDelta.length; k++) {
				row = value/size + rowDelta[k];
                col = value%size + colDelta[k];
                if (inBounds(row, col) && isOpen(row, col) && ! isFull(row, col)) {
                	qi.add(row*size + col);
                	myGrid[value/size][value%size] = FULL;
                }
			}
		}
	}

}
