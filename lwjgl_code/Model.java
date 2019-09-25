package com.cospox.dino;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

public class Model {
	private int drawCount;
	private int vId;
	private Texture a;
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
		// We'll define our quad using 4 vertices of the custom 'TexturedVertex' class
		TexturedVertex v0 = new TexturedVertex(); 
		v0.setXYZ(-0.5f, 0.5f, 0); v0.setRGB(1, 0, 0); v0.setST(0, 0);
		TexturedVertex v1 = new TexturedVertex(); 
		v1.setXYZ(-0.5f, -0.5f, 0); v1.setRGB(0, 1, 0); v1.setST(0, 1);
		TexturedVertex v2 = new TexturedVertex(); 
		v2.setXYZ(0.5f, -0.5f, 0); v2.setRGB(0, 0, 1); v2.setST(1, 1);
		TexturedVertex v3 = new TexturedVertex(); 
		v3.setXYZ(0.5f, 0.5f, 0); v3.setRGB(1, 1, 1); v3.setST(1, 0);
//		GL15.glEnableClientState(GL15.GL_VERTEX_ARRAY);
//		
//		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vId);
//		GL15.glVertexPointer(2, GL15.GL_FLOAT, 0, 0);
//		
//		GL15.glDrawArrays(GL15.GL_TRIANGLES, 0, drawCount);
//		
//		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
//		GL15.glDisableClientState(GL15.GL_VERTEX_ARRAY);
	}
}
