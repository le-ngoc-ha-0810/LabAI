package lab5;

public class TestAStar_8Puzzles {
	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("D:\\CodeJava\\AI2023\\src\\txt\\PuzzleMap.txt", "D:\\CodeJava\\AI2023\\src\\txt\\PuzzleGoalState.txt");
		IPuzzleAlgo aStar = new AStar_8Puzzles();
		System.out.println(p.getInitialState());

		Node g = aStar.execute(p);
		System.out.println(g.toString() + ", Pathcost: " + g.getG());
	}
}
