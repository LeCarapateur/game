package game.main.entity.projectiles;

import java.awt.Graphics;

import game.main.Handler;
import game.main.tiles.Tile;

public class Arrow extends Projectiles {
	

	public Arrow(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

		this.speed = 6.0f;
	}
	
	public void move() {
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
