package com.zetcode;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import com.zetcode.sprite.Levels;
import com.zetcode.sprite.LevelInput;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.zetcode.sprite.Alien;
import com.zetcode.sprite.Alien2;
import com.zetcode.sprite.Alien3;
import com.zetcode.sprite.Back;
import com.zetcode.sprite.Barrier;
import com.zetcode.sprite.Civilian;
import com.zetcode.sprite.Back;
import com.zetcode.sprite.Menu;
import com.zetcode.sprite.MouseInput;
import com.zetcode.sprite.Player;
import com.zetcode.sprite.Shot;
import com.zetcode.sprite.Sprite;

public class Board extends JPanel {
	private Dimension d;
	private List<Alien> aliens;
	private List<Alien2> aliens2;
	private List<Alien3> aliens3;
	private List<Barrier> barriersL;
	private List<Civilian> civilians;
	private Player player;
	private Back back;
	private Shot shot;
	private int direction = -1;
	//private int direction2 = -1;
	private int direction3 = -1;
	private int deaths = 0;
	public int w = 0;
	public int random1=0;
	public int random2=15;
	int x4;
	int direction2 = -2;
	public boolean inGame = true;
	private String SaucerImg = "src\\images\\Alien2.png";
	private String explImg = "src\\images\\explosion.png";
	private String message = "Game Over";
	private String retryMessage = "Press the R key to restart";
	private int score = 0;
	private long startTime;
	public Timer timer;
	private Menu menu;
	public Font newPix; 
	private Levels levels;
	
	public static enum SPEED{
		L1,L2,L3
	};
	public static enum STATE{
		MENU,
		GAME,
		LEVEL
	};
	public static SPEED Speed = SPEED.L1;
	public static STATE State = STATE.MENU;
	
	public Board() {
 
		initBoard();
		gameInit();	
	}

	private void initBoard() {

		addKeyListener(new TAdapter());
		addMouseListener(new MouseInput());
		addMouseListener(new LevelInput());
		setFocusable(true);
		timer = new Timer(Commons.DELAY, new GameCycle());
		timer.start();
		startTime = System.currentTimeMillis();
	//	d = new Dimension(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
	//	setBackground(Color.black);

		
		
		//gameInit();
		
		
	}

	private void gameInit() {
		aliens = new ArrayList<>();
		aliens2 =new ArrayList<>();
		aliens3 = new ArrayList<>();
		barriersL = new ArrayList<>();
		civilians = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                var alien = new Alien(Commons.ALIEN_INIT_X + 18 * j,
                        Commons.ALIEN_INIT_Y + 18 * i);
                aliens.add(alien);
            }
        }
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 1; j++) {

                var alien2 = new Alien2(Commons.ALIEN2_INIT_X + 90 * 3,
                        Commons.ALIEN2_INIT_Y - 30 * i);
                aliens2.add(alien2);
            }
        }
        
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {

                var alien3 = new Alien3(Commons.ALIEN3_INIT_X + 100 * i,
                        Commons.ALIEN3_INIT_Y * j);
                aliens3.add(alien3);
            }
        }
		
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 6; j++) {
				var barrier = new Barrier(Commons.Barrier_INIT_X + 50 * j, Commons.Barrier_INIT_Y);
				barriersL.add(barrier);
			}
		}
		var civilian = new Civilian(Commons.CIVILIAN_INIT_X * 1, Commons.CIVILIAN_INIT_Y);
		civilians.add(civilian);
		
		this.addMouseListener(new MouseInput());
		this.addMouseListener(new LevelInput());
		levels = new Levels();
		player = new Player();
		shot = new Shot();
		menu = new Menu();
		back = new Back();
		

	}


	private void drawAliens(Graphics g) {
        for (Alien alien : aliens) {
            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this); }
            if (alien.isDying()) {
            	alien.die(); 
               }}
    }
    private void drawAliens2(Graphics g) {
        for (Alien2 alien2 : aliens2) {
            if (alien2.isVisible()) {
                g.drawImage(alien2.getImage(), alien2.getX(), alien2.getY(), this);}
            if (alien2.isDying()) {
                alien2.die();} }
    }
    private void drawAliens3(Graphics g) {
        for (Alien3 alien3 : aliens3) {
            if (alien3.isVisible()) {
                g.drawImage(alien3.getImage(), alien3.getX(), alien3.getY(), this);  }
            if (alien3.isDying()) {
                alien3.die();}}
    }

	private void drawBarriers(Graphics g) {
		for (Barrier barrier : barriersL) {
			if (barrier.isVisible()) {
				g.drawImage(barrier.getImage(), barrier.getX(), barrier.getY(), this);}
			if (barrier.isDying()) {
				barrier.die();}}
	}
	
	private void drawBack(Graphics g) {
		g.drawImage(back.getImage(), 0, 0, this);
	}

	private void drawPlayer(Graphics g) {
		if (player.isVisible()) {
			g.drawImage(player.getImage(), player.getX(), player.getY(), this);}
		if (player.isDying()) {
			player.die();
			inGame = false;}
	}
		
	private void drawCivilians(Graphics g) {
		for (Civilian civilian : civilians) {
			if (civilian.isVisible()) {
				g.drawImage(civilian.getImage(), civilian.getX(), civilian.getY(), this);}
			if (civilian.isDying()) {
				civilian.die();
				score = -300;}}
	}

	private void drawShot(Graphics g) {
		if (shot.isVisible()) {
			g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);}
	}

	private void drawBombing(Graphics g) {
        for (Alien a : aliens) {
            Alien.Bomb b = a.getBomb();
            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this);}  }
    }
	
    private void drawBombing2(Graphics g) {
        for (Alien2 a2 : aliens2) {
            Alien2.Bomb2 b2 = a2.getBomb();
            if (!b2.isDestroyed()) {
                g.drawImage(b2.getImage(), b2.getX(), b2.getY(), this); }}
    }
    
    private void drawBombing3(Graphics g) {
        for (Alien3 a3 : aliens3) {
            Alien3.Bomb3 b3 = a3.getBomb();
            if (!b3.isDestroyed()) {
                g.drawImage(b3.getImage(), b3.getX(), b3.getY(), this);} }
    }

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

	private void doDrawing(Graphics g) {
		//System.out.println(random2);
	    if (State == STATE.GAME) {
		g.setColor(Color.green);

		if (inGame) {
			drawBack(g);
			g.drawLine(0, Commons.GROUND, Commons.BOARD_WIDTH, Commons.GROUND);
			drawAliens(g);
			drawAliens2(g);
			drawAliens3(g);
			drawPlayer(g);
			drawBarriers(g);
			drawShot(g);
			
			drawBombing(g);
			drawBombing2(g);
			drawBombing3(g);
			drawCivilians(g);}
		else {
			if (timer.isRunning()) {
				timer.stop();}
			gameOver(g);
			}
		Toolkit.getDefaultToolkit().sync();}

	 if(State == STATE.MENU) {
			drawBack(g);
			menu.render(g);	
		}
	  if(State == STATE.LEVEL){
		 
			drawBack(g);
			levels.render(g);
		}
	
	}
	
	
	
	
	private void gameOver(Graphics g) {
		for (Civilian civilian : civilians) {
		if (civilian.isDying()) {
			civilian.die();			
			score = (deaths * 100)-300;
			//message="Civian is dead (-300points)";
		}
		else {
		score = (deaths * 100);}
		}

		drawBack(g);

		try {
		newPix=Font.createFont(Font.TRUETYPE_FONT, new File("src\\PixelMplus10-Regular.ttf")).deriveFont(30f);
		GraphicsEnvironment gn = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gn.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));}
		catch(IOException | FontFormatException e) {}
		
		g.setColor(Color.red);
		g.setFont(newPix);
		g.drawString(message, Commons.BOARD_WIDTH /2 -70 , 90);

		String s1 = String.valueOf(score);  
	
		g.setFont(newPix.deriveFont(14f));
		g.setColor(Color.green);
		g.drawString("Score: " + score, Commons.BOARD_WIDTH / 2 - (38 + s1.length()) , Commons.BOARD_HEIGHT / 2 -30);
		g.drawString(retryMessage, Commons.BOARD_WIDTH / 2 - 95,Commons.BOARD_HEIGHT / 2 +10);	
		
		
	}
	
	private void update(double CB) {
		
		
		if (deaths == Commons.NUMBER_OF_ALIENS_TO_DESTROY1) {
	
			inGame = false;
			timer.stop();
			message = "Game won!";
		}

		// player
		w = player.act();

		// shot
		if (shot.isVisible()) {

			int shotX = shot.getX();
			int shotY = shot.getY();

			for (Alien alien : aliens) {
				int alienX = alien.getX();
				int alienY = alien.getY();

				if (alien.isVisible() && shot.isVisible()) {
					if (shotX >= (alienX) && shotX <= (alienX + Commons.ALIEN_WIDTH) && shotY >= (alienY)
							&& shotY <= (alienY + Commons.ALIEN_HEIGHT)) {

						var ii = new ImageIcon(explImg);
						alien.setImage(ii.getImage());
						alien.setDying(true);
						deaths++;
						shot.die();}}}
		 
    for (Alien2 alien2 : aliens2) {

    int alienX2 = alien2.getX();
    int alienY2 = alien2.getY();

    if (alien2.isVisible() && shot.isVisible()) {
        if (shotX >= (alienX2)
                && shotX <= (alienX2 + Commons.ALIEN2_WIDTH)
                && shotY >= (alienY2)
                && shotY <= (alienY2 + Commons.ALIEN2_HEIGHT)) {

            var ii = new ImageIcon(explImg);
            alien2.setImage(ii.getImage());
           
            score = score + 300;
            shot.die();
        alien2.setX(250);
        alien2.setY(-20);
        var iii = new ImageIcon(SaucerImg);
        alien2.setImage(iii.getImage());
        }
    }
}

for (Alien3 alien3 : aliens3) {

    int alienX3 = alien3.getX();
    int alienY3 = alien3.getY();

    if (alien3.isVisible() && shot.isVisible()) {
        if (shotX >= (alienX3)
                && shotX <= (alienX3 + Commons.ALIEN3_WIDTH)
                && shotY >= (alienY3)
                && shotY <= (alienY3 + Commons.ALIEN3_HEIGHT)) {
            alien3.decay2();
            deaths = deaths + 2;
            shot.die();
        
        }
    }
}

			int y = shot.getY();
			y -= 10;
			if (CB == 0) {
				int sideShot1 = shot.getX();
				sideShot1 -= 7;

				if (y < 0) {
					shot.die();

				} else {
					shot.setY(y);
					shot.setX(sideShot1);}} 
			
			else if (CB == 1) {
				int sideShot1 = shot.getX();
				sideShot1 += 7;

				if (y < 0) {
					shot.die();

				} else {
					shot.setY(y);
					shot.setX(sideShot1);}} 
			else {

				if (y < 0) {
					shot.die();
				} else {
					shot.setY(y);}
			}
		}

		// aliens

		 for (Alien alien : aliens) {
	            int x = alien.getX();
	            if (x >= Commons.BOARD_WIDTH - Commons.BORDER_RIGHT && direction != -1) {
	                direction = -1;
	                Iterator<Alien> i1 = aliens.iterator();
	                while (i1.hasNext()) {
	                    Alien a2 = i1.next();
	                    a2.setY(a2.getY() + Commons.GO_DOWN); }
	            }
	            if (x <= Commons.BORDER_LEFT && direction != 1) {
	                direction = 1;
	                Iterator<Alien> i2 = aliens.iterator();
	                while (i2.hasNext()) {
	                    Alien a = i2.next();
	                    a.setY(a.getY() + Commons.GO_DOWN);   } }
	        }
	        Iterator<Alien> it = aliens.iterator();
	        while (it.hasNext()) {
	            Alien alien = it.next();
	            if (alien.isVisible()) {
	                int y = alien.getY();
	                if (y > Commons.GROUND - Commons.ALIEN_HEIGHT) {
	                    inGame = false;
	                    message = "Invasion!";}
	                alien.act(direction); } }
	        
	        //Alien2
	        for (Alien2 alien2 : aliens2) {
	            int x = alien2.getX();
	            if (x >= Commons.BOARD_WIDTH  + 75 - Commons.BORDER_RIGHT && direction != -1) {
	                direction3 = -1;
	                Iterator<Alien2> i1 = aliens2.iterator();
	                while (i1.hasNext()) {
	                    Alien2 a2 = i1.next();
	                    a2.setY(a2.getY() + (Commons.GO_DOWN * 3));  }}
	            if (x <= Commons.BORDER_LEFT - 75 && direction3 != 1) {
	                direction3 = 1;
	                Iterator<Alien2> i2 = aliens2.iterator();
	                while (i2.hasNext()) {
	                    Alien2 a = i2.next();
	                    a.setY(a.getY() + (Commons.GO_DOWN * ((int)Math.floor(Math.random() *(3 - 1 + 1) + 1)))); }}
	          	        }
	        Iterator<Alien2> ix = aliens2.iterator();
	        while (ix.hasNext()) {
	            Alien2 alien2 = ix.next();
	            if (alien2.isVisible()) {
	                int y = alien2.getY();
	                if (y > Commons.GROUND - Commons.ALIEN2_HEIGHT) {
	                    inGame = false;
	                    message = "Invasion!";
	                }
	                alien2.act((direction3 * (Math.floor(Math.random() *(3 - 0 + 1) + 0))));
	            }
	        }
		// Civilian

		for (Civilian civilian : civilians) {
			x4 = civilian.getX();
			if (x4 >= Commons.BOARD_WIDTH + Commons.BORDER_RIGHT + 50 && direction2 != -1) {
				direction2 = -1;
			}
			if (x4 <= Commons.BORDER_LEFT - 50 && direction2 != 1) {
				direction2 = 1;
			}
			civilian.act(direction2);
		}

		// bombs
		random1++;
		if(Speed==SPEED.L2)
			random2=6;
		if(Speed==SPEED.L3)
			random2=3;
	if(random1==random2) {
			random1=0;
		var generator = new Random();
		  for (Alien alien : aliens) {
				int shot = generator.nextInt(102);
				Alien.Bomb bomb = alien.getBomb();
				if (shot == Commons.CHANCE && alien.isVisible() && bomb.isDestroyed()) {
					bomb.setDestroyed(false);
					bomb.setX(alien.getX());
					bomb.setY(alien.getY());
				}
				int bombX = bomb.getX();
				int bombY = bomb.getY();
				int playerX = player.getX();
				int playerY = player.getY();
				if (player.isVisible() && !bomb.isDestroyed()) {
					if (bombX >= (playerX) && bombX <= (playerX + Commons.PLAYER_WIDTH) && bombY >= (playerY)
							&& bombY <= (playerY + Commons.PLAYER_HEIGHT)) {
						var ii = new ImageIcon(explImg);
						player.setImage(ii.getImage());
						player.setDying(true);
						bomb.setDestroyed(true);
					}
				}
				for (Alien2 alien2 : aliens2) {
					int shot2 = generator.nextInt(102);
					Alien.Bomb bomb2 = alien.getBomb();
					if (shot == Commons.CHANCE && alien.isVisible() && bomb.isDestroyed()) {
						bomb.setDestroyed(false);
						bomb.setX(alien2.getX());
						bomb.setY(alien2.getY());
					}
					int bombX2 = bomb2.getX();
					int bombY2 = bomb2.getY();
					int playerX2 = player.getX();
					int playerY2 = player.getY();
					if (player.isVisible() && !bomb.isDestroyed()) {
						if (bombX2 >= (playerX2) && bombX2 <= (playerX2 + Commons.PLAYER_WIDTH) && bombY2 >= (playerY2)
								&& bombY2 <= (playerY2+ Commons.PLAYER_HEIGHT)) {
							var ii = new ImageIcon(explImg);
							player.setImage(ii.getImage());
							player.setDying(true);
							bomb.setDestroyed(true);
						}
					}
					
			for (Barrier barrier : barriersL) {
				int barrierX = barrier.getX();
				int barrierY = barrier.getY();
				if (barrier.isVisible() && !bomb.isDestroyed()) {
					if (bombX >= (barrierX) && bombX <= (barrierX + Commons.BARRIER_WIDTH) && bombY >= (barrierY)
							&& bombY <= (barrierY + Commons.BARRIER_HEIGHT)) {
						var ii = new ImageIcon(explImg);
						barrier.setImage(ii.getImage());
						barrier.decay();
						bomb.setDestroyed(true);
					}
				}
			}
			for (Civilian civilian : civilians) {
				int civilianX = civilian.getX();
				int civilianY = civilian.getY();
				if (civilian.isVisible() && !bomb.isDestroyed()) {
					if (bombX >= (civilianX) && bombX <= (civilianX + Commons.CIVILIAN_WIDTH) && bombY >= (civilianY)
							&& bombY <= (civilianY + Commons.CIVILIAN_HEIGHT)) {
						var ii = new ImageIcon(explImg);
						civilian.setImage(ii.getImage());
						civilian.setDying(true);
						bomb.setDestroyed(true);
					}
				}
			}
			
			//ХУЕТА!!!!!!!!!!Ё!!!!!!!!
			//третье число в скобках увеличивает скорость

			if (!bomb.isDestroyed()) {
             bomb.setY(bomb.getY() + (int) (Math.random() * 1 +8));
				if (bomb.getY() >= Commons.GROUND - Commons.BOMB_HEIGHT) {
					bomb.setDestroyed(true);
				}
			}
		}
	 }}}

	public void doGameCycle() {
		repaint();
		if(State == STATE.GAME) {
		update(w);
		
		//menu.render(getGraphics());
	}}

	private class GameCycle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			doGameCycle();
		}
	}

	private class TAdapter extends KeyAdapter {
		
		@Override
		public void keyReleased(KeyEvent e) {

			player.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
		
			//еще один
			//if (State == STATE.GAME) {
			
			player.keyPressed(e);

			int x = player.getX();
			int y = player.getY();

			int key = e.getKeyCode();

			if (key == KeyEvent.VK_SPACE) {

				if (inGame) {

					if (!shot.isVisible()) {

						shot = new Shot(x, y);

					}
				}
			}
			
			if (key == KeyEvent.VK_R) {
				if (!inGame) {
					Container container = getRootPane();
					while (container.getParent() != null) {
						container = container.getParent();
					}
					container.setVisible(false);
					var ex = new SpaceInvaders();
					ex.setVisible(true);
				}
			}
		//}
			/*else if (State == STATE.MENU) {
				menu.render(getGraphics());
			}*/
			
		}
	}
	
}