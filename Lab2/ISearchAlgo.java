package lab2;

public interface ISearchAlgo {
	public Node execute(Node root, String goal);// find the path from root node to the goal node

	public Node execute(Node root, String start, String goal); // find the path from start node to the goal node

	public Node executeTree(Node nodeS, String string);

	public Node executeTree(Node root, String start, String goal);
}