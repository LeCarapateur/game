package game.main.entity.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.main.Handler;
import game.main.entity.Entity;
import game.main.graphics.Animation;
import game.main.graphics.Assets;
import game.main.tiles.Tile;

public class Chest extends StaticEntity {
	
	private BufferedImage chest, openChest;

	public Chest(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 0;
		bounds.width = 32;
		bounds.y = 14;
		bounds.height = 18;
		
		//Animations
		chest = Assets.chest;
		openChest = Assets.openChest;
		
	}
	
	public void openChest(Entity e) {
		handler.getWorld().getEntityManager().getEntities().remove(e);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		//g.setColor(Color.red);
		//g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
		//			(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
		//			bounds.width, bounds.height);
		
	}
	
	private BufferedImage getCurrentAnimationFrame() {
			return chest;
	}

}
