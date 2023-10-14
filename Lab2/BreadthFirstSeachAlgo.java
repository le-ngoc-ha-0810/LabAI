package lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSeachAlgo implements ISearchAlgo {
	@Override
	public Node execute(Node tree, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();// ds những node sẽ mở rộng
		frontier.add(tree);
		List<Node> explored = new ArrayList<Node>();// ds những node đã mở rộng
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal))
				return current;

			explored.add(current);
			List<Edge> children = current.getChildren();
			for (int i = 0; i < children.size(); i++) {
				Edge tmp = children.get(i);
				Node child = tmp.getEnd();
				double newPathCost = current.getPathCost() + tmp.getWeight();

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
		Queue<Node> frontier = new LinkedList<Node>();// ds những node sẽ mở rộng
		List<Node> explored = new ArrayList<Node>();// ds những node đã mở rộng
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

	// Cau 3: TREE
	@Override
	public Node executeTree(Node root, String goal) {
	    Queue<Node> frontier = new LinkedList<>();
	    frontier.add(root);
	    List<Node> explored = new ArrayList<>();
	    Map<Node, Double> pathCosts = new HashMap<>(); // To store the path cost for each node

	    pathCosts.put(root, 0.0); // Initialize the path cost for the root

	    while (!frontier.isEmpty()) {
	        Node current = frontier.poll();
	        double currentCost = pathCosts.get(current);
	        System.out.println(getFrontierContents(frontier, pathCosts) + " (Path Cost: " + currentCost + ")");

	        if (current.getLabel().equals(goal)) {
	            return current;
	        }

	        explored.add(current);

	        List<Node> children = current.getChildrenNodes();

	        for (Node child : children) {
	            if (!frontier.contains(child) && !explored.contains(child)) {
	                frontier.add(child);
	                child.setParent(current);

	                // Update the path cost for the child node
	                double childCost = currentCost + child.getPathCost(); // Assuming there's a method like getPathCost()
	                pathCosts.put(child, childCost);
	            }
	        }
	    }

	    return null;
	}

	// Helper method to get the contents of the frontier queue along with path cost
	private String getFrontierContents(Queue<Node> frontier, Map<Node, Double> pathCosts) {
	    List<String> contents = new ArrayList<>();
	    for (Node node : frontier) {
	        String nodeLabel = node.getLabel();
	        double cost = pathCosts.get(node);
	        contents.add(nodeLabel + " (Cost: " + cost + ")");
	    }
	    return contents.toString();
	}
	@Override
	public Node executeTree(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		 Queue<Node> frontier = new LinkedList<>();
	     frontier.add(root);
	     List<Node> explored = new ArrayList<>();

	     while (!frontier.isEmpty()) {
	         Node current = frontier.poll();

	         if (current.getLabel().equals(goal)) {
	             return current;
	         }

	         explored.add(current);

	         List<Node> children = current.getChildrenNodes();

	         for (Node child : children) {
	             if (!frontier.contains(child) && !explored.contains(child)) {
	                 frontier.add(child);
	                 child.setParent(current);
	             }
	         }
	     }

	     return null;
	}

}
