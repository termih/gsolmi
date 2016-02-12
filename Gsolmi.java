/*
* File: Gsolmi.java
* Author: Sallai András
* Copyright (c) Sallai András, 2015
* Date: 2015-10-27
* Web: http://szit.hu/gsolmi/
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details:
* http://www.gnu.org/licenses/gpl.html
*
*/

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.Color;

class Gsolmi extends JFrame {
	final static  long serialVersionUID = 1;
	String programVersion = "0.9.2";
	JTabbedPane tabbedPane;
	JPanel trainerPanel;
	JPanel controlPanel;
	JPanel modePanel;
	Docpanel docpanel;
	SettingsPanel settingPanel;	
	ScorePanel scorePanel;
	Keypanel keyPanel;
	
	JTextField goodHitTextField = new JTextField(3);
	JTextField badHitTextField = new JTextField(3);
	JLabel goodLabel = new JLabel("jó: ");
	JLabel badLabel = new JLabel("rossz: ");
	JPanel resultPanel = new JPanel();
	JButton resetButton = new JButton("Törlés");
	JButton aboutButton = new JButton("Névjegy");
	String aboutStr = "gSolmi verzió: " + programVersion +
	 "\n\nCopyright (c) Sallai András, 2015\n\nLicence: GNU GPL verziő: 3.";
	 
	ButtonGroup modeGroup;
	JRadioButton trainerRadio;
	JRadioButton playRadio;
	
	Gsolmi() {
		
		setTitle("Sallai András - gSolmi");

		modeGroup = new ButtonGroup();				
		trainerRadio = new JRadioButton();
		playRadio = new JRadioButton();

		tabbedPane = new JTabbedPane();
		trainerPanel = new JPanel();
		settingPanel = new SettingsPanel();
		controlPanel = new JPanel();
		modePanel = new JPanel();
		docpanel = new Docpanel();
		
		scorePanel = new ScorePanel(settingPanel, this);
		scorePanel.newRandom();
		scorePanel.repaint();
		keyPanel = new Keypanel(scorePanel, this, settingPanel);
		
		resetButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				resetButtonActionListener(e);
			}
		});
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tabbedPaneChangeListener(e);
			}
		});
		trainerRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trainerRadioActionListener(e);
			}
		});
		playRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playRadioActionListener(e);
			}
		});
		
		goodHitTextField.setText("0");
		badHitTextField.setText("0");
		goodHitTextField.setBounds(65, 0, 30, 30);
		badHitTextField.setBounds(65, 35, 30, 30);
		goodLabel.setBounds(0, 0, 62, 30);
		badLabel.setBounds(0, 35, 62, 30);
		resetButton.setBounds(2, 70, 100, 30);
		
		resultPanel.setBounds(15, 15, 120, 110);
		controlPanel.setBounds(15, 15, 140, 170);
		//~ controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		controlPanel.setLayout(null);
		controlPanel.setBorder(BorderFactory.createTitledBorder(
                       "Vezérlő"));
          
        playRadio.setText("Játék");
        trainerRadio.setText("Gyakorlás");
        trainerRadio.setSelected(true);
        modeGroup.add(playRadio);
        modeGroup.add(trainerRadio);
		modePanel.setBounds(795, 15, 140, 170);
		modePanel.setLayout(new BoxLayout(modePanel, BoxLayout.Y_AXIS));
		//~ modePanel.setLayout(null);
		modePanel.setBorder(BorderFactory.createTitledBorder(
                       "Módválasztó"));
        
        modePanel.add(playRadio);
        modePanel.add(trainerRadio);
		
		aboutButton.setBounds(17, 125, 100, 30 );
		aboutButton.setText("Névjegy");
		aboutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				aboutButtonActionPerformed(ev);
			}
		});
		
		goodHitTextField.setFocusable(false);
		badHitTextField.setFocusable(false);
		
		resultPanel.setLayout(null);
		resultPanel.add(resetButton);
		resultPanel.add(goodHitTextField);
		resultPanel.add(badHitTextField);
		resultPanel.add(goodLabel);
		resultPanel.add(badLabel);

		tabbedPane.addTab("Tréner", trainerPanel);
		tabbedPane.addTab("Beállítások", settingPanel);
		tabbedPane.addTab("Segítség", docpanel);
		
		
		
		controlPanel.add(resultPanel);
		controlPanel.add(aboutButton);
		
		trainerPanel.add(controlPanel);
		trainerPanel.add(scorePanel);
		trainerPanel.add(keyPanel);
		trainerPanel.add(modePanel);
		
		
		
		trainerPanel.setLayout(null);
		settingPanel.setLayout(new FlowLayout());
		
		setLayout( new BorderLayout() );
		
		add(tabbedPane);
		java.net.URL imageURL = 
			getClass().getResource("images/gSolmiIcon_32x32.png");
		setIconImage(new ImageIcon(imageURL).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(960, 480);
		centerWindow(this);
		setVisible(true);
	}
	public void aboutButtonActionPerformed(ActionEvent ev) {
		JOptionPane.showMessageDialog(this, aboutStr);
	}
	public void tabbedPaneChangeListener(ChangeEvent e) {
		keyPanel.showKeys();
		keyPanel.visibleKeyLabel();
		scorePanel.newRandom();
	}
	public void trainerRadioActionListener(ActionEvent e) {
		scorePanel.newRandom();
		scorePanel.repaint();
		keyPanel.setBackground(Color.GRAY);
		
	}
	public void playRadioActionListener(ActionEvent e) {
		keyPanel.setBackground(Color.ORANGE);
		
	}
	public void resetButtonActionListener(ActionEvent e) {
		goodHitTextField.setText("0");
		badHitTextField.setText("0");
		keyPanel.setGoodHit(0);
		keyPanel.setBadHit(0);
		if(trainerRadio.isSelected()) {
			keyPanel.setBackground(java.awt.Color.GRAY);
		}
	}
	public void setGoodHit(Integer hit) {
		goodHitTextField.setText(hit.toString());
	}
	public void setBadHit(Integer hit) {
		badHitTextField.setText(hit.toString());
	}
	public static void centerWindow(java.awt.Window frame) {
		java.awt.Dimension dimension =
		    java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int)((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int)((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

	public static void main(String[]args) {
		new Gsolmi();
	}
}
