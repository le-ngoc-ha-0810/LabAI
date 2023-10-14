 package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {
	@Override
	public Node execute(Node tree, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		List<Node> explored = new ArrayList<Node>();
		frontier.add(tree);
		double newPathCost;

		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal))
				return current;

			explored.add(current);
			List<Edge> children = current.getChildren();
			for (int i = 0; i < children.size(); i++) {
				Edge tmp = children.get(i);
				Node child = tmp.getEnd();
				newPathCost = current.getPathCost() + tmp.getWeight();

				if (!frontier.contains(child) && !explored.contains(child)) {
					child.setParent(current);
					child.setPathCost(newPathCost);
					frontier.add(child);
// tree search khong co cho nay
				} else if (frontier.contains(child) && (newPathCost < child.getPathCost())) {
					child.setPathCost(newPathCost);
					child.setParent(current);
				}

			}
			System.out.println(frontier.toString());
		}

		return null;
	}

	@Override
	public Node execute(Node tree, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		List<Node> explored = new ArrayList<Node>();
		frontier.add(tree);
		boolean isStart = false;

		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(start)) {
				isStart = true;
				frontier.clear();
				explored.clear();
			} else if (current.getLabel().equals(goal) && isStart)
				return current;

			explored.add(current);
			List<Edge> children = current.getChildren();
			for (int i = 0; i < children.size(); i++) {
				Edge tmp = children.get(i);
				Node child = tmp.getEnd();
				double newPathCost = current.getPathCost() + tmp.getWeight();

				if (!frontier.contains(child) && !explored.contains(child)) {
					if (isStart) {
						child.setParent(current);
						child.setPathCost(newPathCost);
					}
					frontier.add(child);
				} else if (frontier.contains(child) && (newPathCost < child.getPathCost())) {
					child.setPathCost(newPathCost);
					child.setParent(current);
				}

			}
		}
		return null;
	}

	@Override
	public Node executeTree(Node nodeS, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
