
public class PercolationUF implements IPercolate{
	boolean[][] myGrid = new boolean[0][0];
	private final int VTOP;
	private final int VBOTTOM;
	IUnionFind myFinder = new IUnionFind();
	private int myOpenCount = 0;
	
	public PercolationUF (int size, IUnionFind finder) {
		VTOP = size*size;
		VBOTTOM = size*size+1;
		myGrid = myGrid[size][size];
	}
	
	
	@Override
	public void open(int row, int col) {
		if (row > VTOP || col > VTOP) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		
		
	}

	@Override
	public boolean isOpen(int row, int col) {
		if (row > VTOP || col > VTOP) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		return false;
	}

	@Override
	public boolean isFull(int row, int col) {
		if (row > VTOP || col > VTOP) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		
		return false;
	}

	@Override
	public boolean percolates() {
		if (VTOP VBOTTOM) {
			return true;
		}
		return false;
	}

	@Override
	public int numberOfOpenSites() {
		// TODO Auto-generated method stub
		return myOpenCount;
	}
	
	public int getIndex(int row, int col, int n) {
		return row*n + col;
	}

}
