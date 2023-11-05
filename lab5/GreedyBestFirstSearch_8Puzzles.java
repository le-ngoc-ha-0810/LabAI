package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearch_8Puzzles implements IPuzzleAlgo {
	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explored = new ArrayList<Node>();
		Node initial = model.getInitialState();
		frontier.add(initial);

		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.equals(model.getGoalState()))
				return current;
			explored.add(current);
			List<Node> childStates = model.getSuccessors(current);
			for (Node n : childStates) {
				if (!frontier.contains(n) && !explored.contains(n)) {
					frontier.add(n);
					n.setG(current.getG() + 1);
				}

			}
		}
		return null;
	}
}
