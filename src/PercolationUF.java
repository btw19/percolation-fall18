
public class PercolationUF implements IPercolate{
	private boolean[][] myGrid;
	private final int VTOP;
	private final int VBOTTOM;
	private IUnionFind myFinder;
	private int myOpenCount;
	
	public PercolationUF (int size, IUnionFind finder) {
		VTOP = size*size;
		VBOTTOM = size*size+1;
		myGrid = new boolean [size][size];
		finder.initialize(size*size+2);
		myFinder = finder;
	}
	
	
	@Override
	public void open(int row, int col) {
		if (! inBounds(row, col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		if (isOpen(row, col)) {
			return;
		}
		myGrid[row][col] = true;
		myOpenCount++;
		if(row == 0) {
			myFinder.union(getIndex(row,col), VTOP);
		}
		if(row == myGrid.length-1) {
			myFinder.union(getIndex(row, col), VBOTTOM);
		}
		if(inBounds(row-1, col) && isOpen(row-1, col)) {
			myFinder.union(getIndex(row, col), getIndex(row-1,col));
		}
		if(inBounds(row+1, col) && isOpen(row+1, col)) {
			myFinder.union(getIndex(row, col), getIndex(row+1,col));
		}
		if(inBounds(row, col-1) && isOpen(row, col-1)) {
			myFinder.union(getIndex(row, col), getIndex(row,col-1));
		}
		if(inBounds(row, col+1) && isOpen(row, col+1)) {
			myFinder.union(getIndex(row, col), getIndex(row,col+1));
		}
	}

	@Override
	public boolean isOpen(int row, int col) {
		if (! inBounds(row, col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		return myGrid[row][col];
	}

	@Override
	public boolean isFull(int row, int col) {
		if (! inBounds(row, col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		return myFinder.connected(getIndex(row, col), VTOP);
	}

	@Override
	public boolean percolates() {
		return myFinder.connected(VBOTTOM, VTOP);
	}

	@Override
	public int numberOfOpenSites() {
		return myOpenCount;
	}
	
	public int getIndex(int row, int col) {
		return row*myGrid.length + col;
	}
	
	private boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}

}
