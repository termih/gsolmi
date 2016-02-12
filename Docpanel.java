/*
* File: DocPanel.java
* Author: Sallai András
* Copyright (c) Sallai András, 2015
* Date: 2015-12-17
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
import javax.swing.JTextArea;
import java.awt.Insets;

class Docpanel extends JPanel {
	final static  long serialVersionUID = 1;
	JTextArea descriptionText;
	public Docpanel() {
		descriptionText = new JTextArea();
		descriptionText.setBounds(10, 10, 200, 200);
		descriptionText.setMargin( new Insets(30, 30, 30, 30) );
		add(descriptionText);
		
		descriptionText.append(
			"Kottaoktató program\n\n" +
			
			"A program egy szintetizátor billentyűzetet emulál.\n" +
			"A beállításoknál megadható zongora billentyűzet is,\n" +
			"viszont az első és hetedik oktávon túli billentyűk\n" +
			"nem adnak hangot a zongora szélesség esetén, amelynek\n" +
			"technikai határait a számítógépek adják.\n\n" +
			
			"A Windowsos verzión a G és F kulcsok rajzolva\n" +
			"jelennek meg, mivel a Windows nem támogatja az F és G\n" +
			"kulcsok Unicode formában való megjelenítését.\n"
			
		);		
	}
}
