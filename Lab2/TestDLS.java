package lab2;

public class TestDLS {
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
		Node nodeI = new Node("I");
		Node nodeJ = new Node("J");
		Node nodeK = new Node("K");
		Node nodeL = new Node("L");
		Node nodeM = new Node("M");
		Node nodeN = new Node("N");
		Node nodeO = new Node("O");
		Node nodeP = new Node("P");
		Node nodeR = new Node("R");

		nodeA.addEdge(nodeB);
		nodeA.addEdge(nodeC);
		nodeA.addEdge(nodeD);

		nodeB.addEdge(nodeE);
		nodeB.addEdge(nodeF);

		nodeC.addEdge(nodeG);
		
		nodeD.addEdge(nodeH);
		
		nodeE.addEdge(nodeI);
		nodeF.addEdge(nodeJ);
		nodeF.addEdge(nodeK);
		nodeG.addEdge(nodeL);
		nodeH.addEdge(nodeM);
		nodeH.addEdge(nodeN);
		nodeK.addEdge(nodeO);
		nodeK.addEdge(nodeP);
		nodeN.addEdge(nodeS);
		nodeL.addEdge(nodeR);
//		Node nodeS1 = new Node("S1");
//		Node nodeA1 = new Node("A1");
//		Node nodeB1 = new Node("B1");
//		Node nodeC1 = new Node("C1");
//		Node nodeD1 = new Node("D1");
//		Node nodeE1 = new Node("E1");
//		Node nodeF1 = new Node("F1");
//		Node nodeG1 = new Node("G1");
//		Node nodeH1 = new Node("H1");
//		Node nodeP1 = new Node("P1");
//		Node nodeQ1 = new Node("Q1");
//		Node nodeR1 = new Node("R1");
//		nodeS1.addEdge(nodeD1, 3.0);
//		nodeS1.addEdge(nodeE1, 9.0);
//		nodeS1.addEdge(nodeB1, 1.0);
//		nodeD1.addEdge(nodeE1, 2.0);
//		nodeD1.addEdge(nodeC1, 8.0);
//		nodeD1.addEdge(nodeB1, 1.0);
//		nodeB1.addEdge(nodeA1, 2.0);
//		nodeC1.addEdge(nodeA1, 2.0);
//		nodeP1.addEdge(nodeQ1, 15.0);
//		nodeQ1.addEdge(nodeR1, 3.0);
//		nodeE1.addEdge(nodeH1, 1.0);
//		nodeE1.addEdge(nodeR1, 9.0);
//		nodeH1.addEdge(nodeP1, 4.0);
//		nodeH1.addEdge(nodeQ1, 4.0);
//		nodeR1.addEdge(nodeF1, 5.0);
//		nodeF1.addEdge(nodeC1, 5.0);
//		nodeF1.addEdge(nodeG1, 5.0);

		DepthLimitedSearch dls = new DepthLimitedSearch();
		Node goal = dls.execute(nodeA, "R", 4); // Tìm node "S1" với giới hạn độ sâu là 4
		if (goal != null) {
			System.out.println(NodeUtils.printPath(goal) + " Pathcost: " + goal.getPathCost());
		} else {
			System.out.println("Goal not found.");
		}

	}
}
