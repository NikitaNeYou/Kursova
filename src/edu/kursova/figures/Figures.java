package edu.kursova.figures;

public class Figures {
	public static final int CIRCLE = 1;
	public static final int QUAD = 2;
	public static final int TRIANGLE = 3;

	private int x;
	private int y;
	private int r;
	private int type;
	private boolean filled;

	public Figures(int x, int y, int r, int type, boolean filled) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.type = type;
		this.filled = filled;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
}
