package lab6;

public class SA_NQueen implements ILocalSearchAlgo {
	@Override
	public Node execute(Node initialState) {
		int T = 10000;
		Node current = new Node(initialState);
		while (current.getH() != 0) {
			int currentH = current.getH();
			Node next = current.selectNextRandomCandidate();
			int deltaE = next.getH() - currentH;
			if (deltaE < 0) // deltaE nhỏ hơn 0 nghĩa là next có H nhỏ hơn current
				current = new Node(next);
			else if (Math.exp(deltaE / (T * 1.0)) > Math.random())
				current = new Node(next);//chấp nhận node khác chưa tối ưu theo 1 xác suất nhất định
			T--;
		}
		System.out.println("T is: " + T);
		return current;
	}
}
