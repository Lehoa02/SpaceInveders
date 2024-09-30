package com.zetcode.sprite;

import com.zetcode.Commons;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class Player extends Sprite {
	private int width;
	int shotvalue = 2;

	public Player() {

		initPlayer();
	}

	private void initPlayer() {

		var playerImg = "src\\images\\player.png";
		var ii = new ImageIcon(playerImg);

		width = ii.getImage().getWidth(null);
		setImage(ii.getImage());

		int START_X = 270;
		setX(START_X);

		int START_Y = 280;
		setY(START_Y);
	}

	public int act() {

		x += dx;

		if (x <= 2) {

			x = 2;
		}

		if (x >= Commons.BOARD_WIDTH - 2 * width) {

			x = Commons.BOARD_WIDTH - 2 * width;

		}
		return shotvalue;
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {

			dx = -2;
		}

		if (key == KeyEvent.VK_RIGHT) {

			dx = 2;
		}

		if (key == KeyEvent.VK_UP) {

			shotvalue = 0;
		}
		
		
		if (key == KeyEvent.VK_DOWN) {

			shotvalue = 1;
		}
		if (key == KeyEvent.VK_SHIFT) {

			shotvalue = 2;
		}

	}

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();
// ускоряет если менять числа (игрок)
		if (key == KeyEvent.VK_LEFT) {

			dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {

			dx = 0;
		}
	}
}