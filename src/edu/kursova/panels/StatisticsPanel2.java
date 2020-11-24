package edu.kursova.panels;

import javax.swing.*;
import java.awt.*;

public class StatisticsPanel2 extends JPanel {
	private int panelWidth;
	private int panelHeight;
	private int[] areaData;
	private Color barColor;

	public final static int RADIUSMIN = 0;
	public final static int RADIUSAVG = 1;
	public final static int RADIUSMAX = 2;

	public StatisticsPanel2(int width, int height) {
		panelHeight = height;
		panelWidth = width;
		this.areaData = null;
		this.barColor = Color.RED;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (areaData != null) { // We can draw bar chart
			showChart(g);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(panelWidth, panelHeight);
	}

	public void setData(int[] inData, Color barColor) {
		this.areaData = inData;
		this.barColor = barColor;
		repaint();
	}

	private void showChart(Graphics g) {
		Color curC = g.getColor();
		int p = 10; // 10%
		int h = 10; // px
		int N = areaData.length;
		int b = (int) Math.round(getWidth() / ((1 + 1.0 / p) * N + 1.0 / p));
		int d = (int) ((double) b / p);

		// find max bar
		int max = areaData[0];
		for (int i = 0; i < N; i++)
			if (areaData[i] > max)
				max = areaData[i];

		int maxBarPixels = getHeight() - h;
		double hy = (double) maxBarPixels / max;

		for (int i = 0; i < N; i++) {
			int barHeight = (int) (areaData[i] * hy);
			int barWidth = b;

			int x = d + i * (b + d);
			int y = getHeight() - barHeight;

			g.setColor(barColor);
			g.fillRect(x, y, barWidth, barHeight);
		}

		setFont(new Font("Arial", Font.PLAIN, 10));
		g.setColor(Color.WHITE);

		FontMetrics fm = g.getFontMetrics();

		for (int i = 0; i < N; i++) {
			int barHeight = (int) (areaData[i] * hy);

			int xPosOfMark = d + i * (b + d);
			int yPosOfMark = getHeight() - barHeight;

			String markText = (new Integer(areaData[i])).toString();
			int stringWidth = fm.stringWidth(markText);
			int stringAscent = fm.getAscent();

			int xBox = xPosOfMark - stringWidth + 50;
			int yBox = yPosOfMark + stringAscent + 5;
			if (i == RADIUSMIN)
				g.drawString("< 30%", xBox - 8, yBox);
			else if (i == RADIUSAVG)
				g.drawString("30% - 60%", xBox - 20, yBox);
			else if (i == RADIUSMAX)
				g.drawString("> 60%", xBox - 8, yBox);
			g.drawString(markText, xBox, yBox + 15);
		}

		g.setColor(curC);
	}
}
