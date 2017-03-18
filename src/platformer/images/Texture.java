package platformer.images;

import java.awt.image.BufferedImage;

public class Texture {

	// initialize SpriteSheets to null
	SpriteSheet bs, ps, es;
	private BufferedImage block_sheet = null;
	private BufferedImage player_sheet = null;
	private BufferedImage enemy_sheet = null;

	/**
	 * types of images in each Example: public BufferedImage[] block = new
	 * BufferedImage[1]; public BufferedImage[] player = new BufferedImage[4];
	 * 
	 * There are 4 player images, and only one block image
	 * 
	 */
	public BufferedImage[] block = new BufferedImage[1];
	public BufferedImage[] fire = new BufferedImage[1];
	public BufferedImage[] player = new BufferedImage[4];
	public BufferedImage[] enemy = new BufferedImage[2];

	/**
	 * Loads images from a path through BufferedImageLoader, creates new
	 * SpriteSheets from the loaded images, and then calls getTextures.
	 */
	public Texture() {
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			block_sheet = loader.loadImage("/block_sheet.png");
			player_sheet = loader.loadImage("/player_sheet.png");
			enemy_sheet = loader.loadImage("/enemy_sheet.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		bs = new SpriteSheet(block_sheet);
		ps = new SpriteSheet(player_sheet);
		es = new SpriteSheet(enemy_sheet);

		getTextures();
	}

	/**
	 * Pulls and Indexes the sub-images from the image file at the specified
	 * location along the specified width and height.
	 * 
	 */
	private void getTextures() {
		block[0] = bs.grabImage(1, 1, 32, 32); // grass
		fire[0] = bs.grabImage(2, 1, 32, 32); // fire

		player[0] = ps.grabImage(1, 1, 32, 32);// player 1st frame
		player[1] = ps.grabImage(2, 1, 32, 32);// 2nd frame, facing right
		player[2] = ps.grabImage(3, 1, 32, 32);// facing left, still
		player[3] = ps.grabImage(4, 1, 32, 32);// facing left, moving

		enemy[0] = es.grabImage(1, 1, 32, 32); // enemy left
		enemy[1] = es.grabImage(2, 1, 32, 32); // enemy right

	}

}
