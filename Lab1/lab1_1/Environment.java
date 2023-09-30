package lab1_1;

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";

	public enum LocationState {
		CLEAN, DIRTY;
	}

	private EnvironmentState envState;
	private boolean isDone = false;
	private Agent agent = null;

	public Environment(LocationState locAState, LocationState locBState) {
		envState = new EnvironmentState(locAState, locBState);
	}

	public void addAgent(Agent agent, String location) {
		this.agent = agent;
		this.envState.setAgentLocation(location);
	}

	public EnvironmentState getCurrentState() {
		return envState;
	}

	public EnvironmentState executeAction(Action action) {
		String agentLoc = envState.getAgentLocation();
		if (action.equals(SUCK_DIRT))
			envState.setLocationState(agentLoc, LocationState.CLEAN); 
		else if (action.equals(MOVE_RIGHT))
			envState.setAgentLocation(LOCATION_B);
		else if (action.equals(MOVE_LEFT))
			envState.setAgentLocation(LOCATION_A);
		return envState;
	}

	public Percept getPerceptSeenBy() {
		String agentLoc = envState.getAgentLocation();
		LocationState agentLocState = envState.getLocationState(agentLoc);
		return new Percept(agentLoc, agentLocState);
	}

	public void step() {
		envState.display();
		String agentLocation = envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState envs = executeAction(anAction);
		System.out.println("Agent Location: " + agentLocation + "\tAction: " + anAction);

		if ((envs.getLocationState(LOCATION_A) == LocationState.CLEAN)
				&& (envs.getLocationState(LOCATION_B) == LocationState.CLEAN))
			isDone = true;

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
