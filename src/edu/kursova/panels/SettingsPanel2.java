package edu.kursova.panels;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel2 extends JPanel {
	private int panelWidth;
	private int panelHeight;

	private JRadioButton optionSizeFixed;
	private JTextField valueOfFixedSize;

	private JRadioButton optionSizeInterval;
	private JTextField valueSizeFrom;
	private JTextField valueSizeTo;

	public SettingsPanel2(int width, int height) {
		panelWidth = width;
		panelHeight = height;

		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));

		// adding line1 panel
		JPanel line1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		ButtonGroup rbG = new ButtonGroup();

		line1.add(new JLabel("Маштаб події    "));

		optionSizeFixed = new JRadioButton("фіксований", true);
		rbG.add(optionSizeFixed);
		line1.add(optionSizeFixed);

		valueOfFixedSize = new JTextField(5);
		line1.add(valueOfFixedSize);

		add(line1);

		// adding line2 panel
		JPanel line2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 3));

		optionSizeInterval = new JRadioButton("в межах    ");
		rbG.add(optionSizeInterval);
		line2.add(optionSizeInterval);

		line2.add(new JLabel("від "));

		valueSizeFrom = new JTextField(4);
		line2.add(valueSizeFrom);

		line2.add(new JLabel("до "));

		valueSizeTo = new JTextField(4);
		line2.add(valueSizeTo);

		add(line2);
	}

	public boolean isOptionSizeFixedSelected() {
		return optionSizeFixed.isSelected();
	}

	public String getValueOfFixedSize() {
		return valueOfFixedSize.getText();
	}

	public boolean isOptionSizeIntervalSelected() {
		return optionSizeInterval.isSelected();
	}

	public String getValueSizeFrom() {
		return valueSizeFrom.getText();
	}

	public String getValueSizeTo() {
		return valueSizeTo.getText();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(panelWidth, panelHeight);
	}
}
