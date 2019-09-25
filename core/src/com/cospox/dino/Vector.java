package com.cospox.dino;

public class Vector {
	double x, y;
	public Vector() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector(float x, float y) {
		this.x = (double)x;
		this.y = (double)y;
	}
	
	public Vector(int x, int y) {
		this.x = (double)x;
		this.y = (double)y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setX(float x) {
		this.x = (double)x;
	}
	
	public void setY(float y) {
		this.y = (double)y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = (double)x;
	}
	
	public void setY(int y) {
		this.y = (double)y;
	}
	
	public Vector add(Vector other) {
		this.x += other.x;
		this.y += other.y;
		return this;
	}
	
	public Vector sub(Vector other) {
		this.x -= other.x;
		this.y -= other.y;
		return this;
	}
	
	public Vector mul(Vector other) {
		this.x *= other.x;
		this.y *= other.y;
		return this;
	}
	
	public Vector div(Vector other) {
		this.x /= other.x;
		this.y /= other.y;
		return this;
	}
	
	public Vector copy() {
		return new Vector(this.x, this.y);
	}
}
