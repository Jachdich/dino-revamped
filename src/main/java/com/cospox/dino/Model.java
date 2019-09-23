package com.cospox.dino;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

public class Model {
	private int drawCount;
	private int vId;
	public Model(float[] vertices) {
		this.drawCount = vertices.length / 2;
		this.vId = GL15.glGenBuffers();
		
		FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length);
		buffer.put(vertices);
		buffer.flip();
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vId);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
	}
	
	public void render() {
		GL15.glEnableClientState(GL15.GL_VERTEX_ARRAY);
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vId);
		GL15.glVertexPointer(2, GL15.GL_FLOAT, 0, 0);
		
		GL15.glDrawArrays(GL15.GL_TRIANGLES, 0, drawCount);
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL15.glDisableClientState(GL15.GL_VERTEX_ARRAY);
	}
}
