package platformer.gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import platformer.Game;
import platformer.ObjectId;
import platformer.images.Texture;

public class Block extends GameObject {

	public int width = 32;
	public int height = 32;
	private int type;
	Texture tex = Game.getTexture();

	/**
	 * A basic block that makes up a walkable ground at the x,y coordinates.
	 * Type helps indicate which graphic to use for the block from the Texture.
	 * ObjectId is Block.
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @param type
	 * @param id
	 *            ObjectId Block
	 */
	public Block(int x, int y, int type, ObjectId id) {
		super(x, y, id);
		this.type = type;

	}

	@Override
	public void render(Graphics g) {
		if (type == 0)// grass
			g.drawImage(tex.block[0], x, y, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
	}

}