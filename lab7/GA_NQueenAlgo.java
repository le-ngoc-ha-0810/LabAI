package lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// kích thước quần thể
	public static final double MUTATION_RATE = 0.03;// tỉ lệ đột biến
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// khởi tạo từng cá thể trong quần thể
	public void initPoputation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node n = new Node();
			n.generateBoard();
			population.add(n);
		}
	}

	public Node execute() {
		initPoputation();
		int count = 0;
		while (count <= MAX_ITERATIONS) {
			while (count++ < MAX_ITERATIONS) {
				List<Node> newPopulation = new ArrayList<Node>();
				for (int i = 0; i < POP_SIZE; i++) {
					Node x = getParentByTournamentSelection();
					Node y = getParentByTournamentSelection();
					Node child = preproduce(x, y);
					if (rd.nextDouble() < MUTATION_RATE)
						mutate(child);
					if (child.getH() == 0) {
						System.out.println("So lan lap: " + count + ", i: " + i);
						return child;
					}
					newPopulation.add(child);
				}
				// nếu như chưa tìm ra lời giải thì tạo lại population và tiếp tục tìm lời giải
				population = newPopulation;
//				count++;
			}
		}
		// nếu như lặp hết MAX_ITERATIONS mà vẫn chưa tìm được lời giải thì chấp nhận
		// lời giải tốt nhất trong quần thể
		Collections.sort(population);
		return population.get(0);
	}

	// đột biến một cá thể băng cách lựa chọn ngẫu nhiên 1 hậu và di chuyển đến 1
	// hàng bất kì
	public void mutate(Node node) {
		int i = rd.nextInt(Node.N);
		int row = rd.nextInt(Node.N);
		node.setRow(i, row);
	}

	// tạo ra 1 điểm cắt ngẫu nhiên, trước điểm cắt sẽ lấy hàng của cha bỏ vào con,
	// sau điểm cắt sẽ lấy hàng của mẹ bỏ vào con
	public Node preproduce(Node x, Node y) {
		int c = rd.nextInt(Node.N);
		Node result = new Node();
		result.generateBoard(); // sap ngau nhien cac quan hau truoc
		for (int i = 0; i < Node.N; i++) {
			if (i <= c)
				result.setRow(i, x.getRow(i));// trước điểm cắt, lấy hàng của cha bỏ vào con
			else
				result.setRow(i, y.getRow(i));// sau điểm cắt lấy hàng của mẹ bỏ vào con
		}
		return result;
	}

	// lựa chọn ngẫu nhiên K cá thể trong quân thể r chọn ra cá thể tốt nhất trong
	// K để làm bố mẹ
	public Node getParentByTournamentSelection() {
		int k = 3;
		List<Node> randomIndividual = new ArrayList<Node>();
		for (int i = 0; i < k; i++) {
			randomIndividual.add(population.get(rd.nextInt(POP_SIZE)));
		}
		Collections.sort(randomIndividual);
		return randomIndividual.get(0);
	}

	// Lựa chọn 2 cá thể ngẫu nhiên để làm bố mẹ
	public Node getParentByRandomSelection() {
		return population.get(rd.nextInt(POP_SIZE));
	}
}
