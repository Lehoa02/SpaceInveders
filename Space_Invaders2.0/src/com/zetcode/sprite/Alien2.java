package com.zetcode.sprite;

import javax.swing.ImageIcon;
public class Alien2 extends Sprite {
	 private Bomb2 bomb2;

	    public Alien2(int x, int y) {

	        initAlien2(x, y);
	    }

	    private void initAlien2(int x, int y) {

	        this.x = x;
	        this.y = y;

	        bomb2 = new Bomb2(x, y);

	        var alienImg = "src\\images\\Alien2.png";
	        var ii = new ImageIcon(alienImg);

	        setImage(ii.getImage());
	    }

	    public void act(double direction) {

	        this.x += direction;
	    }

	    public Bomb2 getBomb() {

	        return bomb2;
	    }

	    public class Bomb2 extends Sprite {

	        private boolean destroyed;

	        public Bomb2(int x, int y) {

	            initBomb2(x, y);
	        }

	        private void initBomb2(int x, int y) {

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

