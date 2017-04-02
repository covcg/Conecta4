package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	private final static int KEYS_NUMBER = 255;
	private final boolean[] keys = new boolean[Keyboard.KEYS_NUMBER];

	public Keyboard() {
		for (boolean key : this.keys) {
			key = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		this.keys[(int)e.getExtendedKeyCode()] = true;
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	public boolean[] getKeys() {
		return this.keys;
	}
}
