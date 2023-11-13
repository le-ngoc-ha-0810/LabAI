package lab6;

import java.util.List;

public class HillClimbingSearch implements ILocalSearchAlgo {
	int stepClimb = 0;
	int stepClimbedAfterRandomRestart = 0;

	@Override
	public Node execute(Node initialState) {
		Node current = new Node(initialState);
		while (true) {
			Node neighbor = current.getBestState();
			if (neighbor.getH() < current.getH()) {
				current = neighbor;
				stepClimb++;
				stepClimbedAfterRandomRestart++;
			} else
				return current;
		}
	}
}