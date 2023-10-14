package lab2;

public class BFSTest {
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
		nodeS.addEdge(nodeA, 5.0);
		nodeS.addEdge(nodeB, 2.0);
		nodeS.addEdge(nodeC, 4.0); 
		nodeA.addEdge(nodeD, 9.0);
		nodeA.addEdge(nodeE, 4.0); 
		nodeB.addEdge(nodeG, 6.0);
		nodeC.addEdge(nodeF, 2.0); 
		nodeD.addEdge(nodeH, 7.0);
		nodeE.addEdge(nodeG, 6.0);
		nodeF.addEdge(nodeG, 1.0);

		System.out.println("task1:....................");
		ISearchAlgo algo1 = new BreadthFirstSeachAlgo();
		Node result = algo1.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result) + " " + result.getPathCost());

		System.out.println("Task3:................");
// Test Breadth-First Search on the tree
		ISearchAlgo bfsAlgo = new BreadthFirstSeachAlgo();
		Node bfsResult = bfsAlgo.executeTree(nodeS, "G");
		System.out.println("BFS Result: " + NodeUtils.printPath(bfsResult) + " " + bfsResult.getPathCost());



//System.out.println("Task4:................");
//ISearchAlgo ucsAlgo = new UniformCostSearchAlgo();
//Node ucsResult = ucsAlgo.execute(nodeS, "G");
//System.out.println("Uniform Cost Search Result: " + NodeUtils.printPath(ucsResult) + " " + ucsResult.getPathCost());
//
//System.out.println("Task5: .............");
//ISearchAlgo ucsAlgo5 = new UniformCostSearchAlgo();
//Node ucsResult5 = ucsAlgo.execute(nodeS, "S", "G");
//
//System.out.println("Uniform Cost Search Result: " + NodeUtils.printPath(ucsResult) + " " + ucsResult.getPathCost());

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

		System.out.println("Task Additional :................");
// Test Breadth-First Search on the tree
		ISearchAlgo bfsadd = new BreadthFirstSeachAlgo();
		Node bfsResultadd = bfsadd.executeTree(nodeS1, "G1");
		System.out.println("BFS Result: " + NodeUtils.printPath(bfsResultadd) + " " + bfsResultadd.getPathCost());

	}

}
