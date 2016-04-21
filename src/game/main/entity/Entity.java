package game.main.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.main.Handler;
import game.main.entity.creatures.Creature;
import game.main.entity.creatures.Gobelin;
import game.main.entity.creatures.Player;
import game.main.entity.creatures.Slime;
import game.main.entity.edible.Edible;
import game.main.entity.edible.Potion;
import game.main.entity.statics.Chest;
import game.main.entity.statics.Tree;

public abstract class Entity {
	
	protected Handler handler;
	protected float x, y;
	protected int width, height, health;
	protected Rectangle bounds;
	
	private long lastTime = System.currentTimeMillis();
	private long timer = 0;
	
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width, height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public void generateMobs() {
		int rnd = (int) (Math.round(Math.random()*(3 - 0) + 0));
		int x = (int) (Math.round((Math.random() * (38 - 1)) + 1)*32);
		int y = (int) (Math.round((Math.random() * (38 - 1)) + 1)*32);
		System.out.println(x);
		System.out.println(y);
		if(rnd == 0) {
			handler.getWorld().getEntityManager().addEntity(new Slime(handler, x, y));
		} else if (rnd == 1) {
			handler.getWorld().getEntityManager().addEntity(new Gobelin(handler, x, y));
		} else if (rnd == 2) {
			handler.getWorld().getEntityManager().addEntity(new Potion(handler, x, y));
		}	
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			} else if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				checkTypeOfEntity(e);
				return true;
			}
		}
		return false;
	}
	
	public void checkTypeOfEntity(Entity e) {
		if(e instanceof Chest) {
			((Chest) e).openChest(e);
			
		} else if(e instanceof Tree) {
			
		} else if(e instanceof Creature) {
			fight(handler.getWorld().getEntityManager().getPlayer(), e);
		} else if(e instanceof Edible) {
			((Potion) e).usePotion(e);
		}
	}
	
	public void fight(Player player, Entity e) {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		 
		 if(timer > 200) {
			 timer = 0;
			if(handler.getKeyManager() != null) {
				((Creature) e).setHealth(((Creature) e).getHealth() - player.getAttack());
				if(((Creature) e).getHealth() <= 0) {
					((Creature) e).setHealth(0);
					handler.getWorld().getEntityManager().getEntities().remove(e);
					generateMobs();
				} else {
					player.setHealth(player.getHealth() - ((Creature) e).getAttack());
				}
			}
		 }	
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
}
