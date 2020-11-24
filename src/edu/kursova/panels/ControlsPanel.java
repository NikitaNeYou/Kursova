package edu.kursova.panels;

import edu.kursova.general.ReferencesBroker;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ControlsPanel extends JPanel {
	private int panelWidth;
	private int panelHeight;

	public ControlsPanel() {
		this(100, 100);
	}

	public ControlsPanel(int width, int height) {
		panelWidth = width;
		panelHeight = height;

		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));

		// setting panel #1 (selection of figures)
		SettingsPanel1 sp1 = new SettingsPanel1(290, 100);
		ReferencesBroker.setSettingsPanel1Ref(sp1);
		sp1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		add(sp1);

		// setting panel #2 (size customization)
		SettingsPanel2 sp2 = new SettingsPanel2(290, 60);
		ReferencesBroker.setSettingsPanel2Ref(sp2);
		sp2.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		add(sp2);

		// creating statistics panel1
		StatisticsPanel1 stp1 = new StatisticsPanel1(290, 143);
		ReferencesBroker.setStatisticsPanel1Ref(stp1);
		stp1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		
		// creating statistics panel2
		StatisticsPanel2 stp2 = new StatisticsPanel2(290, 143);
		ReferencesBroker.setStatisticsPanel2Ref(stp2);
		stp2.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		
		// buttons panel
		ButtonsPanel bp = new ButtonsPanel(290, 80);
		ReferencesBroker.setButtonsPanelRef(bp);
		bp.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		add(bp);

		// add label
		add(new JLabel("Статистика: по кількості подій різного типу"));

		// add statistics panel1
		add(stp1);

		// add label
		add(new JLabel("Статистика: по маштабу подій"));

		// add statistics panel2
		add(stp2);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(panelWidth, panelHeight);
	}
}
