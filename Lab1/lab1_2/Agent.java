package lab1_2;

import lab1_2.Action;
import lab1_2.AgentProgram;
import lab1_2.NoOpAction;
import lab1_2.Percept;

public class Agent {
	private AgentProgram program;

	public Agent() {
	}

	public Agent(AgentProgram aProgram) {
		program = aProgram;
	}

	public Action execute(Percept p) {
		if (program != null) {
			return program.execute(p);
		}
		return NoOpAction.NO_OP;
	}
}
