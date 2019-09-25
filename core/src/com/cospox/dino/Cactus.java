package com.cospox.dino;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Cactus extends MovableEntity {
	public Cactus(String type, SpriteBatch batch) {
		super(type, batch);
		this.isAffectedByGravity = false;
	}
	
	public void tick() {
		this.setAcceleration(new Vector());
		this.setVelocity(new Vector(-5, 0));
		super.tick();
	}
}
