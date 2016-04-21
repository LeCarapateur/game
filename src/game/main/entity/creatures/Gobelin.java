package game.main.entity.creatures;

import java.awt.Color;
import java.awt.Graphics;

import game.main.Handler;
import game.main.graphics.Assets;
import game.main.tiles.Tile;

public class Gobelin extends Creature {
	
	private int rnd;

	public Gobelin(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		//stats
		this.maxHealth = 5;
		this.health = maxHealth;
		this.attack = 2;
		this.defence = 1;
		this.xp = 8;
		
		//Collision box
		bounds.x = 0;
		bounds.y = 12;
		bounds.width = 32;
		bounds.height = 19;
	}
	
	private void rndDirection() {
		xMove = 0;
		yMove = 0;
		rnd = (int)( Math.random()*( 1000 - 0 + 1 ) ) + 0;
		
		if(rnd == 1)
			yMove = -speed*rnd/10;
		if(rnd == 200)
			yMove = speed*rnd/10;
		if(rnd == 300)
			xMove = -speed*rnd/10;
		if(rnd == 400)
			xMove = speed*rnd/10;
	}

	@Override
	public void tick() {
		move();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gobelin, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		g.setColor(Color.white);
		g.drawString(String.valueOf(this.health) + "/" + String.valueOf(this.maxHealth), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()) - 4);
		 
		// Hitbox of player
		
		//g.setColor(Color.red);
		//g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
		//			(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
		//			bounds.width, bounds.height);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
