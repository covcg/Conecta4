package domain;

import java.awt.event.KeyEvent;

public class Player {
	private final boolean[] options;

	public Player() {
		this.options = new boolean[8];
		for (boolean option : options) {
			option = false;
		}
	}

	public void processEvents(final boolean[] keys) {
		int [] keysCodes = {KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5, KeyEvent.VK_6, KeyEvent.VK_7};
		for (int i = 0; i < 7; i++) {
			options[i] = keys[keysCodes[i]];
			keys[keysCodes[i]] = false;
		}
	}

	public void update(final double delta, Board board) {
		for (int i = 0; i < 7; i++) {
			if (options[i]) {
				board.addToken(i);
				options[i] = false;
			}
		}
	}
}
