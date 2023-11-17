package lab7;

public class TestGA_NQueenAlgo {
	public static void main(String[] args) {
		GA_NQueenAlgo ga = new GA_NQueenAlgo();
		Node re = ga.execute();
		re.displayBoard();
		System.out.println(re.getH());
	}
}
