package lab1_3;

public class XYLocation {
	private int row;
	private int col;

	public XYLocation(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public String toString() {
		return "[" + row + "][" + col + "]";
	}

}
