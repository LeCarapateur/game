package game.main.entity.edible;

import java.awt.Color;
import java.awt.Graphics;

import game.main.Handler;
import game.main.entity.Entity;
import game.main.graphics.Assets;
import game.main.tiles.Tile;

public class Potion extends Edible {
	
	public Potion(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

		this.health = 15;
		
		//Collision box
		bounds.x = 0;
		bounds.y = 12;
		bounds.width = 32;
		bounds.height = 19;
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.potion, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		//g.setColor(Color.red);
		//g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
		//			(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
		//			bounds.width, bounds.height);
	}

	public void usePotion(Entity e) {
		int heal = handler.getWorld().getEntityManager().getPlayer().getHealth() + e.getHealth();
		handler.getWorld().getEntityManager().getPlayer().setHealth(heal);
		if(handler.getWorld().getEntityManager().getPlayer().getHealth() > handler.getWorld().getEntityManager().getPlayer().getMaxHealth())
			handler.getWorld().getEntityManager().getPlayer().setHealth(handler.getWorld().getEntityManager().getPlayer().getMaxHealth());
		handler.getWorld().getEntityManager().getEntities().remove(e);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	
}
