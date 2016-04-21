package game.main.entity.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import game.main.Game;
import game.main.Handler;
import game.main.entity.Entity;
import game.main.graphics.Animation;
import game.main.graphics.Assets;

public class Player extends Creature {

	
	private Animation animDown, animLeft, animRight, animUp; // Définition des animations pour le mouvement du joueur
	private BufferedImage player; // Définition 
	
	private int xpToNextLevel, level;
	private ArrayList<Entity> inventory;
	
	public Player(Handler handler, float x, float y) {	
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//Stats 
		this.maxHealth = 30;
		this.health = this.maxHealth;
		this.attack = 4;
		this.defence = 2;
		this.xp = xp;
		this.xpToNextLevel = 500;
		this.level = 1;
		
		this.inventory = inventory;
		
		//Collision box
		bounds.x = 8;
		bounds.y = 12;
		bounds.width = 16;
		bounds.height = 19;
		
		//Animations
		player = Assets.player;
		animDown = new Animation(128, Assets.player_down);
		animLeft = new Animation(128, Assets.player_left);
		animRight = new Animation(128, Assets.player_right);
		animUp = new Animation(128, Assets.player_up);
	}

	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animLeft.tick();
		animRight.tick();
		animUp.tick();
		
		//Mouvements
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;

		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
		if(handler.getKeyManager().g_key)
			generateMobs();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		g.setColor(Color.white);
		g.drawString(String.valueOf(this.health) + "/" + String.valueOf(this.maxHealth), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()) - 4);
		// Hitbox of player
		
		//g.setColor(Color.red);
		//g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
		//			(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
		//			bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return animRight.getCurrentFrame();
		} else if (yMove < 0) {
			return animUp.getCurrentFrame();
		} else if (yMove > 0) {
			return animDown.getCurrentFrame();
		} else {
			return player;
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public BufferedImage getPlayer() {
		return player;
	}

	public void setPlayer(BufferedImage player) {
		this.player = player;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getXpToNextLevel() {
		return xpToNextLevel;
	}

	public void setXpToNextLevel(int xpToNextLevel) {
		this.xpToNextLevel = xpToNextLevel;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public Entity getItemInventory(int index) {
		return inventory.get(index);
	}
	
	public boolean setItemInventory(Entity e) {
		return inventory.add(e);
	}
	
	
	

}