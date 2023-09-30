package lab1_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import lab1_2.Environment.LocationState;

public class EnvironmentState {
	private LocationState[][] state;
	private XYLocation agentLocation;// trong trường hợp có nhiều agent thì có thể dùng map để lưu trữ agent
	public static final double DIRT_RATE = 0.2;
	public static final double WALL_RATE = 0.1;

	public EnvironmentState(int row, int col) {
		state = new LocationState[row][col];
		initEnvironment();
	}

	public void initEnvironment() {
//		dirt trung vs wall
		int numberOfWall = (int) Math.round(state.length * state[0].length * WALL_RATE);
		int numberOfDirt = (int) Math.round(state.length * state[0].length * DIRT_RATE);
		int countWall = 0;
		int countDirt = 0;
		Random rd = new Random();
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[0].length; j++) {
				state[i][j] = LocationState.CLEAN;
			}
		}
		while (countWall != numberOfWall) {
			int rdRow = rd.nextInt(state.length);
			int rdCol = rd.nextInt(state[0].length);
			if (rdRow != 0 || rdCol != 0) {
				state[rdRow][rdCol] = LocationState.WALL;
				countWall++;
			}
		}

		while (countDirt != numberOfDirt) {
			int rdRow = rd.nextInt(state.length);
			int rdCol = rd.nextInt(state[0].length);
//			for (int i = 0; i < state.length; i++) {
//				for (int j = 0; j < state[0].length; j++) {
//					if (state[rdRow][rdCol] != LocationState.WALL)
			state[rdRow][rdCol] = LocationState.DIRTY;
//				}
//			}

			countDirt++;
		}

	}

	public LocationState getLocationState(int x, int y) {
		return state[x][y];
	}

	public void setLocationState(int x, int y, LocationState locationState) {
		this.state[x][y] = locationState;
	}

	public XYLocation getAgentLocation() {
		return agentLocation;
	}

	public void setAgentLocation(XYLocation agentLocation) {
		this.agentLocation = agentLocation;
	}

	public LocationState[][] getState() {
		return state;
	}

	public void display() {
		System.out.println("Environment state:");
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[0].length; j++) {
				System.out.print(state[i][j] + "\t");
			}
			System.out.println();
		}

	}
}
