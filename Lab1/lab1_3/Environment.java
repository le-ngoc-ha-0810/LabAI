package lab1_3;

import lab1_3.Action;
import lab1_3.DynamicAction;

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");

//	enum dùng để định nghĩa tập hợp các hằng số cụ thể
	public enum LocationState {
		CLEAN, DIRTY, WALL;
	}

	private EnvironmentState envState;
	private boolean isDone = false; // tất cả các ô đ�?u sạch
	private Agent agent = null;

	private int point = 0;

	public Environment(int row, int col) {
		envState = new EnvironmentState(row, col);
	}

//	Thêm agent vào môi trư�?ng
	public void addAgent(Agent agent) {
		this.agent = agent;
		this.envState.setAgentLocation(new XYLocation(0, 0));
	}

	public EnvironmentState getCurrentState() {
		return envState;
	}

//	cập nhật lại trạng thái môi trư�?ng khi agent hoạt động
	public EnvironmentState executeAction(Action action) {
		XYLocation agentLoc = envState.getAgentLocation();
		if (action.equals(SUCK_DIRT)) {
			point += 500;
			envState.setLocationState(agentLoc.getRow(), agentLoc.getCol(), LocationState.CLEAN);
		} else if (action.equals(MOVE_UP))
			moveOrStand("UP");
		else if (action.equals(MOVE_RIGHT))
			moveOrStand("RIGHT");
		else if (action.equals(MOVE_DOWN))
			moveOrStand("DOWN");
		else if (action.equals(MOVE_LEFT))
			moveOrStand("LEFT");

		return envState;
	}

//	qua dai
	public void moveOrStand(String action) {
		XYLocation agentLocation = envState.getAgentLocation();
		int agentRow = agentLocation.getRow();
		int agentCol = agentLocation.getCol();
		switch (action) {
		case "UP":
			if ((agentRow - 1 >= 0) && (envState.getLocationState(agentRow - 1, agentCol) != LocationState.WALL)) {
				point -= 10;
				envState.setAgentLocation(new XYLocation(agentRow - 1, agentCol));
			} else {
				point -= 100;
				envState.setAgentLocation(agentLocation);
			}
			break;
		case "RIGHT":
			if ((agentCol + 1) <= envState.getState()[0].length
					&& (envState.getLocationState(agentRow, agentCol + 1) != LocationState.WALL)) {
				point -= 10;
				envState.setAgentLocation(new XYLocation(agentRow, agentCol + 1));
			} else {
				point -= 100;
				envState.setAgentLocation(agentLocation);
			}
			break;
		case "DOWN":
			if ((agentRow + 1 <= envState.getState().length)
					&& (envState.getLocationState(agentRow + 1, agentCol) != LocationState.WALL)) {
				point -= 10;
				envState.setAgentLocation(new XYLocation(agentRow + 1, agentCol));
			} else {
				point -= 100;
				envState.setAgentLocation(agentLocation);
			}
			break;
		case "LEFT":
			if ((agentCol - 1) >= 0 && (envState.getLocationState(agentRow, agentCol - 1) != LocationState.WALL)) {
				point -= 10;
				envState.setAgentLocation(new XYLocation(agentRow, agentCol - 1));
			} else {
				point -= 100;
				envState.setAgentLocation(agentLocation);
			}
			break;
		}

	}

	public Percept getPerceptSeenBy() {
		XYLocation agentLoc = envState.getAgentLocation();
		LocationState agentLocState = envState.getLocationState(agentLoc.getRow(), agentLoc.getCol());
		return new Percept(agentLoc, agentLocState);
	}

	public void step() {
		envState.display();
		XYLocation agentLocation = envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState envs = executeAction(anAction);
		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction + "\tPoint: " + point);

		int envsRow = envs.getState().length;
		int envsCol = envs.getState()[0].length;
		int count = 0;
		for (int i = 0; i < envsRow; i++) {
			for (int j = 0; j < envsCol; j++) {
				if (envs.getLocationState(i, j) == LocationState.CLEAN)
					count++;
			}
		}
//		xem lại
		int numberOfWall = (int) Math.round(envsRow * envsCol * EnvironmentState.WALL_RATE);
		int numberOfClean = envsRow * envsCol - numberOfWall;
		if (count == numberOfClean)
			isDone = true;
		System.out.println(count);
		envs.display();
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("--------------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 1;
		while (!isDone) {
			System.out.println("Step: " + i++);
			step();
			System.out.println("-----------------------------------");
		}
	}
}
