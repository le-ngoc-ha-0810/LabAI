package lab1_2;

import lab1_2.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		// TODO
		if (p.getLocationState() == LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		}

		String currentLocation = p.getAgentLocation();

		// Randomly choose a direction to move
		int randomMove = (int) (Math.random() * 4); // 0, 1, 2, or 3
		switch (randomMove) {
		case 0:
			return Environment.MOVE_RIGHT;
		case 1:
			return Environment.MOVE_LEFT;
		case 2:
			return Environment.MOVE_UP;
		case 3:
			return Environment.MOVE_DOWN;
		}

		return NoOpAction.NO_OP;
	}
}
