package lab2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {
	@Override
	public Node execute(Node tree, String goal) {
		Stack<Node> frontier = new Stack<Node>();// ds những node sẽ mở rộng
		frontier.push(tree);
		List<Node> explored = new ArrayList<Node>();// ds những node đã mở rộng
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(goal))
				return current;

			explored.add(current); // tree seach kh có//

			List<Edge> children = current.getChildren();
			for (int i = children.size() - 1; i >= 0; i--) {
				Edge tmp = children.get(i);
				Node child = tmp.getEnd();
				double newPathCost = current.getPathCost() + tmp.getWeight();
//tree seach kh co
				if (!frontier.contains(child) && !explored.contains(child)) {
					frontier.add(child);
					child.setParent(current);
					child.setPathCost(newPathCost);

				}
			}
			System.out.println(frontier.toString());
		}
		return null;
	}

	@Override
	public Node execute(Node tree, String start, String goal) {
		Stack<Node> frontier = new Stack<Node>();// ds những node sẽ mở rộng
		frontier.push(tree);
		List<Node> explored = new ArrayList<Node>();// ds những node đã mở rộng
		boolean isStart = false;
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(start)) {
				isStart = true;
				frontier.clear();
				explored.clear();
			} else if (current.getLabel().equals(goal) && isStart)
				return current;

			explored.add(current);
//			 mở rộng node con

			List<Edge> children = current.getChildren();
			for (int i = 0; i < children.size(); i++) {
				Edge tmp = children.get(i);
				Node child = tmp.getEnd();
				double newPathCost = current.getPathCost() + tmp.getWeight();

				if (!frontier.contains(child) && !explored.contains(child)) {
					frontier.add(child);
					if (isStart) {
						child.setParent(current);
						child.setPathCost(newPathCost);
					}

				}
			}
		}

		return null;
	}

	@Override
	public Node executeTree(Node root, String goal) {
		// TODO Auto-generated method stub
		if (root == null) {
			return null;
		}

		if (root.getLabel().equals(goal)) {
			return root;
		}

		List<Node> children = root.getChildrenNodes();

		for (Node child : children) {
			Node result = executeTree(child, goal);
			if (result != null) {
				return result;
			}
		}

		return null;
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		List<Node> explored = new ArrayList<>();

		while (!stack.isEmpty()) {
			Node current = stack.pop();

			if (current.getLabel().equals(goal)) {
				return current;
			}

			explored.add(current);

			List<Node> children = current.getChildrenNodes();

			for (Node child : children) {
				if (!stack.contains(child) && !explored.contains(child)) {
					stack.push(child);
					child.setParent(current);
				}
			}
		}

		return null;
	}
}
