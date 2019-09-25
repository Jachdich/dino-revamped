package com.cospox.dino;

import java.util.HashMap;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class EventHandler implements InputProcessor {
	private Events callClass = null;
	private HashMap<Integer, Boolean> keys = new HashMap<Integer, Boolean>();
	
	public EventHandler() {
	}
	
	public EventHandler(Events callClass) {
		this.callClass = callClass;
	}
	
	public boolean shift() {
		return this.keys.get(Keys.SHIFT_LEFT) || this.keys.get(Keys.SHIFT_RIGHT);
	}
	
	public boolean ctrl() {
		return this.keys.get(Keys.CONTROL_LEFT) || this.keys.get(Keys.CONTROL_RIGHT);
	}
	
	public boolean get(int keycode) {
		return this.keys.get(keycode);
	}
	
	public boolean get(char c) {
		return this.keys.get(Keys.valueOf(Character.toString(c)));
	}
	
	@Override
	public boolean keyDown(int keyCode) {
		this.keys.put(keyCode, true);
		this.callClass.keyPressed(keyCode);
		return false;
	}
	
	@Override
	public boolean keyUp(int keyCode) {
		this.keys.put(keyCode, false);
		this.callClass.keyReleased(keyCode);
		return false;
	}

	@Override
	public boolean keyTyped (char character) {
		return false;
	}

	@Override
	public boolean touchDown (int x, int y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp (int x, int y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged (int x, int y, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved (int x, int y) {
		return false;
	}

	@Override
	public boolean scrolled (int amount) {
		return false;
	}
}
