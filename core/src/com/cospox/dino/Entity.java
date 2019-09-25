package com.cospox.dino;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity {
	private SpriteBatch batch;
	private Texture img;
	private Vector pos;
	
	public Entity(Texture img, SpriteBatch batch) {
		this.img = img;
		this.batch = batch;
		this.pos = new Vector();
	}
	
	public Entity(String img, SpriteBatch batch) {
		this.img = new Texture(img);
		this.batch = batch;
		this.pos = new Vector();
	}
	
	public void render() {
		this.batch.draw(this.img, (float)this.pos.getX(), (float)this.pos.getY());
	}
	
	public Vector getPos() {
		return this.pos;
	}
	
	public void setPos(int x, int y) {
		this.pos = new Vector(x, y);
	}
	
	public void setPos(Vector pos) {
		this.pos = pos;
	}
	
	public void dispose() {
		this.img.dispose();
	}
}
