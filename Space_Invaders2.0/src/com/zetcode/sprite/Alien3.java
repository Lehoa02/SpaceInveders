package com.zetcode.sprite;

import javax.swing.ImageIcon;
public class Alien3 extends Sprite {
	 private Bomb3 bomb;
     int hp = 3;
     private String explImg = "src\\images\\explosion.png";
	    public Alien3(int x, int y) {

	        initAlien(x, y);
	    }

	    private void initAlien(int x, int y) {

	        this.x = x;
	        this.y = y;
	        

	        bomb = new Bomb3(x, y);

	        var alienImg = "src\\images\\Alien3.png";
	        var ii = new ImageIcon(alienImg);

	        setImage(ii.getImage());
	    }

	    public void act(double direction) {

	        this.x += direction;
	    }
	
	    public Bomb3 getBomb() {

	        return bomb;
	    }

	    public class Bomb3 extends Sprite {

	        private boolean destroyed;

	        public Bomb3(int x, int y) {

	            initBomb3(x, y);
	        }

	        private void initBomb3(int x, int y) {

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

		public void decay2() {
			if(hp >=1) {
	    		hp--;
	    	}
	    	else
	    	{
	    		this.isDying();
	    		 var ii = new ImageIcon(explImg);
                 this.setImage(ii.getImage());
	    	}
			
		}
}
