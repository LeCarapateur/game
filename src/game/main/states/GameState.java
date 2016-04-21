package game.main.states;

import java.awt.Graphics;

import game.main.Handler;
import game.main.worlds.World;


public class GameState extends State{

	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		String user = System.getProperty("user.name");
		world = new World(handler, "/Users/" + user + "/Documents/Dragon's Soul/worlds/world.txt");
		handler.setWorld(world);
		
		handler.getGameCamera().move(0, 0);
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}
	
	
	
}
