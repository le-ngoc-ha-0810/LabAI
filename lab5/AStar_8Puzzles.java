package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStar_8Puzzles implements IPuzzleAlgo {
	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByF);
		List<Node> explored = new ArrayList<Node>();
		frontier.add(model.getInitialState());

		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.equals(model.getGoalState()))
				return current;
			explored.add(current);
			List<Node> childStates = model.getSuccessors(current);
			for (Node n : childStates) {
				int newPathCost = current.getG() + 1;
				if (!frontier.contains(n) && !explored.contains(n)) {
					frontier.add(n);
					n.setG(newPathCost);
				}

				else if (frontier.contains(n) && n.getG() > newPathCost) {
					n.setG(newPathCost);
				}
			}
		}
		return null;
	}

}
