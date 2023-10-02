package lab1_3;

import lab1_3.Action;

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
