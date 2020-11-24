package edu.kursova.general;

import edu.kursova.panels.ControlsPanel;
import edu.kursova.panels.FiguresPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GeneralFrame extends JFrame {

	public GeneralFrame() {
		setSize(1150, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Kursova, ver 0.1, (c) By Kravchuk Nikita, 2020");
		setLayout(new FlowLayout());

		// FiguresPanel
		FiguresPanel figuresPanel = new FiguresPanel(800, 600);
		ReferencesBroker.setFifugresPanelRef(figuresPanel);
		add(figuresPanel);

		// Settings and Controls panel
		ControlsPanel controsPanel = new ControlsPanel(300, 600);
		controsPanel.setBorder(new LineBorder(new Color(56, 93, 138), 1));
		add(controsPanel);

	}

	public static void main(String[] args) {
		GeneralFrame window = new GeneralFrame();
		window.setResizable(false);
		window.setVisible(true);
	}
}