package edu.kursova.panels;

import javax.swing.*;
import java.awt.*;

public class StatisticsPanel1 extends JPanel {
	private int panelWidth;
	private int panelHeight;
	private int[] inData;
	private Color barColor;

	public final static int typeA = 0;
	public final static int typeB = 1;
	public final static int typeC = 2;

	public StatisticsPanel1(int width, int height) {
		panelHeight = height;
		panelWidth = width;
		this.inData = null;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (inData != null) { // We can draw bar chart
			showChart(g);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(panelWidth, panelHeight);
	}

	public void setData(int[] inData, Color barColor) {
		this.inData = inData;
		this.barColor = barColor;
		repaint();
	}

	private void showChart(Graphics g) {
		Color curC = g.getColor();
		int p = 10; // 10%
		int h = 10; // px
		int N = inData.length;
		int b = (int) Math.round(getWidth() / ((1 + 1.0 / p) * N + 1.0 / p));
		int d = (int) ((double) b / p);

		// find max bar
		int max = inData[0];
		for (int i = 0; i < N; i++)
			if (inData[i] > max)
				max = inData[i];

		int maxBarPixels = getHeight() - h;
		double hy = (double) maxBarPixels / max;

		for (int i = 0; i < N; i++) {
			int barHeight = (int) (inData[i] * hy);

			int x = d + i * (b + d);
			int y = getHeight() - barHeight;

			g.setColor(barColor);
			g.fillRect(x, y, b, barHeight);
		}

		setFont(new Font("Arial", Font.PLAIN, 10));
		g.setColor(Color.WHITE);

		FontMetrics fm = g.getFontMetrics();

		for (int i = 0; i < N; i++) {
			int barHeight = (int) (inData[i] * hy);

			int xPosOfMark = d + i * (b + d);
			int yPosOfMark = getHeight() - barHeight;

			String markText = (new Integer(inData[i])).toString();
			int stringWidth = fm.stringWidth(markText);
			int stringAscent = fm.getAscent();

			int xBox = xPosOfMark - stringWidth + 50;
			int yBox = yPosOfMark + stringAscent + 5;

			if (i == typeA)
				g.drawString("Подія \"A\"", xBox - 15, yBox);
			else if (i == typeB)
				g.drawString("Подія \"B\"", xBox - 15, yBox);
			else if (i == typeC)
				g.drawString("Подія \"C\"", xBox - 15, yBox);
			g.drawString(markText, xBox, yBox + 15);
		}

		g.setColor(curC);
	}
}
