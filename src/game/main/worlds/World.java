package game.main.worlds;

import java.awt.Graphics;

import game.main.Handler;
import game.main.entity.EntityManager;
import game.main.entity.creatures.Gobelin;
import game.main.entity.creatures.Player;
import game.main.entity.edible.Potion;
import game.main.entity.creatures.Slime;
import game.main.entity.statics.Chest;
import game.main.entity.statics.Tree;
import game.main.tiles.Tile;
import game.main.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int [][] tiles;
	//Entities
	private EntityManager entityManager;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 32, 32));
		entityManager.addEntity(new Slime(handler, 32, 96));
		entityManager.addEntity(new Chest(handler, 32, 160));
		entityManager.addEntity(new Gobelin(handler, 32, 192));
		entityManager.addEntity(new Potion(handler, 32, 224));
		entityManager.addEntity(new Tree(handler, 64, 96));
		entityManager.addEntity(new Slime(handler, 64, 160));
		entityManager.addEntity(new Tree(handler, 96, 96));
		entityManager.addEntity(new Tree(handler, 160, 96));
		entityManager.addEntity(new Chest(handler, 224, 256));
		entityManager.addEntity(new Tree(handler, 224, 128));
		entityManager.addEntity(new Tree(handler, 256, 192));
		entityManager.addEntity(new Tree(handler, 256, 256));
		entityManager.addEntity(new Gobelin(handler, 480, 256));
		entityManager.addEntity(new Gobelin(handler, 512, 224));
		entityManager.addEntity(new Slime(handler, 320, 256));
		entityManager.addEntity(new Slime(handler, 320, 224));
		loadWorld(path);

		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getWidth()) / Tile.TILEHEIGHT + 1);
		
		
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}

