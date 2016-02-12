
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Component;

class SettingsPanel extends JPanel {
	final static long serialVersionUID = 1;
	
	JComboBox<String> instrumentCombo;
	JComboBox<String> countKeyCombo;
	
	JCheckBox whiteC1_C2_checkBox;
	JCheckBox blackC1_C2_checkBox;
	JCheckBox whiteC2_C3_checkBox;
	JCheckBox blackC2_C3_checkBox;
	JCheckBox whiteC3_C4_checkBox;
	JCheckBox blackC3_C4_checkBox;
	JCheckBox whiteC4_C5_checkBox;
	JCheckBox blackC4_C5_checkBox;
	JCheckBox whiteC5_C6_checkBox;
	JCheckBox blackC5_C6_checkBox;
	JCheckBox whiteC6_C7_checkBox;
	JCheckBox blackC6_C7_checkBox;
	JCheckBox whiteC7_C8_checkBox;
	JCheckBox blackC7_C8_checkBox;


	JCheckBox mixedWhiteC3_C4_checkBox;
	JCheckBox mixedBlackC3_C4_checkBox;


	
	JCheckBox keyLabelcheckBox;
	JCheckBox showHitKeycheckBox;
	JCheckBox showResultcheckBox;
	JCheckBox soundOnlyGoodHitcheckBox;
	
	JCheckBox keyLabelEnabledCheckBox;
	
	JPanel firstPanel;
	JPanel secondPanel;
	JPanel thirdPanel;
	
	
	JLabel whiteLabel;
	JLabel blackLabel;
	JLabel emptyLabel;
	
	JLabel octave1;
	JLabel octave2;
	JLabel octave3;
	JLabel octave4;
	JLabel octave5;
	JLabel octave6;
	JLabel octave7;
	JLabel mixedOctave3;
	
	JPanel[] enabledOctaveListPanel;
	
	
	public SettingsPanel() {
		initSettings();
		
		initFirstPanel();
		initSecondPanel();
		initThirdPanel();
	
		add(firstPanel);
		add(secondPanel);
		add(thirdPanel);
	}
	private void initSettings() {
		String[] instruments = {
			"0",
			"1", "2", "3", "4", "5",
			"6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25",
			"26", "27", "28", "29", "30",
			"31", "32", "33", "34", "35",
			"36", "37", "38", "39", "40",
			"41", "42", "43", "44", "45",
			"46", "47", "48", "49", "50",
			"51", "52", "53", "54", "55",
			"56", "57", "58", "59", "60",
			"61", "62", "63", "64", "65",
			"66", "67", "68", "69", "70",
			"71", "72", "73", "74", "75",
			"76", "77", "78", "79", "80",
			"81", "82", "83", "84", "85",
			"86", "87", "88", "89", "90",
			"91", "92", "93", "94", "95",
			"96", "97", "98", "99", "100",
			"101", "102", "103", "104", "105",
			"106", "107", "108", "109", "110",
			"111", "112", "113", "114", "115",
			"116", "117", "118", "119", "120",
			"121", "122", "123", "124", "125",
			"126", "127"
			};

		String[] countKeys = {
			"61 szintetizátor", "75 zongora"
		};
		
		
		
		
		instrumentCombo = new JComboBox<String>(instruments);
		countKeyCombo = new JComboBox<String>(countKeys);
		
		
		
			
		whiteC1_C2_checkBox = new JCheckBox();
		blackC1_C2_checkBox = new JCheckBox();
		whiteC2_C3_checkBox = new JCheckBox();
		blackC2_C3_checkBox = new JCheckBox();
		whiteC3_C4_checkBox = new JCheckBox();
		blackC3_C4_checkBox = new JCheckBox();
		whiteC4_C5_checkBox = new JCheckBox();
		blackC4_C5_checkBox = new JCheckBox();
		whiteC5_C6_checkBox = new JCheckBox();
		blackC5_C6_checkBox = new JCheckBox();
		whiteC6_C7_checkBox = new JCheckBox();
		blackC6_C7_checkBox = new JCheckBox();
		whiteC7_C8_checkBox = new JCheckBox();
		blackC7_C8_checkBox = new JCheckBox();
	
		mixedWhiteC3_C4_checkBox = new JCheckBox();
		mixedBlackC3_C4_checkBox = new JCheckBox();
	
		keyLabelcheckBox = new JCheckBox();
		showHitKeycheckBox = new JCheckBox();
		showResultcheckBox = new JCheckBox();
		soundOnlyGoodHitcheckBox = new JCheckBox();
		
		
		whiteLabel = new JLabel();
		blackLabel = new JLabel();
		emptyLabel = new JLabel();
		whiteLabel.setText("fehér");
		blackLabel.setText("fekete");
		emptyLabel.setText("");
		
		octave1 = new JLabel();
		octave2 = new JLabel();
		octave3 = new JLabel();
		octave4 = new JLabel();
		octave5 = new JLabel();
		octave6 = new JLabel();
		octave7 = new JLabel();
		mixedOctave3 = new JLabel();
		

		GridLayout gridLayout = new GridLayout(0, 3);
		
		
		//~ setLayout(new FlowLayout());
		
		setLayout(gridLayout);
			
	}
	private void initFirstPanel() {
		firstPanel = new JPanel();
		firstPanel.setLayout(new FlowLayout());
		
		TitledBorder title = BorderFactory.createTitledBorder("Hangszer és billentyűk");
		firstPanel.setBorder(title);
				
		firstPanel.add(instrumentCombo);
		firstPanel.add(countKeyCombo);
		

		add(firstPanel);
		
		
	}

	private void initSecondPanel() {
		secondPanel = new JPanel();
		
		TitledBorder title = BorderFactory.createTitledBorder("Választható oktávok");
		secondPanel.setBorder(title);
		
		//~ GridLayout gridLayout = new GridLayout(8,4);
		
		secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.PAGE_AXIS));

		

		int octavePanelCount = 10;
		enabledOctaveListPanel = new JPanel[octavePanelCount];
		for (int i = 0; i < octavePanelCount; i++) {
			enabledOctaveListPanel[i] = new JPanel();
			secondPanel.add(enabledOctaveListPanel[i]);
		}


		enabledOctaveListPanel[0].add(whiteLabel);
		enabledOctaveListPanel[0].add(blackLabel);
		enabledOctaveListPanel[0].add(emptyLabel);
			

		
		enabledOctaveListPanel[1].add(whiteC1_C2_checkBox);
		enabledOctaveListPanel[1].add(blackC1_C2_checkBox);
		enabledOctaveListPanel[1].add(octave1);
		
		enabledOctaveListPanel[2].add(whiteC2_C3_checkBox);
		enabledOctaveListPanel[2].add(blackC2_C3_checkBox);
		enabledOctaveListPanel[2].add(octave2);
		
		enabledOctaveListPanel[3].add(whiteC3_C4_checkBox);
		enabledOctaveListPanel[3].add(blackC3_C4_checkBox);
		enabledOctaveListPanel[3].add(octave3);

		whiteC4_C5_checkBox.setSelected(true);
		enabledOctaveListPanel[4].add(whiteC4_C5_checkBox);
		enabledOctaveListPanel[4].add(blackC4_C5_checkBox);
		enabledOctaveListPanel[4].add(octave4);
		
		enabledOctaveListPanel[5].add(whiteC5_C6_checkBox);
		enabledOctaveListPanel[5].add(blackC5_C6_checkBox);
		enabledOctaveListPanel[5].add(octave5);
		
		enabledOctaveListPanel[6].add(whiteC6_C7_checkBox);
		enabledOctaveListPanel[6].add(blackC6_C7_checkBox);
		enabledOctaveListPanel[6].add(octave6);
		
		enabledOctaveListPanel[7].add(whiteC7_C8_checkBox);
		enabledOctaveListPanel[7].add(blackC7_C8_checkBox);
		enabledOctaveListPanel[7].add(octave7);
		

		enabledOctaveListPanel[8].add(mixedWhiteC3_C4_checkBox);
		enabledOctaveListPanel[8].add(mixedBlackC3_C4_checkBox);
		enabledOctaveListPanel[8].add(mixedOctave3);

		whiteC1_C2_checkBox.setText("");
		blackC1_C2_checkBox.setText("");
		whiteC2_C3_checkBox.setText("");
		blackC2_C3_checkBox.setText("");
		whiteC3_C4_checkBox.setText("");
		blackC3_C4_checkBox.setText("");
		whiteC4_C5_checkBox.setText("");
		blackC4_C5_checkBox.setText("");
		whiteC5_C6_checkBox.setText("");
		blackC5_C6_checkBox.setText("");
		whiteC6_C7_checkBox.setText("");
		blackC6_C7_checkBox.setText("");
		whiteC7_C8_checkBox.setText("");
		blackC7_C8_checkBox.setText("");
		
		mixedWhiteC3_C4_checkBox.setText("");
		mixedBlackC3_C4_checkBox.setText("");

		octave1.setText("C1 - C2");
		octave2.setText("C2 - C3");
		octave3.setText("C3 - C4");
		octave4.setText("C4 - C5");
		octave5.setText("C5 - C6");
		octave6.setText("C6 - C7");
		octave7.setText("C7 - C8");
		mixedOctave3.setText("3 oktáv, 4 oktáv eleje violin és basszuskulcson");
		
		add(secondPanel);

	}
	private void initThirdPanel() {
		thirdPanel = new JPanel();
		thirdPanel.setLayout(new FlowLayout());
		
		TitledBorder title = BorderFactory.createTitledBorder("Egyéb");
		thirdPanel.setBorder(title);		
		
		keyLabelEnabledCheckBox = new JCheckBox();
		keyLabelEnabledCheckBox.setText("Billentyűzet feliratok engedélyezése");
		
		thirdPanel.add(keyLabelEnabledCheckBox);
		
		add(thirdPanel);
		
	}
}
