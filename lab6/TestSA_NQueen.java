package lab6;

public class TestSA_NQueen {
	public static void main(String[] args) {
		Node initialState = new Node();
		initialState.generateBoard();
		System.out.println(initialState.getH());
		initialState.displayBoard();

		ILocalSearchAlgo sa = new SA_NQueen();
		Node g = sa.execute(initialState);
		g.displayBoard();
	}
}
