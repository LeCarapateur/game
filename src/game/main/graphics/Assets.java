package game.main.graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player, grass, dirt, rock, tree, chest, openChest, slime, gobelin, potion;

	public static BufferedImage[] player_down, player_left, player_right, player_up;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

		player_down = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		player_up = new BufferedImage[4];

		player_down[0] = sheet.crop(0, 0, width, height);
		player_down[1] = sheet.crop(width, 0, width, height);
		player_down[2] = sheet.crop(width*2, 0, width, height);
		player_down[3] = sheet.crop(width*3, 0, width, height);
		player_left[0] = sheet.crop(width*4, 0, width, height);
		player_left[1] = sheet.crop(width*5, 0, width, height);
		player_left[2] = sheet.crop(width*6, 0, width, height);
		player_left[3] = sheet.crop(width*7, 0, width, height);
		player_right[0] = sheet.crop(width*8, 0, width, height);
		player_right[1] = sheet.crop(width*9, 0, width, height);
		player_right[2] = sheet.crop(width*10, 0, width, height);
		player_right[3] = sheet.crop(width*11, 0, width, height);
		player_up[0] = sheet.crop(width*12, 0, width, height);
		player_up[1] = sheet.crop(width*13, 0, width, height);
		player_up[2] = sheet.crop(width*14, 0, width, height);
		player_up[3] = sheet.crop(width*15, 0, width, height);
		
		player = sheet.crop(0, 0, width, height);
		grass = sheet.crop(0,  height, width, height);
		dirt = sheet.crop(width,  height, width, height);
		rock = sheet.crop(width*2,  height, width, height);
		tree = sheet.crop(width*3,  height, width, height);
		chest = sheet.crop(width*4, height, width, height);
		openChest = sheet.crop(width*5, height, width, height);
		slime = sheet.crop(width*6, height, width, height);
		gobelin = sheet.crop(width*7, height, width, height);
		potion = sheet.crop(width*8, height, width, height);
	}
	
}
