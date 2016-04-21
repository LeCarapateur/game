package game.main.entity.edible;


import game.main.Handler;
import game.main.entity.Entity;

public abstract class Edible extends Entity {

	public Edible(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
