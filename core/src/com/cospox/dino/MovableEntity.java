package com.cospox.dino;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MovableEntity extends Entity {
	private Vector velocity;
	private Vector acceleration;
	protected boolean isAffectedByGravity = true;
	
	public static final Vector GRAVITY = new Vector(0, -1);
	public static final int FLOOR_HEIGHT = 5;
	
	public MovableEntity(String texture, SpriteBatch batch) {
		super(texture, batch);
		this.velocity = new Vector();
		this.acceleration = new Vector();
	}
	
	
	public MovableEntity(Texture texture, SpriteBatch batch) {
		super(texture, batch);
		this.velocity = new Vector();
		this.acceleration = new Vector();
	}
	
	public void tick() {
		Vector accel_copy = this.getAcceleration().copy();
		if (this.isAffectedByGravity) {
			this.acceleration.add(GRAVITY);
		}
		
		if (this.getPos().getY() <= FLOOR_HEIGHT && this.velocity.getY() <= 0) {
			this.getPos().setY(FLOOR_HEIGHT);
			this.getVelocity().setY(0);
			this.getAcceleration().setY(0);
		}
		
		this.velocity.add(this.acceleration);
		this.getPos().add(this.velocity);
		this.setAcceleration(accel_copy);
	}
	
	public Vector getVelocity() {
		return this.velocity;
	}
	
	public void setVelocity(Vector v) {
		this.velocity = v;
	}
	
	public Vector getAcceleration() {
		return this.acceleration;
	}
	
	public void setAcceleration(Vector v) {
		this.acceleration = v;
	}
}
