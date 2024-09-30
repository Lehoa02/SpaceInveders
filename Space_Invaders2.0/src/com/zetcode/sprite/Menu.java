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

import com.zetcode.Board;
import com.zetcode.Commons;

public class Menu  {
	
	public Rectangle playButton = new Rectangle( Commons.BOARD_WIDTH /2 -80,250, 60,30 );
	/*public Rectangle LevelsButton = new Rectangle( Commons.BOARD_WIDTH /2 -40,150, 60,30);
	public Rectangle SettingsButton = new Rectangle(Commons.BOARD_WIDTH /2 -40,200, 60,30 );*/
	public Rectangle ExitButton = new Rectangle( Commons.BOARD_WIDTH /2 ,250, 60,30);
	
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
		g.drawString("SPACE INVADERS", Commons.BOARD_WIDTH /2 -105, 70 );
		
		
		g.setFont(newPix.deriveFont(10F));
		
		g.drawString("Play", playButton.x +19, playButton.y +18);
		g2d.draw(playButton);
		
		/*g.drawString("Levels", LevelsButton.x +14, LevelsButton.y +18);
		g2d.draw(LevelsButton);
		
		g.drawString("Settings", SettingsButton.x +10, SettingsButton.y +18);
		g2d.draw(SettingsButton);*/
		
		g.drawString("Exit", ExitButton.x +19, ExitButton.y +18);
		g2d.draw(ExitButton);
		
	}
}
