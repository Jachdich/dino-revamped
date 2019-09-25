package com.cospox.dino;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Dino dino;
	TextureAtlas textures;
	
	@Override
	public void create() {
		this.textures = new TextureAtlas("")
		this.batch = new SpriteBatch();
		this.dino = new Dino(this.batch);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.dino.tick();
		this.batch.begin();
		this.dino.render();
		this.batch.end();
	}
	
	@Override
	public void dispose() {
		this.batch.dispose();
		this.dino.dispose();
	}
}
