package com.cospox.dino;

import java.util.concurrent.TimeUnit;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Main {
	public Window w;
	
	public Main() {
		this.w = new Window();
		GL.createCapabilities();
		this.mainLoop();
		GLFW.glfwTerminate();
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public void mainLoop() {
		while (!w.shouldClose()) {
			double time = Timer.getTime();
			GLFW.glfwPollEvents();
				
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
				
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glColor4f(1, 0, 0, 0);
			GL11.glVertex2f(-0.5f, 0.5f);
			GL11.glColor4f(0, 1, 0, 0);
			GL11.glVertex2f(0.5f, 0.5f);
			GL11.glColor4f(0, 0, 1, 0);
			GL11.glVertex2f(0.5f, -0.5f);
			GL11.glColor4f(1, 1, 0, 0);
			GL11.glVertex2f(-0.5f, -0.5f);
			GL11.glEnd();
				
			GLFW.glfwSwapBuffers(w.getWindowReferance());
				
			double time2 = Timer.getTime();
			double passed = time2 - time;
			double waitTime = w.getFrameTime() - passed;
			try {
				TimeUnit.MILLISECONDS.sleep((long) ((waitTime > 0 ? waitTime : 0) * 1000));
			} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
			w.displayFrameRate(1.0 / (Timer.getTime() - time));
		}
	}
}