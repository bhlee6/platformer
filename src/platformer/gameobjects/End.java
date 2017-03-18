package platformer.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import platformer.ObjectId;

public class End extends GameObject {

	public int width = 50, height = 100;

	/**
	 * An object indicating the end of a level. ObjectId is End.
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @param id
	 *            ObjectId is End
	 */
	public End(int x, int y, ObjectId id) {
		super(x, y, id);
	}

	@Override
	public void tick(LinkedList<GameObject> object) {

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y - 50, width, height);

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y - 50, width, height);
	}

	@Override
	public int getWidth() {
		return width;
	}
}
