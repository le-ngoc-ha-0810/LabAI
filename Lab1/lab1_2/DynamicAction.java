package lab1_2;

import lab1_2.Action;

public class DynamicAction extends Action {
	private String name;

	public DynamicAction(String name) {
		this.name = name;
	}

	@Override
	public boolean isNoOp() {
		return false;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
