import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast{

	public PercolationBFS(int n) {
		super(n);
	}
	
	@Override
	protected void dfs(int row, int col) {
		
		int size = myGrid.length;
		
		Queue<Integer> qi = new LinkedList<>();
		myGrid[row][col] = FULL;
		qi.add(row*size + col);
		while (qi.size() > 0) {
			int value = qi.remove();
            if (inBounds(value/size-1, value%size) && isOpen(value/size-1, value%size) && ! isFull(value/size-1, value%size)) {
                	qi.add((value/size-1)*size + value%size);
                	myGrid[value/size-1][value%size] = FULL;
                }
            if (inBounds(value/size+1, value%size) && isOpen(value/size+1, value%size) && ! isFull(value/size+1, value%size)) {
                	qi.add((value/size+1)*size + value%size);
                	myGrid[value/size+1][value%size] = FULL;
                }
            if (inBounds(value/size, value%size-1) && isOpen(value/size, value%size-1) && ! isFull(value/size, value%size-1)) {
                	qi.add(value/size*size + value%size-1);
                	myGrid[value/size][value%size-1] = FULL;
                }
            if (inBounds(value/size, value%size+1) && isOpen(value/size, value%size+1) && ! isFull(value/size, value%size+1)) {
                	qi.add(value/size*size + value%size+1);
                	myGrid[value/size][value%size+1] = FULL;
                }
		}
	}

}
