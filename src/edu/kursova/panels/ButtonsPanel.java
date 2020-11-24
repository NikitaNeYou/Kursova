package edu.kursova.panels;

import edu.kursova.figures.ClassA;
import edu.kursova.figures.ClassB;
import edu.kursova.figures.ClassC;
import edu.kursova.figures.Figures;
import edu.kursova.general.ReferencesBroker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonsPanel extends JPanel {
	private int panelWidth;
	private int panelHeight;

	private SettingsPanel1 sp1;
	private SettingsPanel2 sp2;
	private FiguresPanel fp;
	private StatisticsPanel1 stp1;
	private StatisticsPanel2 stp2;
	private JLabel statusInformationLabel;
	private String statusMessage;

	private ArrayList<Figures> figures;

	public ButtonsPanel(int width, int height) {
		// creation of empty arraylist
		figures = new ArrayList<Figures>();

		panelWidth = width;
		panelHeight = height;

		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		// adding line1 panel
		JPanel line1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 3));
		line1.setPreferredSize(new Dimension(280, 30));

		JButton btnDraw = new JButton("Зобразити");
		line1.add(btnDraw);

		JButton btnClear = new JButton("Очистити");
		line1.add(btnClear);

		add(line1);

		// adding listeners for buttons
		btnDraw.addActionListener(new BtnDrawListener());
		btnClear.addActionListener(new BtnClearListener());

		// getting information about settings panels references
		this.sp1 = ReferencesBroker.getSettingPanel1Ref();
		this.sp2 = ReferencesBroker.getSettingPanel2Ref();
		this.fp = ReferencesBroker.getFifugresPanelRef();
		this.stp1 = ReferencesBroker.getStatisticsPanel1Ref();
		this.stp2 = ReferencesBroker.getStatisticsPanel2Ref();

		// adding line2 panel
		JPanel line2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));

		line2.add(new JLabel("Статус останньої операції:"));

		add(line2);

		// adding line3 panel
		JPanel line3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));

		statusInformationLabel = new JLabel();
		line3.add(statusInformationLabel);

		add(line3);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(panelWidth, panelHeight);
	}

	public ArrayList<Figures> getFigures() {
		return figures;
	}

	class BtnDrawListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// reaction, when pressed
			boolean errorInAmountA = false;
			boolean errorInAmountB = false;
			boolean errorInAmountC = false;
			int fromA = 0, toA = 0;
			int fromB = 0, toB = 0;
			int fromC = 0, toC = 0;

			boolean errorInFixedSize = false;
			boolean errorInIntervalSize = false;
			int figuresSizeFixed = 0;
			int figuresSizeFrom = 0;
			int figuresSizeTo = 0;
			statusMessage = "ok";

			// getting number of A
			if (sp1.isOptionASelected()) {
				try {
					fromA = Integer.parseInt(sp1.getFromAmountA());
					if (fromA < 0)
						fromA = Integer.parseInt("s");

					toA = Integer.parseInt(sp1.getToAmountA());
					if (toA < 0)
						toA = Integer.parseInt("s");

					if (toA < fromA)
						toA = Integer.parseInt("s");
				} catch (Exception e) {
					errorInAmountA = true;
					statusMessage = "Event \"A\" number problem";
				}
			}

			// getting number of B
			if (sp1.isOptionBSelected()) {
				try {
					fromB = Integer.parseInt(sp1.getFromAmountB());
					if (fromB < 0)
						fromB = Integer.parseInt("s");

					toB = Integer.parseInt(sp1.getToAmountB());
					if (toB < 0)
						toB = Integer.parseInt("s");

					if (toB < fromB)
						toB = Integer.parseInt("s");
				} catch (Exception e) {
					errorInAmountB = true;
					statusMessage = "Event \"B\" number problem";
				}
			}

			// getting number of C
			if (sp1.isOptionCSelected()) {
				try {
					fromC = Integer.parseInt(sp1.getFromAmountC());
					if (fromC < 0)
						fromC = Integer.parseInt("s");

					toC = Integer.parseInt(sp1.getToAmountC());
					if (toC < 0)
						toC = Integer.parseInt("s");

					if (toC < fromC)
						toC = Integer.parseInt("s");
				} catch (Exception e) {
					errorInAmountC = true;
					statusMessage = "Event \"C\" number problem";
				}
			}

			// analyzing
			if (sp2.isOptionSizeFixedSelected()) {
				// fixed size selected
				try {
					figuresSizeFixed = Integer.parseInt(sp2.getValueOfFixedSize());
					if (figuresSizeFixed < 0)
						figuresSizeFixed = Integer.parseInt("s");
				} catch (Exception e) {
					errorInFixedSize = true;
					statusMessage = "Number problem in fixed size";
				}
			} else {
				// interval size selected
				try {
					figuresSizeFrom = Integer.parseInt(sp2.getValueSizeFrom());
					if (figuresSizeFrom < 0)
						figuresSizeFrom = Integer.parseInt("s");

					figuresSizeTo = Integer.parseInt(sp2.getValueSizeTo());
					if (figuresSizeTo < 0)
						figuresSizeTo = Integer.parseInt("s");

					if (figuresSizeTo < figuresSizeFrom)
						figuresSizeTo = Integer.parseInt("s");
				} catch (Exception e) {
					errorInIntervalSize = true;
					statusMessage = "Number problem in interval size";
				}
			}

			int figuresPanelWidth = fp.getPreferredSize().width;
			int figuresPanelHeight = fp.getPreferredSize().height;

			// fill array of figures
			if (!errorInAmountA && !errorInAmountB && !errorInAmountC && !errorInFixedSize && !errorInIntervalSize)
				if (sp1.isOptionASelected() || sp1.isOptionBSelected() || sp1.isOptionCSelected()) {
					for (int i = 0; i < (int) (Math.random() * (toA - fromA) + fromA); i++)
						// creation of A
						if (sp1.isOptionASelected()) {
							int x = (int) (Math.random() * figuresPanelWidth);
							int y = (int) (Math.random() * figuresPanelHeight);
							int r = 0;
							if (sp2.isOptionSizeFixedSelected()) {
								r = figuresSizeFixed;
							} else {
								r = (int) (Math.random() * (figuresSizeTo - figuresSizeFrom) + figuresSizeFrom);
							}

							ClassA a = new ClassA(x, y, r);
							figures.add(a);
						}
					for (int i = 0; i < (int) (Math.random() * (toB - fromB) + fromB); i++)
						// creation of B
						if (sp1.isOptionBSelected()) {
							int x = (int) (Math.random() * figuresPanelWidth);
							int y = (int) (Math.random() * figuresPanelHeight);
							int r = 0;
							if (sp2.isOptionSizeFixedSelected()) {
								r = figuresSizeFixed;
							} else {
								r = (int) (Math.random() * (figuresSizeTo - figuresSizeFrom) + figuresSizeFrom);
							}

							ClassB b = new ClassB(x, y, r);
							figures.add(b);
						}
					for (int i = 0; i < (int) (Math.random() * (toC - fromC) + fromC); i++)
						// creation of C
						if (sp1.isOptionCSelected()) {
							int x = (int) (Math.random() * figuresPanelWidth);
							int y = (int) (Math.random() * figuresPanelHeight);
							int r = 0;
							if (sp2.isOptionSizeFixedSelected()) {
								r = figuresSizeFixed;
							} else {
								r = (int) (Math.random() * (figuresSizeTo - figuresSizeFrom) + figuresSizeFrom);
							}

							ClassC c = new ClassC(x, y, r);
							figures.add(c);
						}
					fp.setFiguresArray(figures);

					// StatisticsPanel1
					int numOfA = 0;
					int numOfB = 0;
					int numOfC = 0;

					for (Figures f : figures) {
						if (f instanceof ClassA)
							numOfA++;
						else if (f instanceof ClassB)
							numOfB++;
						else if (f instanceof ClassC)
							numOfC++;
					}

					int[] inData = { numOfA, numOfB, numOfC };
					stp1.setData(inData, Color.RED);

					// StatisticsPanel2
					int areaMin = 0;
					int areaAvg = 0;
					int areaMax = 0;

					int max = figures.get(0).getR();
					for (int i = 0; i < figures.size(); i++)
						if (figures.get(i).getR() > max)
							max = figures.get(i).getR();

					for (Figures f : figures) {
						if (f.getR() < max * 0.3)
							areaMin++;
						else if (f.getR() < max * 0.6)
							areaAvg++;
						else
							areaMax++;

					}

					int[] areaData = { areaMin, areaAvg, areaMax };
					stp2.setData(areaData, Color.BLUE);
				}

			statusInformationLabel.setText(statusMessage);
		}
	}

	class BtnClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// reaction, when pressed
			figures.clear();
			fp.setFiguresArray(figures);

			int[] inData = null;
			stp1.setData(inData, Color.RED);

			int[] radiusData = null;
			stp2.setData(radiusData, Color.BLUE);
		}
	}
}
