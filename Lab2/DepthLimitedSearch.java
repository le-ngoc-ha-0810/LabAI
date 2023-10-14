package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearch {
	public Node execute(Node root, String goal, int limitedDepth) {
		Node result;
		if (root.getLabel().equals(goal))
			return root;
		else if (limitedDepth == 0)
			return null;
		else { 
			List<Edge> children = root.getChildren();
			for (int i = 0; i < children.size(); i++) {
				Node child = children.get(i).getEnd();
				child.setParent(root);
				child.setPathCost(root.getPathCost() + children.get(i).getWeight());
				result = execute(child, goal, limitedDepth - 1);
				if (result != null)
					return result;
			}
		}
		return null;
	}

}
