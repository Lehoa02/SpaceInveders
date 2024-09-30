package com.zetcode.sprite;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;

import com.zetcode.Board;
import com.zetcode.Commons;
import com.zetcode.SpaceInvaders;

public class MouseInput implements MouseListener{
	

	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
 
		if(mx >= Commons.BOARD_WIDTH /2 - 80  && mx <= Commons.BOARD_WIDTH /2 -20) {
			if(my >= 250 && my <= 280) {
				//pressed play button
				Board.State = Board.STATE.LEVEL;
				
				 
				
				
				
			}
		}
	
			
		if(mx >= Commons.BOARD_WIDTH /2   && mx <= Commons.BOARD_WIDTH /2 +60) {
			if(my >= 250 && my <= 280) {
				//pressed exit button
				System.exit(1);
			}}
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
