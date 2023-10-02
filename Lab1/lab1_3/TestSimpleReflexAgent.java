package lab1_3;

import lab1_3.Environment.LocationState;

public class TestSimpleReflexAgent {
	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		Environment env = new Environment(3, 3);
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent);
//		env.step(10);
		env.stepUntilDone();
		double end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
