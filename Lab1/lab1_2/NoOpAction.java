package lab1_2;

import lab1_2.Action;
import lab1_2.NoOpAction;

public class NoOpAction extends Action {
	public static final NoOpAction NO_OP = new NoOpAction();

	public boolean isNoOp() {
		return true;
	}
}