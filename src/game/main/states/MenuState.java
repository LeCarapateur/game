package game.main.states;

import java.awt.Color;
import java.awt.Graphics;

import game.main.Handler;

public class MenuState extends State {

	public MenuState(Handler handler) {
		super(handler);
	}
	
	@Override
	public void tick() {
		if(handler.getMouseManager().isLeftPressed() || handler.getMouseManager().isRightPressed())
			State.setState(handler.getGame().gameState);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.drawRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
	}
	

}
