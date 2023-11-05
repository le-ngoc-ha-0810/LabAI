package lab5;

public class TestGBFS_8Puzzles {
	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("D:\\CodeJava\\AI2023\\src\\txt\\PuzzleMap.txt", "D:\\CodeJava\\AI2023\\src\\txt\\PuzzleGoalState.txt");
		IPuzzleAlgo gbfs = new GreedyBestFirstSearch_8Puzzles();
		System.out.println(p.getInitialState());

		Node g = gbfs.execute(p);
		System.out.println(g.toString() + "Pathcost: " + g.getG());
	}
}
