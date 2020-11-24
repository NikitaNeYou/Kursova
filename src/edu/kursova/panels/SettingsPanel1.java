package edu.kursova.panels;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel1 extends JPanel {
	private int panelWidth;
	private int panelHeight;

	private JCheckBox optionA;
	private JTextField fromAmountA;
	private JTextField toAmountA;

	private JCheckBox optionB;
	private JTextField fromAmountB;
	private JTextField toAmountB;

	private JCheckBox optionC;
	private JTextField fromAmountC;
	private JTextField toAmountC;

	public SettingsPanel1(int width, int height) {
		panelWidth = width;
		panelHeight = height;

		setLayout(new FlowLayout(FlowLayout.CENTER));

		// adding line1 panel
		JPanel line1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 3));

		line1.add(new JLabel("Події класу \"A\""));

		optionA = new JCheckBox();
		line1.add(optionA);

		line1.add(new JLabel("Від"));

		fromAmountA = new JTextField(3);
		line1.add(fromAmountA);

		line1.add(new JLabel("До"));

		toAmountA = new JTextField(3);
		line1.add(toAmountA);

		add(line1);

		// adding line1 panel
		JPanel line2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 3));

		line2.add(new JLabel("Події класу \"B\""));

		optionB = new JCheckBox();
		line2.add(optionB);

		line2.add(new JLabel("Від"));

		fromAmountB = new JTextField(3);
		line2.add(fromAmountB);

		line2.add(new JLabel("До"));

		toAmountB = new JTextField(3);
		line2.add(toAmountB);

		add(line2);

		// adding line3 panel
		JPanel line3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 3));

		line3.add(new JLabel("Події класу \"C\""));

		optionC = new JCheckBox();
		line3.add(optionC);

		line3.add(new JLabel("Від"));

		fromAmountC = new JTextField(3);
		line3.add(fromAmountC);

		line3.add(new JLabel("До"));

		toAmountC = new JTextField(3);
		line3.add(toAmountC);

		add(line3);
	}

	public boolean isOptionASelected() {
		return optionA.isSelected();
	}

	public String getFromAmountA() {
		return fromAmountA.getText();
	}

	public String getToAmountA() {
		return toAmountA.getText();
	}

	public boolean isOptionBSelected() {
		return optionB.isSelected();
	}

	public String getFromAmountB() {
		return fromAmountB.getText();
	}

	public String getToAmountB() {
		return toAmountB.getText();
	}

	public boolean isOptionCSelected() {
		return optionC.isSelected();
	}

	public String getFromAmountC() {
		return fromAmountC.getText();
	}

	public String getToAmountC() {
		return toAmountC.getText();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(panelWidth, panelHeight);
	}
}
