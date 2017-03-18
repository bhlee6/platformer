package platformer.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import platformer.ObjectId;

public class Weapon extends GameObject {

	public int width = 20, height = 5;
	public boolean dead = false;
	// The speed of the weapon
	public int weaponspeed = 8;

	/**
	 * Creates a moving laser starting from the x,y coordinates in the given
	 * direction ObjectId one of Left or Right. The id is Weapon.
	 * 
	 * @param x
	 *            int
	 * @param y
	 *            int
	 * @param direction
	 *            ObjectId indicating direction, Left or Right
	 * 
	 * @param id
	 *            ObjectId is Weapon
	 */
	public Weapon(int x, int y, ObjectId direction, ObjectId id) {
		super(x, y, id);
		this.direction = direction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see platformer.GameObject#tick(java.util.LinkedList)
	 */
	/**
	 * Moves the weapon in a continual direction at the given weapon speed.
	 */
	@Override
	public void tick(LinkedList<GameObject> objectlist) {
		if (this.direction == ObjectId.Left) {
			velX = -weaponspeed;
			x += velX;
		} else {
			velX = weaponspeed;
			x += velX;
		}

	}

	// Temporarily, a weapon is drawn as a red rectangle with the given width
	// and height
	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);

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
