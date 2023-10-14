package lab2;

public class DFSTest {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");

		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeE, 4);
		nodeS.addEdge(nodeB, 2);
		nodeB.addEdge(nodeG, 6);
		nodeA.addEdge(nodeD, 9);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 4);
		nodeF.addEdge(nodeG, 1);
		nodeE.addEdge(nodeG, 6);

		System.out.println("task1:....................");
		ISearchAlgo algo = new DepthFirstSearchAlgo();
		NodeUtils print = new NodeUtils();
		Node goal = algo.execute(nodeS, "G");
		System.out.println(print.printPath(goal) + " Path cost: " + goal.getPathCost());

		// Test Depth-First Search on the tree
		System.out.println("task3:....................");
		ISearchAlgo dfsAlgo = new DepthFirstSearchAlgo();
		Node dfsResult = dfsAlgo.executeTree(nodeE, "C", "G");
		System.out.println("DFS Result: " + NodeUtils.printPath(dfsResult) + " " + dfsResult.getPathCost());
		
		
		Node nodeS1 = new Node("S1");
		Node nodeA1 = new Node("A1");
		Node nodeB1 = new Node("B1");
		Node nodeC1 = new Node("C1");
		Node nodeD1 = new Node("D1");
		Node nodeE1 = new Node("E1");
		Node nodeF1 = new Node("F1");
		Node nodeG1 = new Node("G1");
		Node nodeH1 = new Node("H1");
		Node nodeP1 = new Node("P1");
		Node nodeQ1 = new Node("Q1");
		Node nodeR1 = new Node("R1");
		nodeS1.addEdge(nodeD1, 3.0);
		nodeS1.addEdge(nodeE1, 9.0);
		nodeS1.addEdge(nodeB1, 1.0);
		nodeD1.addEdge(nodeE1, 2.0);
		nodeD1.addEdge(nodeC1, 8.0);
		nodeD1.addEdge(nodeB1, 1.0);
		nodeB1.addEdge(nodeA1, 2.0);
		nodeC1.addEdge(nodeA1, 2.0);
		nodeP1.addEdge(nodeQ1, 15.0);
		nodeQ1.addEdge(nodeR1, 3.0);
		nodeE1.addEdge(nodeH1, 1.0);
		nodeE1.addEdge(nodeR1, 9.0);
		nodeH1.addEdge(nodeP1, 4.0);
		nodeH1.addEdge(nodeQ1, 4.0);
		nodeR1.addEdge(nodeF1, 5.0);
		nodeF1.addEdge(nodeC1, 5.0);
		nodeF1.addEdge(nodeG1, 5.0);
		
		// Test Depth-First Search on the tree
	    ISearchAlgo dfsadd = new DepthFirstSearchAlgo();
	    Node dfsResultadd = dfsadd.executeTree(nodeE1, "R1", "G1");
	    System.out.println("DFS Result: " + NodeUtils.printPath(dfsResultadd) + " " + dfsResultadd.getPathCost());
	}

}
