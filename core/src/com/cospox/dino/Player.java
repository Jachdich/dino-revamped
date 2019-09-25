package com.cospox.dino;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends MovableEntity implements Events {
	private EventHandler e = new EventHandler(this);
	
	public Player(String texture, SpriteBatch batch) {
		super(texture, batch);
		Gdx.input.setInputProcessor(this.e);
	}
	
	@Override
	public void keyPressed(int keyCode) {
		if (keyCode == Keys.UP && this.getPos().getY() == MovableEntity.FLOOR_HEIGHT) {
			this.getVelocity().add(new Vector(0, 20));
		}
	}
	
	@Override
	public void keyReleased(int keyCode) {
	}
}
