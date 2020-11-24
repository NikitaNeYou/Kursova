package edu.kursova.panels;

import edu.kursova.figures.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FiguresPanel extends JPanel {
	static final int CIRCLE = 1;
	static final int QUAD = 2;
	static final int TRIANGLE = 3;

	private int panelWidth;
	private int panelHeight;
	private ArrayList<Figures> figures;

	public FiguresPanel() {
		this(100, 100);
	}

	public FiguresPanel(int width, int height) {
		panelWidth = width;
		panelHeight = height;
	}

	public void setFiguresArray(ArrayList<Figures> f) {
		figures = f;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw Image
		drawImage(g);

		// Draw Figures
		if (figures != null && figures.size() != 0)
			for (Figures f : figures) {
				if (f instanceof ClassA) {
					drawFigure(g, f);
				} else if (f instanceof ClassB) {
					drawFigure(g, f);
				} else if (f instanceof ClassC) {
					drawFigure(g, f);
				}
			}

		// Draw Grid
		setLayout(new FlowLayout());
		showGrid(g, 50, Color.LIGHT_GRAY, true, Color.WHITE);
	}

	public void drawImage(Graphics g) {
		ImageIcon imageIcon = new ImageIcon("image/Kyiv.png");
		Image image = imageIcon.getImage();
		if (image != null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		}
	}

	public void showGrid(Graphics g, int size, Color c, boolean showTextMarks, Color textMarkColor) {
		Color curC = g.getColor();

		g.setColor(c);
		int pWidth = getWidth();
		int pHeight = getHeight();

		int verLines = pWidth / size;
		int horLines = pHeight / size;

		for (int i = 1; i <= verLines; i++) {
			g.drawLine(i * size, 0, i * size, pHeight - 1);
		}

		for (int i = 1; i <= horLines; i++) {
			g.drawLine(0, i * size, pWidth - 1, i * size);
		}

		g.drawRect(0, 0, pWidth - 1, pHeight - 1);

		if (showTextMarks) {
			setFont(new Font("Arial", Font.PLAIN, 10));
			g.setColor(Color.DARK_GRAY);

			FontMetrics fm = g.getFontMetrics();

			// verLines
			for (int i = 1; i <= verLines; i++) {
				int xPosOfMark = i * size;
				int yPosOfMark = 10;

				String markText = (new Integer(xPosOfMark)).toString();
				int stringWidth = fm.stringWidth(markText);
				int stringAscent = fm.getAscent();

				int xBox = xPosOfMark - stringWidth / 2;
				int yBox = yPosOfMark + stringAscent / 2;

				// Set color
				if (textMarkColor != null) {
					Color currentC = g.getColor();
					g.setColor(textMarkColor);
					g.fillRect(xBox - 2, yBox - stringAscent, stringWidth + 2, stringAscent + 2);
					g.setColor(currentC);
				}
				g.drawString(markText, xBox, yBox);
			}

			// horLines
			for (int i = 1; i <= horLines; i++) {
				int xPosOfMark = 15;
				int yPosOfMark = i * size;

				String markText = (new Integer(yPosOfMark)).toString();
				int stringWidth = fm.stringWidth(markText);
				int stringAscent = fm.getAscent();

				int xBox = xPosOfMark - stringWidth / 2;
				int yBox = yPosOfMark + stringAscent / 2;

				if (textMarkColor != null) {
					Color currentC = g.getColor();
					g.setColor(textMarkColor);
					g.fillRect(xBox - 2, yBox - stringAscent, stringWidth + 2, stringAscent + 2);
					g.setColor(currentC);
				}
				g.drawString(markText, xBox, yBox);
			}
		}

		g.setColor(curC);
	}

	public void drawFigure(Graphics g, Figures figures) {
		int type = figures.getType();
		int x = figures.getX();
		int y = figures.getY();
		int r = figures.getR();
		boolean filled = figures.isFilled();

		int newX;
		int newY;
		int newWidth;
		int newHeight;

		switch (type) {
		case CIRCLE: // display circle
			newX = x - r;
			newY = y - r;
			newWidth = 2 * r;
			newHeight = 2 * r;

			g.setColor(Color.RED);
			if (filled)
				g.fillOval(newX, newY, newWidth, newHeight);
			else
				g.drawOval(newX, newY, newWidth, newHeight);
			break;
		case QUAD: // display quad
			newX = x - r;
			newY = y - r;
			newWidth = 2 * r;
			newHeight = 2 * r;

			g.setColor(Color.BLUE);
			if (filled)
				g.fillRect(newX, newY, newWidth, newHeight);
			else
				g.drawRect(newX, newY, newWidth, newHeight);
			break;
		case TRIANGLE: // display triangle
			int a = (int) Math.round(r * Math.sqrt(3));
			int v1 = (int) Math.round(Math.sqrt(r * r - a * a / 4));

			int x1 = x;
			int y1 = y - r;
			int x2 = x - a / 2;
			int y2 = y + v1;
			int x3 = x + a / 2;
			int y3 = y + v1;

			int[] X = { x1, x2, x3 };
			int[] Y = { y1, y2, y3 };

			g.setColor(Color.ORANGE);
			if (filled)
				g.fillPolygon(X, Y, X.length);
			else
				g.drawPolygon(X, Y, X.length);
			break;
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(panelWidth, panelHeight);
	}
}
