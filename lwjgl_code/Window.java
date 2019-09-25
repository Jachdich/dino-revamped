package com.cospox.dino;

import java.util.concurrent.TimeUnit;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Window {
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final String TITLE = "Dino Revamped";
	
	private long window;
	
	private static final double FRAME_TIME = 1.0 / 60.0;
	
	public Window() {
		if (!GLFW.glfwInit()) {
			throw new IllegalStateException("Failed to initiate GLFW");
		}
		
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		this.window = GLFW.glfwCreateWindow(WIDTH, HEIGHT, TITLE, 0, 0);
		if (this.window == 0) {
			throw new IllegalStateException("Failed to create window");
		}
		
		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		GLFW.glfwSetWindowPos(this.window, (videoMode.width() - WIDTH) / 2, (videoMode.height() - HEIGHT) / 2);
		
		GLFW.glfwShowWindow(this.window);
		
		GLFW.glfwMakeContextCurrent(this.window);
	}
	
	public boolean shouldClose() {
		return GLFW.glfwWindowShouldClose(this.window);
	}
	
	public void displayFrameRate(double rate) {
		System.out.println(rate);
	}

	public double getFrameTime() {
		return FRAME_TIME;
	}

	public long getWindowReferance() {
		return this.window;
	}
}
