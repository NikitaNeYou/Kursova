package edu.kursova.general;

import edu.kursova.panels.*;

public class ReferencesBroker {
	private static SettingsPanel1 sp1;
	private static SettingsPanel2 sp2;
	private static ButtonsPanel bp1;
	private static FiguresPanel fp1;
	private static StatisticsPanel1 stp1;
	private static StatisticsPanel2 stp2;

	public static void setSettingsPanel1Ref(SettingsPanel1 s1) {
		sp1 = s1;
	}

	public static SettingsPanel1 getSettingPanel1Ref() {
		return sp1;
	}

	public static void setSettingsPanel2Ref(SettingsPanel2 s2) {
		sp2 = s2;
	}

	public static SettingsPanel2 getSettingPanel2Ref() {
		return sp2;
	}

	public static void setButtonsPanelRef(ButtonsPanel bp) {
		bp1 = bp;
	}

	public static ButtonsPanel getButtonsPanelRef() {
		return bp1;
	}

	public static void setFifugresPanelRef(FiguresPanel fp) {
		fp1 = fp;
	}

	public static FiguresPanel getFifugresPanelRef() {
		return fp1;
	}
	
	public static void setStatisticsPanel1Ref(StatisticsPanel1 stp) {
		stp1 = stp;
	}

	public static StatisticsPanel1 getStatisticsPanel1Ref() {
		return stp1;
	}
	
	public static void setStatisticsPanel2Ref(StatisticsPanel2 stp) {
		stp2 = stp;
	}

	public static StatisticsPanel2 getStatisticsPanel2Ref() {
		return stp2;
	}
}
