package com.zetcode.sprite;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.zetcode.sprite.MouseInput;
import com.zetcode.sprite.Menu;
import com.zetcode.Board;
import com.zetcode.Commons;

public class LevelInput implements MouseListener{
	


	@Override
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		if(mx >= Commons.BOARD_WIDTH /2 -40  && mx <= Commons.BOARD_WIDTH /2 +35) {
			if(my >= 95 && my <= 115) {
					//Board.State = Board.STATE.LEVEL;
				Board board = new Board();
				board.random2 = 15;
				Board.State = Board.STATE.GAME;
			}}
		
		if(mx >= Commons.BOARD_WIDTH /2 -40  && mx <= Commons.BOARD_WIDTH /2 +35) {
			if(my >= 130 && my <= 145) {
				Board.Speed = Board.Speed.L2;
				Board.State = Board.STATE.GAME;
			}}
		
		if(mx >= Commons.BOARD_WIDTH /2 -40  && mx <= Commons.BOARD_WIDTH /2 +35) {
			if(my >= 155 && my <= 175) {
				Board.Speed = Board.Speed.L3;
				Board.State = Board.STATE.GAME;
			}}
		
		if(mx >= Commons.BOARD_WIDTH /2 -40  && mx <= Commons.BOARD_WIDTH /2 +35) {
			if(my >= 185 && my <= 205) {
				Board.State = Board.STATE.MENU;
			}}
			}
	
		
		
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
