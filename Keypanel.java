/*
* File: Keypanel.java
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

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.Graphics;
import javax.swing.JOptionPane;

class Keypanel extends JLayeredPane {
	final static  long serialVersionUID = 1;
	Sound sound = new Sound();
	JButton[] whiteButtons;
	JButton[] blackButtons;

	final int KEY_BASE_X = 10;
	final int KEY_BASE_Y = 10;
	final int WHITE_KEY_WIDTH = 25;
	final int WHITE_KEY_HEIGHT = 120;
	
	final int PIANO_MAX_WHITE_KEYS = 52;
	final int PIANO_MAX_BLACK_KEYS = 36;
	
	int blackKeyWidth = WHITE_KEY_WIDTH / 2;
	int blackKeyHeight = (int) (WHITE_KEY_HEIGHT * 0.65);
	ScorePanel scorePanel;
	Gsolmi jframe;
	SettingsPanel settingPanel;
	
	int goodHit;
	int badHit;
	
	public Keypanel(ScorePanel scorePanel, Gsolmi jframe, SettingsPanel settingPanel) {
		goodHit = 0;
		badHit = 0;
		this.scorePanel = scorePanel;
		this.jframe = jframe;
		this.settingPanel = settingPanel;

		
		whiteButtons = new JButton[PIANO_MAX_WHITE_KEYS];
		for(int i=0;i<PIANO_MAX_WHITE_KEYS;i++) {
			whiteButtons[i] = new JButton("");
		}
		blackButtons = new JButton[PIANO_MAX_BLACK_KEYS];
		for(int i=0;i<PIANO_MAX_BLACK_KEYS;i++) {
			blackButtons[i] = new JButton("");
		}

		//white keys
		setWhiteKeyPlace(0);
		for(int i=0;i<PIANO_MAX_WHITE_KEYS;i++) {
			whiteButtons[i].setBackground(Color.WHITE);
			this.setLayer(whiteButtons[i], 0);
			this.add(whiteButtons[i]);
			whiteButtons[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					buttonsActionListener(e);
				}
			});
		}
		//black keys
		setBlackKeyPlace(0);
		for(int i=0;i<PIANO_MAX_BLACK_KEYS;i++) {
			blackButtons[i].setBackground(Color.BLACK);
			this.setLayer(blackButtons[i], 1);
			this.add(blackButtons[i]);
			blackButtons[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					buttonsActionListener(e);
				}
			});
		}
		
		showKeys();
		
		setLayout(null);
		setBounds(10, 280, 
			KEY_BASE_X * 2 + 52 * WHITE_KEY_WIDTH, 
			KEY_BASE_Y * 2 + WHITE_KEY_HEIGHT);
		setOpaque(true);
		setBackground(Color.GRAY);
		visibleKeyLabel();
	}
	public void setWhiteKeyPlace(int offset) {
		for (int i = 0; i < PIANO_MAX_WHITE_KEYS; i++) {
			whiteButtons[i].setBounds(KEY_BASE_X + (i*WHITE_KEY_WIDTH) - offset, 
			KEY_BASE_Y, WHITE_KEY_WIDTH, WHITE_KEY_HEIGHT);
		}		
	}
	public void setBlackKeyPlace(int offset) {
		int blackKeyX = KEY_BASE_X - (int)(WHITE_KEY_WIDTH * 0.25);
		
		blackKeyX -= offset;

		for(int i=0;i<PIANO_MAX_BLACK_KEYS;i++) {
			blackKeyX = blackKeyX +  WHITE_KEY_WIDTH;		
			int j = i + 4;

			if( ((j+3)%5 == 0 || j%5==0) && j>0)  {
				blackKeyX = blackKeyX + WHITE_KEY_WIDTH;
			}
			
			blackButtons[i].setBounds(blackKeyX,
				KEY_BASE_Y, blackKeyWidth, blackKeyHeight);
		}
	}
	public void showKeys() {
		String selected = (String) settingPanel.countKeyCombo.getSelectedItem();
		int whiteFirstKey;
		int blackFirstKey;
		int whiteLastKey;
		int blackLastKey;
		if(selected.equals("61 szintetizátor")) {
			whiteFirstKey = 9;
			blackFirstKey = 6;
			whiteLastKey = 44;
			blackLastKey = 30;
			jframe.setSize(960, 480);
			setWhiteKeyPlace(220);
			setBlackKeyPlace(220);
			setBounds(10, 280, 
			KEY_BASE_X * 2 + 52 * WHITE_KEY_WIDTH - 390, 
			KEY_BASE_Y * 2 + WHITE_KEY_HEIGHT);
		}else {
			whiteFirstKey = 0;
			blackFirstKey = 0;
			whiteLastKey = 51;
			blackLastKey = 35;
			jframe.setSize(1350, 480);
			setWhiteKeyPlace(0);
			setBlackKeyPlace(0);
			setBounds(10, 280, 
			KEY_BASE_X * 2 + 52 * WHITE_KEY_WIDTH, 
			KEY_BASE_Y * 2 + WHITE_KEY_HEIGHT);
		}
		
		for(int i=0;i<52;i++) {			
			if(i >= whiteFirstKey &&  i<= whiteLastKey) {
				whiteButtons[i].setVisible(true);
			}else {
				whiteButtons[i].setVisible(false);
			}
		}		
		for(int i=0;i<36;i++) {
			if(i >= blackFirstKey && i <= blackLastKey) {
				blackButtons[i].setVisible(true);
			}else {
				blackButtons[i].setVisible(false);
			}
		}		
	}
	public void visibleKeyLabel() {
		
		if(settingPanel.keyLabelEnabledCheckBox.isSelected()) {
			for(int i=2; i<50; i++) {			
				whiteButtons[i].setVerticalAlignment(SwingConstants.BOTTOM) ;
				whiteButtons[i].setMargin(new Insets(0, 0, 0, 0));
				whiteButtons[i]. setText(scorePanel.whiteKeys[i-2]);
			}
			//Ide jön még a fekete billentyűk feliratozása
		}else {			
			for(int i=2; i<50; i++) {			
				whiteButtons[i].setVerticalAlignment(SwingConstants.BOTTOM) ;
				whiteButtons[i].setMargin(new Insets(0, 0, 0, 0));
				whiteButtons[i]. setText("");
			}
			//Ide jön még a fekete billentyűk feliratozása			
		}
	}

	public void setGoodHit(int goodHit) {
		this.goodHit = goodHit;
	}
	public void setBadHit(int badHit) {
		this.badHit = badHit;
	}
	public void buttonsActionListener(ActionEvent e) {		

		JButton src = (JButton)e.getSource();		
		
		playKey(src);
		
		//Check which select mode
		if(jframe.trainerRadio.isSelected()) {
			if(isRightKey(src)) {
				setBackground(Color.GREEN);
				goodHit++;
				jframe.setGoodHit((Integer)goodHit);
				scorePanel.newRandom();
				scorePanel.repaint();
			}else {
				badHit++;
				jframe.setBadHit(badHit);
				setBackground(Color.RED);
			}
		}else {
			showKeyForNote(src);
		}
	}
	private void showKeyForNote(JButton src) {

		String selected = (String) settingPanel.countKeyCombo.getSelectedItem();
		if(selected.equals("61 szintetizátor")) {
			showOneKeyFrom61(src);
		}else {
			showOneKeyFrom61(src);
			showOneKeyFromBalance(src);
		}
	}
	private void showOneKeyFromBalance(JButton src) {
		//61-en kívüli billentyűk 
		//de ez még nem működik, mert a 75 billentyűs 
		// zongora hangjai nincsennek készen a ScorePanel.drawNote()
		// metódusban.
		if(src == whiteButtons[0]) {
			scorePanel.actualKey = "1C";
		}
		if(src == whiteButtons[1]) {
			scorePanel.actualKey = "1D";
		}
		if(src == whiteButtons[2]) {
			scorePanel.actualKey = "1E";
		}
		//...
		scorePanel.repaint();
	}
	private void showOneKeyFrom61(JButton src) {
		//61 keys
		if(src == whiteButtons[9]) {
			scorePanel.actualKey = "2C";
		}
		if(src == whiteButtons[10]) {
			scorePanel.actualKey = "2D";
		}
		if(src == whiteButtons[11]) {
			scorePanel.actualKey = "2E";
		}
		if(src == whiteButtons[12]) {
			scorePanel.actualKey = "2F";
		}
		if(src == whiteButtons[13]) {
			scorePanel.actualKey = "2G";
		}
		if(src == whiteButtons[14]) {
			scorePanel.actualKey = "2A";
		}
		if(src == whiteButtons[15]) {
			scorePanel.actualKey = "2H";
		}

		if(src == whiteButtons[16]) {
			scorePanel.actualKey = "3C";
		}
		if(src == whiteButtons[17]) {
			scorePanel.actualKey = "3D";
		}
		if(src == whiteButtons[18]) {
			scorePanel.actualKey = "3E";
		}
		if(src == whiteButtons[19]) {
			scorePanel.actualKey = "3F";
		}
		if(src == whiteButtons[20]) {
			scorePanel.actualKey = "3G";
		}
		if(src == whiteButtons[21]) {
			scorePanel.actualKey = "3A";
		}
		if(src == whiteButtons[22]) {
			scorePanel.actualKey = "3H";
		}


		if(src == whiteButtons[23]) {
			scorePanel.actualKey = "4C";
		}
		if(src == whiteButtons[24]) {
			scorePanel.actualKey = "4D";
		}
		if(src == whiteButtons[25]) {
			scorePanel.actualKey = "4E";
		}
		if(src == whiteButtons[26]) {
			scorePanel.actualKey = "4F";
		}
		if(src == whiteButtons[27]) {
			scorePanel.actualKey = "4G";
		}
		if(src == whiteButtons[28]) {
			scorePanel.actualKey = "4A";
		}
		if(src == whiteButtons[29]) {
			scorePanel.actualKey = "4H";
		}


		if(src == whiteButtons[30]) {
			scorePanel.actualKey = "5C";
		}
		if(src == whiteButtons[31]) {
			scorePanel.actualKey = "5D";
		}
		if(src == whiteButtons[32]) {
			scorePanel.actualKey = "5E";
		}
		if(src == whiteButtons[33]) {
			scorePanel.actualKey = "5F";
		}
		if(src == whiteButtons[34]) {
			scorePanel.actualKey = "5G";
		}
		if(src == whiteButtons[35]) {
			scorePanel.actualKey = "5A";
		}
		if(src == whiteButtons[36]) {
			scorePanel.actualKey = "5H";
		}


		if(src == whiteButtons[37]) {
			scorePanel.actualKey = "6C";
		}
		if(src == whiteButtons[38]) {
			scorePanel.actualKey = "6D";
		}
		if(src == whiteButtons[39]) {
			scorePanel.actualKey = "6E";
		}
		if(src == whiteButtons[40]) {
			scorePanel.actualKey = "6F";
		}
		if(src == whiteButtons[41]) {
			scorePanel.actualKey = "6G";
		}
		if(src == whiteButtons[42]) {
			scorePanel.actualKey = "6A";
		}
		if(src == whiteButtons[43]) {
			scorePanel.actualKey = "6H";
		}
		if(src == whiteButtons[44]) {
			scorePanel.actualKey = "7C";
		}



		if(src == blackButtons[6]) {
			scorePanel.actualKey = "2C#";
		}
		if(src == blackButtons[7]) {
			scorePanel.actualKey = "2D#";
		}
		if(src == blackButtons[8]) {
			scorePanel.actualKey = "2F#";
		}
		if(src == blackButtons[9]) {
			scorePanel.actualKey = "2G#";
		}
		if(src == blackButtons[10]) {
			scorePanel.actualKey = "2A#";
		}

		if(src == blackButtons[11]) {
			scorePanel.actualKey = "3C#";
		}
		if(src == blackButtons[12]) {
			scorePanel.actualKey = "3D#";
		}
		if(src == blackButtons[13]) {
			scorePanel.actualKey = "3F#";
		}
		if(src == blackButtons[14]) {
			scorePanel.actualKey = "3G#";
		}
		if(src == blackButtons[15]) {
			scorePanel.actualKey = "3A#";
		}

		if(src == blackButtons[16]) {
			scorePanel.actualKey = "4C#";
		}
		if(src == blackButtons[17]) {
			scorePanel.actualKey = "4D#";
		}
		if(src == blackButtons[18]) {
			scorePanel.actualKey = "4F#";
		}
		if(src == blackButtons[19]) {
			scorePanel.actualKey = "4G#";
		}
		if(src == blackButtons[20]) {
			scorePanel.actualKey = "4A#";
		}

		if(src == blackButtons[21]) {
			scorePanel.actualKey = "5C#";
		}
		if(src == blackButtons[22]) {
			scorePanel.actualKey = "5D#";
		}
		if(src == blackButtons[23]) {
			scorePanel.actualKey = "5F#";
		}
		if(src == blackButtons[24]) {
			scorePanel.actualKey = "5G#";
		}
		if(src == blackButtons[25]) {
			scorePanel.actualKey = "5A#";
		}

		if(src == blackButtons[26]) {
			scorePanel.actualKey = "6C#";
		}
		if(src == blackButtons[27]) {
			scorePanel.actualKey = "6D#";
		}
		if(src == blackButtons[28]) {
			scorePanel.actualKey = "6F#";
		}
		if(src == blackButtons[29]) {
			scorePanel.actualKey = "6G#";
		}
		if(src == blackButtons[30]) {
			scorePanel.actualKey = "6A#";
		}



		scorePanel.repaint();		
	}
	private boolean isRightKey(JButton src) {
		String actualKey = scorePanel.getActualKey();
		String[] whiteKeys = scorePanel.getWhiteKeysArray();
		String[] blackKeys = scorePanel.getBlackKeysArray();

		String origin = jframe.getTitle();

		boolean ok = false;
		
		for (int i = 0; i < 52; i++) {
			if(src == whiteButtons[i] && actualKey.equals(whiteKeys[i-2]) ) {
				ok = true;
				jframe.setTitle(origin + " leütött: " + Integer.toString(i));
			}
		}
		for (int i = 0; i < 36; i++) {
			if(src == blackButtons[i] && actualKey.equals(blackKeys[i-1]) ) {
				ok = true;
				jframe.setTitle(origin + " leütött: " + Integer.toString(i));
			}
		}
		
		return ok;	
	}
	private void playKey(JButton src) {
		String instrumentStr = (String) settingPanel.instrumentCombo.getSelectedItem();
		int instrument = Integer.parseInt(instrumentStr);
		
		String[] whiteKeysLabel = {
			"C", "D", "E", "F", "G", "A", "B" 
		};
		Integer octave = 0;
		Integer noteIndex = 0;
		Integer counter = 0;
		for (int i = 2; i < 51; i++) {
			
			if(counter % 7 == 0) {
				octave++;
				noteIndex = 0;
			}
			
			if(src == whiteButtons[i]) {
				sound.play(octave, whiteKeysLabel[noteIndex], instrument);
				jframe.setTitle(whiteKeysLabel[noteIndex]);
			}
			noteIndex++;
			counter++;
		}
		//------------------------------------
		
		String[] blackKeysLabel = {
			"C#", "D#", "F#", "G#", "A#"
		};
		octave = 0;
		noteIndex = 0;
		counter = 0;
		for (int i = 1; i < 36; i++) {
			if(counter % 5 == 0) {
				octave++;
				noteIndex = 0;
			}

			if(src == blackButtons[i]) {
				sound.play(octave, blackKeysLabel[noteIndex], instrument);
				jframe.setTitle(blackKeysLabel[noteIndex]);
			}
			noteIndex++;
			counter++;		
		}
		 
	}
}
