package com.zetcode.sprite;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import com.zetcode.Commons;

public class Levels {
	Rectangle Level = new Rectangle( Commons.BOARD_WIDTH /2 -40,95, 75,20 );
	Rectangle Level2 = new Rectangle( Commons.BOARD_WIDTH /2 -40,150, 60,30);
	Rectangle Leve3 = new Rectangle(Commons.BOARD_WIDTH /2 -40,200, 60,30 );
	Rectangle Back = new Rectangle(Commons.BOARD_WIDTH /2 -40,200, 60,30 );
	
	Font newPix; 
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		try {
			newPix=Font.createFont(Font.TRUETYPE_FONT, ( new File("src\\PixelMplus10-Regular.ttf"))).deriveFont(30F);
			GraphicsEnvironment gn = GraphicsEnvironment.getLocalGraphicsEnvironment();
			gn.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));}
			catch(IOException | FontFormatException e) {}
		
		g.setFont(newPix);
		g.setColor(Color.green);
		g.drawString("Levels", Commons.BOARD_WIDTH /2 -50, 70 );
		
		
		g.setFont(newPix.deriveFont(14F));
		
		g.drawString("> Level 1", Commons.BOARD_WIDTH /2 -35, 110);
		
		g.drawString("> Level 2", Commons.BOARD_WIDTH /2 -35, 140);
		
		g.drawString("> Level 3", Commons.BOARD_WIDTH /2 -35, 170);
				
		g.drawString("> Back to Menu", Commons.BOARD_WIDTH /2 -55, 200);
		}
}
