package lab1_3;

import lab1_3.Action;
import lab1_3.NoOpAction;

public class NoOpAction extends Action {
	public static final NoOpAction NO_OP = new NoOpAction();

	public boolean isNoOp() {
		return true;
	}
}