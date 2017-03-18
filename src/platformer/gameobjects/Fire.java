package platformer.gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import platformer.Game;
import platformer.ObjectId;
import platformer.images.Texture;

public class Fire extends GameObject {

	public int width = 32;
	public int height = 32;
	Texture tex = Game.getTexture();
	private int type;

	/**
	 * Creates a fire object at the given x and y coordinates. ObjectId is Fire.
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @param type
	 * @param id
	 *            ObjectId is Fire
	 */
	public Fire(int x, int y, int type, ObjectId id) {
		super(x, y, id);
		this.type = type;

	}

	@Override
	public void tick(LinkedList<GameObject> object) {

	}

	@Override
	public void render(Graphics g) {
		if (type == 0)// fire
			g.drawImage(tex.fire[0], x, y, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	@Override
	public int getWidth() {
		return width;
	}

}