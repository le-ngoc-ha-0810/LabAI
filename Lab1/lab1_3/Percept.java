package lab1_3;

import lab1_3.Environment.LocationState;

public class Percept {
	private XYLocation agentLocation;
	private LocationState state;

	public Percept(XYLocation agentLocation, LocationState state) {
		super();
		this.agentLocation = agentLocation;
		this.state = state;
	}

	public XYLocation getAgentLocation() {
		return agentLocation;
	}

	public LocationState getState() {
		return state;
	}

}
