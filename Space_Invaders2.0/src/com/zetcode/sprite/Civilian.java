package com.zetcode.sprite;

import javax.swing.ImageIcon;

import com.zetcode.Commons;
import com.zetcode.sprite.Alien.Bomb;

public class Civilian extends Sprite {
	
	
	

	public Civilian(int x, int y) {
		
		initCivilian(x, y);
	}

	private void initCivilian(int x, int y) {
		this.x = x;
		this.y = y;

		//bomb = new Bomb(x, y);
		var civilianImg = "src\\images\\Civilian.png";
		var ii = new ImageIcon(civilianImg);

		setImage(ii.getImage());
	}

	public void act(int direction) {

		this.x += direction;
	}

/*	public class Bomb1 extends Sprite {

		private boolean destroyed;

		public Bomb1(int x, int y) {

			initBomb1(x, y);
		}

		private void initBomb1(int x, int y) {

			setDestroyed(true);

			this.x = x;
			this.y = y;

			var bombImg = "src\\images\\Civilian.png";
			var ii = new ImageIcon(bombImg);
			setImage(ii.getImage());
		}

		public void setDestroyed(boolean destroyed) {

			this.destroyed = destroyed;
		}

		public boolean isDestroyed() {

			return destroyed;
		}
	}*/

}
