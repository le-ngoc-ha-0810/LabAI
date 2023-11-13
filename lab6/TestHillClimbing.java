package lab6;

public class TestHillClimbing {
	public static void main(String[] args) {
		Node initialState = new Node();
		initialState.generateBoard();
		System.out.println(initialState.getH());
		initialState.displayBoard();
		
		System.out.println();
//		ILocalSearchAlgo hcs = new HillClimbingSearch();
//		Node goal=hcs.execute(initialState);
//		goal.displayBoard();
//		System.out.println(goal.getH());
		
		ILocalSearchAlgo hcsRandom= new HillClimbingWithRandomRestart();
		Node goalWithRd= hcsRandom.execute(initialState);
		goalWithRd.displayBoard();
		System.out.println(goalWithRd.getH());
		
	}
}
