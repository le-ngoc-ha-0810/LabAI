package lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node implements Comparable<Node>{
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		// generateBoard();
		state = new Queen[N];
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (state[i].isConflict(state[j]))
					heuristic++;
			}
		}
		return heuristic;
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		Node tmp = null;
		Node nextState = null;

		for (int i = 0; i < N; i++) {
			tmp = new Node(state);// tạo node mới có trạng thái giống trạng thái hiện tại
			tmp.state[i].move();// thay đổi vị trí của hậu
			nextState = new Node(tmp);// tạo node mới lưu trạng thái của 1 hậu vừa mới di chuyển
			result.add(nextState);
		}
		return result;
	}

	public Node getBestState() {
		List<Node> re=this.generateAllCandidates();
		Collections.sort(re);;
		return re.get(0);
	}

	public Node selectNextRandomCandidate() {
		Random rd = new Random();
		int i = rd.nextInt(N);
		Node result = new Node(state);
		result.state[i].setRow(rd.nextInt(N));
		return result;
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}


	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.getH()-o.getH();
	}

	
}
