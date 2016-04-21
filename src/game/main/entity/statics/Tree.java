package game.main.entity.statics;

import java.awt.Color;
import java.awt.Graphics;

import game.main.Handler;
import game.main.graphics.Assets;
import game.main.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);

		bounds.x = 5;
		bounds.width = 22;
		bounds.y = 31 ;
		bounds.height = 32;
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		//g.setColor(Color.red);
		//g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
		//			(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
		//			bounds.width, bounds.height);
	}
	
}
