/*
* File: ScorePanel.java
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

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;
import java.util.Vector;
import javax.swing.JOptionPane;


class ScorePanel extends JPanel {
	final static long serialVersionUID = 1;
	String actualKey = "nothing";
	String osType;
	String hashMark = "♯";
	String[] whiteKeys = {
					"1C", "1D", "1E", "1F", "1G", "1A", "1H", 
					"2C", "2D", "2E", "2F", "2G", "2A", "2H", 
					"3C", "3D", "3E", "3F", "3G", "3A", "3H",
					"4C", "4D", "4E", "4F", "4G", "4A", "4H",
					"5C", "5D", "5E", "5F", "5G", "5A", "5H",
					"6C", "6D", "6E", "6F", "6G", "6A", "6H",
					"7C", "7D", "7E", "7F", "7G", "7A", "7H"
					 };
	String[] blackKeys = {
					"1C#", "1D#", "1F#", "1G#", "1A#",
					"2C#", "2D#", "2F#", "2G#", "2A#",
					"3C#", "3D#", "3F#", "3G#", "3A#",
					"4C#", "4D#", "4F#", "4G#", "4A#",
					"5C#", "5D#", "5F#", "5G#", "5A#",
					"6C#", "6D#", "6F#", "6G#", "6A#",
					"7C#", "7D#", "7F#", "7G#", "7A#"
					};
	SettingsPanel settingsPanel;
	JFrame jframe;
	Random random;
	Vector<String> enabledKeys;

	public ScorePanel(SettingsPanel settingsPanel, JFrame jframe) {
		setBounds(200, 10, 570, 260);
		setBackground(Color.WHITE);
		this.settingsPanel = settingsPanel;
		this.jframe = jframe;
		random = new Random();
		enabledKeys = new Vector<String>();
		this.osType = System.getProperty("os.name").toLowerCase();
	}
	public void newRandom() {
		this.actualKey = getRandomKey();
		//~ String origin = jframe.getTitle();		
		//~ jframe.setTitle(" keresett: " + actualKey);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawLinesRightHandLines(g);
		drawLinesLeftHandLines(g);
		drawNote(g, actualKey);		
		drawGKey(g);
		drawFKey(g);
	}
	public String getActualKey() {
		return actualKey;
	}
	public String[] getWhiteKeysArray() {
		return whiteKeys;
	}
	public String[] getBlackKeysArray() {
		return blackKeys;
	}
	public void drawFKey(Graphics g) {
		
		if(this.osType.indexOf("win") >= 0) {
			drawFKeyAsDrawing(g);
		}else {
			drawFKeyAsUnicodeChar(g);
		}
		
	}

	public void drawFKeyAsUnicodeChar(Graphics g) {
		Font currentFont = g.getFont();
		//~ Font newFont = currentFont.deriveFont(currentFont.getSize() * 4.5F);
		Font newFont = currentFont.deriveFont(currentFont.getSize());
		g.setFont(newFont);		
		g.drawString("𝄢", 50, 212 );		
			
	}	

	public void drawFKeyAsDrawing(Graphics g) {
		int keyBaseY = 40;
		Graphics2D g2 = (Graphics2D) g;

		CubicCurve2D c1 = new CubicCurve2D.Double();
		CubicCurve2D c2 = new CubicCurve2D.Double();
		
		c1.setCurve(70, keyBaseY + 140, 68, keyBaseY + 138, 65, keyBaseY + 133, 72, keyBaseY + 132);
		c2.setCurve(72, keyBaseY + 132, 87, keyBaseY + 125, 83, keyBaseY + 162, 67, keyBaseY + 165);
		
		g2.draw(c1);	
		g2.draw(c2);
		
		g.fillOval(70, keyBaseY + 140, 5, 5);
		g.fillOval(85, keyBaseY + 132, 6, 6);
		g.fillOval(85, keyBaseY + 142, 6, 6);			
	}	


	public void drawGKey(Graphics g) {
		if(this.osType.indexOf("win") >= 0) {
			drawGKeyAsDrawing(g);
		}else {
			drawGKeyAsUnicodeChar(g);
		}		
	}
	
	public void drawGKeyAsUnicodeChar(Graphics g) {
		Font currentFont = g.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 4.5F);
		g.setFont(newFont);		
		g.drawString("𝄞", 50, 110 );		
	}
	public void drawGKeyAsDrawing(Graphics g) {
		int keyBaseY = 40;
		Graphics2D g2 = (Graphics2D) g;

		CubicCurve2D c1 = new CubicCurve2D.Double();
		CubicCurve2D c2 = new CubicCurve2D.Double();
		CubicCurve2D c3 = new CubicCurve2D.Double();
		CubicCurve2D c4 = new CubicCurve2D.Double();
		CubicCurve2D c5 = new CubicCurve2D.Double();
		CubicCurve2D c6 = new CubicCurve2D.Double();

		c1.setCurve(70, keyBaseY + 50, 55, keyBaseY + 50, 55, keyBaseY + 65, 70, keyBaseY + 65);
		c2.setCurve(70, keyBaseY + 50, 75, keyBaseY + 50, 80, keyBaseY + 68, 70, keyBaseY + 70);
		c3.setCurve(70, keyBaseY + 40, 43, keyBaseY + 48, 52, keyBaseY + 74, 70, keyBaseY + 70);
		c4.setCurve(70, keyBaseY + 40, 75, keyBaseY + 37, 73, keyBaseY + 18, 70, keyBaseY + 20);
		c5.setCurve(70, keyBaseY + 20, 60, keyBaseY + 22, 80, keyBaseY + 85, 70, keyBaseY + 82);
		c6.setCurve(70, keyBaseY + 82, 67, keyBaseY + 85, 65, keyBaseY + 80, 68, keyBaseY + 80);
		
		g2.draw(c1);
		g2.draw(c2);
		g2.draw(c3);
		g2.draw(c4);
		g2.draw(c5);
		g2.draw(c6);
		
	}
	
	//*******************
	public void drawLinesRightHandLines(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawLine(50, 70, 500, 70);
		g.drawLine(50, 80, 500, 80);
		g.drawLine(50, 90, 500, 90);
		g.drawLine(50, 100, 500, 100);
		g.drawLine(50, 110, 500, 110);		
	}


	//*******************
	public void drawLinesLeftHandLines(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawLine(50, 170, 500, 170);
		g.drawLine(50, 180, 500, 180);
		g.drawLine(50, 190, 500, 190);
		g.drawLine(50, 200, 500, 200);
		g.drawLine(50, 210, 500, 210);		
	}

	private void writeHashmarkSign(Graphics g, int x, int y) {
		Font originFont = g.getFont();
		Font actualFont = originFont.deriveFont(originFont.getSize() * 1.8F);
		g.setFont(actualFont);
		if(hashMark.equals("♯")) y = y + 6;
		g.drawString(hashMark, x, y);
		g.setFont(originFont);
	}
	public void drawNote(Graphics g, String note) {
		
		// 1 AND 7 OCTAVE MISSING
		

		int y = 0; //
		
		int x = 280;
		int halfSignX = x-10;
		int halfSignYOffset = 8;
		int exLineX = x - 5;
		int base = 10;
		

		if(note.matches("^2C#?")) {
			y = base + 215;
			g.setColor(Color.BLUE);
			g.drawLine(exLineX, base + 210, exLineX + 20, base + 210);
			g.drawLine(exLineX, base + 220, exLineX + 20, base + 220);			
			if(note.equals("2C#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^2D#?")) {
			y = base + 210;
			g.setColor(Color.BLUE);
			g.drawLine(exLineX, base + 210, exLineX + 20, base + 210);			
			if(note.equals("2D#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.equals("2E")) {
			y = base + 205;
			g.setColor(Color.BLUE);
			g.drawLine(exLineX, base + 210, exLineX + 20, base + 210);

		}else if(note.matches("^2F#?")) {
			y = base + 200;
			if(note.equals("2F#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^2G#?")) {
			y = base + 195;
			if(note.equals("2G#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString("#", halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^2A#?")) {
			y = base + 190;
			if(note.equals("2A#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.equals("2H")) {
			y = base + 185;





		
		}else if(note.matches("^3C#?")) {
			if(settingsPanel.mixedWhiteC3_C4_checkBox.isSelected()) {
				boolean a = random.nextBoolean();
				if(a) {
					y = base + 140;
					g.setColor(Color.BLUE);
					g.drawLine(exLineX, base + 110, exLineX + 20, base + 110);
					g.drawLine(exLineX, base + 120, exLineX + 20, base + 120);
					g.drawLine(exLineX, base + 130, exLineX + 20, base + 130);
					g.drawLine(exLineX, base + 140, exLineX + 20, base + 140);
				}else {
					y = base + 180;
				}
			}else {
				y = base + 180;
			}
			if(note.equals("3C#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^3D#?")) {
			if(settingsPanel.mixedWhiteC3_C4_checkBox.isSelected()) {
				boolean a = random.nextBoolean();
				if(a) {
					y = base + 135;
					g.setColor(Color.BLUE);
					g.drawLine(exLineX, base + 110, exLineX + 20, base + 110);
					g.drawLine(exLineX, base + 120, exLineX + 20, base + 120);
					g.drawLine(exLineX, base + 130, exLineX + 20, base + 130);
					g.drawLine(exLineX, base + 140, exLineX + 20, base + 140);
				}else {
					y = base + 175;
				}
			}else {
				y = base + 175;
			}
			if(note.equals("3D#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString("#", halfSignX, y + halfSignYOffset);
			}
		}else if(note.equals("3E")) {
			if(settingsPanel.mixedWhiteC3_C4_checkBox.isSelected()) {
				boolean a = random.nextBoolean();
				if(a) {
					y = base + 130;
					g.setColor(Color.BLUE);
					g.drawLine(exLineX, base + 110, exLineX + 20, base + 110);
					g.drawLine(exLineX, base + 120, exLineX + 20, base + 120);
					g.drawLine(exLineX, base + 130, exLineX + 20, base + 130);
				}else {
					y = base + 170;
				}
			}else {
				y = base + 170;
			}
		}else if(note.matches("^3F#?")) {
			if(settingsPanel.mixedWhiteC3_C4_checkBox.isSelected()) {
				boolean a = random.nextBoolean();
				if(a) {
					y = base + 125;
					g.setColor(Color.BLUE);
					g.drawLine(exLineX, base + 110, exLineX + 20, base + 110);
					g.drawLine(exLineX, base + 120, exLineX + 20, base + 120);
					g.drawLine(exLineX, base + 130, exLineX + 20, base + 130);
				}else {
					y = base + 165;
				}
			}else {
				y = base + 165;
			}

			if(note.equals("3F#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString("#", halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^3G#?")) {
			if(settingsPanel.mixedWhiteC3_C4_checkBox.isSelected()) {
				boolean a = random.nextBoolean();
				if(a) {
					y = base + 120;
					g.setColor(Color.BLUE);
					g.drawLine(exLineX, base + 110, exLineX + 20, base + 110);
					g.drawLine(exLineX, base + 120, exLineX + 20, base + 120);
				}else {
					y = base + 160;
				}
			}else {
				y = base + 160;
			}

			if(note.equals("3G#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString("#", halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^3A#?")) {
			if(settingsPanel.mixedWhiteC3_C4_checkBox.isSelected()) {
				boolean a = random.nextBoolean();
				if(a) {
					y = base + 115;
					g.setColor(Color.BLUE);
					g.drawLine(exLineX, base + 110, exLineX + 20, base + 110);
					g.drawLine(exLineX, base + 120, exLineX + 20, base + 120);
				}else {
					y = base + 155;
				}
			}else {
				y = base + 155;
			}

			if(note.equals("3A#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString("#", halfSignX, y + halfSignYOffset);
			}
		}else if(note.equals("3H")) {
			if(settingsPanel.mixedWhiteC3_C4_checkBox.isSelected()) {
				boolean a = random.nextBoolean();
				if(a) {
					y = base + 110;
					g.setColor(Color.BLUE);
					g.drawLine(exLineX, base + 110, exLineX + 20, base + 110);
				}else {
					y = base + 150;
				}
			}else {
				y = base + 150;
			}






		//*****************************************************






		}else if(note.matches("^4C#?")) {
			if(settingsPanel.mixedWhiteC3_C4_checkBox.isSelected()) {
				boolean a = random.nextBoolean();
				g.setColor(Color.BLUE);
				if(a) {
					y = base + 105;					
					g.drawLine(exLineX, base + 110, exLineX + 20, base + 110);
				}else {
					y = base + 145;
					g.drawLine(exLineX, base + 150, exLineX + 20, base + 150);
				}
			}else {
				y = base + 105;
				g.drawLine(exLineX, base + 110, exLineX + 20, base + 110);
			}
			if(note.equals("4C#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^4D#?")) {
			y = base + 100;
			if(note.equals("4D#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.equals("4E")) {
			y = base + 95;
		}else if(note.matches("^4F#?")) {
			y = base + 90;
			if(note.equals("4F#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^4G#?")) {
			y = base + 85;
			if(note.equals("4G#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^4A#?")) {
			y = base + 80;
			if(note.equals("4A#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.equals("4H")) {
			y = base + 75;


		}else if(note.matches("^5C#?")) {
			y = base + 70;
			if(note.equals("5C#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^5D#?")) {
			y = base + 65;
			if(note.equals("5D#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.equals("5E")) {
			y = base + 60;
		}else if(note.matches("^5F#?")) {
			y = base + 55;
			if(note.equals("5F#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^5G#?")) {
			y = base + 50;
			if(note.equals("5G#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^5A#?")) {
			y = base + 45;
			g.setColor(Color.BLUE);
			g.drawLine(exLineX, base + 50, exLineX + 20, base + 50);
			if(note.equals("5A#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.equals("5H")) {
			y = base + 40;
			g.setColor(Color.BLUE);
			g.drawLine(exLineX, base + 50, exLineX + 20, base + 50);




			
		}else if(note.matches("^6C#?")) {
			y = base + 35;
			g.setColor(Color.BLUE);
			g.drawLine(exLineX, base + 40, exLineX + 20, base + 40);
			g.drawLine(exLineX, base + 50, exLineX + 20, base + 50);
			if(note.equals("6C#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^6D#?")) {
			y = base + 30;
			g.drawLine(exLineX, base + 40, exLineX + 20, base + 40);
			g.drawLine(exLineX, base + 50, exLineX + 20, base + 50);			

			if(note.equals("6D#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.equals("6E")) {
			y = base + 25;
			g.drawLine(exLineX, base + 30, exLineX + 20, base + 30);
			g.drawLine(exLineX, base + 40, exLineX + 20, base + 40);
			g.drawLine(exLineX, base + 50, exLineX + 20, base + 50);			

		}else if(note.matches("^6F#?")) {
			y = base + 20;
			g.drawLine(exLineX, base + 30, exLineX + 20, base + 30);
			g.drawLine(exLineX, base + 40, exLineX + 20, base + 40);
			g.drawLine(exLineX, base + 50, exLineX + 20, base + 50);			

			if(note.equals("6F#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^6G#?")) {
			y = base + 15;
			g.drawLine(exLineX, base + 20, exLineX + 20, base + 20);
			g.drawLine(exLineX, base + 30, exLineX + 20, base + 30);
			g.drawLine(exLineX, base + 40, exLineX + 20, base + 40);
			g.drawLine(exLineX, base + 50, exLineX + 20, base + 50);			

			if(note.equals("6G#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.matches("^6A#?")) {
			y = base + 10;
			g.setColor(Color.BLUE);
			g.drawLine(exLineX, base + 20, exLineX + 20, base + 20);
			g.drawLine(exLineX, base + 30, exLineX + 20, base + 30);
			g.drawLine(exLineX, base + 40, exLineX + 20, base + 40);
			g.drawLine(exLineX, base + 50, exLineX + 20, base + 50);			

			if(note.equals("6A#")) {
				writeHashmarkSign(g, halfSignX, y + halfSignYOffset);
				//~ g.drawString(hashMark, halfSignX, y + halfSignYOffset);
			}
		}else if(note.equals("6H")) {
			y = base + 5;
			g.setColor(Color.BLUE);
			g.drawLine(exLineX, base + 10, exLineX + 20, base + 10);
			g.drawLine(exLineX, base + 20, exLineX + 20, base + 20);
			g.drawLine(exLineX, base + 30, exLineX + 20, base + 30);
			g.drawLine(exLineX, base + 40, exLineX + 20, base + 40);
			g.drawLine(exLineX, base + 50, exLineX + 20, base + 50);			
		}else if(note.equals("7C")) {
			y = base + 0;
			g.setColor(Color.BLUE);
			g.drawLine(exLineX, base + 10, exLineX + 20, base + 10);
			g.drawLine(exLineX, base + 20, exLineX + 20, base + 20);
			g.drawLine(exLineX, base + 30, exLineX + 20, base + 30);
			g.drawLine(exLineX, base + 40, exLineX + 20, base + 40);
			g.drawLine(exLineX, base + 50, exLineX + 20, base + 50);			
		}

		g.setColor(Color.BLACK);
		g.fillOval(x, y, 12, 10);
	}





	public String getRandomKey() {
		enabledKeys.removeAllElements();

		//1. oktáv
		if(settingsPanel.whiteC1_C2_checkBox.isSelected()) {
			for (int i = 0*7; i < 0*7+7; i++){
				enabledKeys.add(whiteKeys[i]);
			}			
		}

		
		//2. oktáv
		if(settingsPanel.whiteC2_C3_checkBox.isSelected()) {
			for (int i = 1*7; i < 1*7+7; i++){
				enabledKeys.add(whiteKeys[i]);
			}			
		}

		//3. oktáv
		if(settingsPanel.whiteC3_C4_checkBox.isSelected()) {
			for (int i = 2*7; i < 2*7+7; i++){
				enabledKeys.add(whiteKeys[i]);
			}			
		}
		
		//4-dik oktáv
		if(settingsPanel.whiteC4_C5_checkBox.isSelected()) {
			for (int i = 3*7; i < 3*7+7; i++){
				enabledKeys.add(whiteKeys[i]);
			}			
		}

		//5. oktáv
		if(settingsPanel.whiteC5_C6_checkBox.isSelected()) {
			for (int i = 4*7; i < 4*7+7; i++){
				enabledKeys.add(whiteKeys[i]);
			}			
		}

		//6. oktáv
		if(settingsPanel.whiteC6_C7_checkBox.isSelected()) {
			for (int i = 5*7; i < 5*7+7; i++){
				enabledKeys.add(whiteKeys[i]);
			}			
		}

		// BLACK KEYS
/*
		//1. octave black keys
		if(settingsPanel.blackC1_C2_checkBox.isSelected()) {
			for (int i = 0*5; i < 0*5+5; i++){
				enabledKeys.add(blackKeys[i]);
			}			
		}
*/		
		//2. octave black keys
		if(settingsPanel.blackC2_C3_checkBox.isSelected()) {
			for (int i = 1*5; i < 1*5+5; i++){
				enabledKeys.add(blackKeys[i]);
			}			
		}

		//3. octave black keys
		if(settingsPanel.blackC3_C4_checkBox.isSelected()) {
			for (int i = 2*5; i < 2*5+5; i++){
				enabledKeys.add(blackKeys[i]);
			}			
		}

		//4. octave black keys
		if(settingsPanel.blackC4_C5_checkBox.isSelected()) {
			for (int i = 3*5; i < 3*5+5; i++){
				enabledKeys.add(blackKeys[i]);
			}			
		}

		//5. octave black keys
		if(settingsPanel.blackC5_C6_checkBox.isSelected()) {
			for (int i = 4*5; i < 4*5+5; i++){
				enabledKeys.add(blackKeys[i]);
			}			
		}

		//6. octave black keys
		if(settingsPanel.blackC6_C7_checkBox.isSelected()) {
			for (int i = 5*5; i < 5*5+5; i++){
				enabledKeys.add(blackKeys[i]);
			}			
		}
/*
		//7-dik octave black keys
		if(settingsPanel.blackC7_C8_checkBox.isSelected()) {
			for (int i = 6*5; i < 6*5+5; i++){
				enabledKeys.add(blackKeys[i]);
			}			
		}
*/


		//generate new Note
		int listSize = enabledKeys.size();
		String keyStr = "C4";
		if(listSize>0) {			
			int key = random.nextInt(listSize);
			keyStr = enabledKeys.get(key);
		}	

		//Debug
		//~ keyStr = "2C";

		return keyStr;
	}
}
