package com.zetcode.sprite;

import javax.swing.ImageIcon;

public class Barrier extends Sprite {
	String[] BarriersHP = {
			"src\\images\\Barrier6.png",
			"src\\images\\Barrier5.png",
			"src\\images\\Barrier3.png",
			"src\\images\\Barrier3.png",
			"src\\images\\Barrier2.png",
			"src\\images\\Barrier1.png" };
	private int width;
	private Bomb bomb;
	public int hp = 6;

	public Barrier(int x, int y) {

		initPlayer(x, y);
	}

	private void initPlayer(int x, int y) {
		this.x = x;
		this.y = y;
		var barrierImg = BarriersHP[5];
		var ii = new ImageIcon(barrierImg);

		width = ii.getImage().getWidth(null);
		setImage(ii.getImage());
	}

	public void decay() {
		if (hp >= 1) {

			var barrierImg = BarriersHP[(hp - 1)];
			var ii = new ImageIcon(barrierImg);

			width = ii.getImage().getWidth(null);
			setImage(ii.getImage());
			hp--;
		} else {
			this.die();
		}

	}

	public Bomb getBomb() {

		return bomb;
	}

	public class Bomb extends Sprite {

		private boolean destroyed;

		public Bomb(int x, int y) {

			initBomb(x, y);
		}

		private void initBomb(int x, int y) {

			setDestroyed(true);

			this.x = x;
			this.y = y;

			var bombImg = "src\\images\\bomb.png";
			var ii = new ImageIcon(bombImg);
			setImage(ii.getImage());
		}

		public void setDestroyed(boolean destroyed) {

			this.destroyed = destroyed;
		}

		public boolean isDestroyed() {

			return destroyed;
		}
	}
}
