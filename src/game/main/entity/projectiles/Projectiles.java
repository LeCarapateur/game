package game.main.entity.projectiles;

import game.main.Handler;
import game.main.entity.Entity;

public abstract class Projectiles extends Entity {
	 
	protected float speed;

	public Projectiles(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
