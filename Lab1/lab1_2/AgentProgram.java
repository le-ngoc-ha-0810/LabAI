package lab1_2;

import java.util.Random;

import lab1_2.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept percept) {
		Random rd = new Random();
		int rdNumber = rd.nextInt(4);
		if (percept.getState() == LocationState.DIRTY)
			return Environment.SUCK_DIRT;
		switch (rdNumber) {
		case 0:
			return Environment.MOVE_UP;
		case 1:
			return Environment.MOVE_RIGHT;
		case 2:
			return Environment.MOVE_DOWN;
		case 3:
			return Environment.MOVE_LEFT;
		}
		return NoOpAction.NO_OP;
	}
//	trong trường hợp bài này chỉ thao tác qua lại 2 ô nên chỉ cần 1 agentProgram thôi
//	nếu muốn mở rộng thêm các hoạt động thì sẽ cso thểm nhiều agentProgram khác
}
