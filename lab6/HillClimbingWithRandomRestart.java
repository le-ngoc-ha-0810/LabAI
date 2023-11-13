package lab6;

public class HillClimbingWithRandomRestart implements ILocalSearchAlgo {
	int randomRestarts = 0;

	@Override
	public Node execute(Node initialState) {
		HillClimbingSearch hcs = new HillClimbingSearch();
		Node state = hcs.execute(initialState);
		while (state.getH() != 0) {
			state = new Node();
			state.generateBoard();// tạo lại bảng
			randomRestarts++;
			hcs.stepClimbedAfterRandomRestart = 0;
			state = hcs.execute(state);
		}
		System.out.println("Step climbed: "+hcs.stepClimb);
		System.out.println("Step climb after random : "+hcs.stepClimbedAfterRandomRestart);
		System.out.println("Number of random: "+randomRestarts);
		return state;
	}
}
