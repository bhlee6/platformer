package platformer.gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;

import platformer.Game;
import platformer.Handler;
import platformer.ObjectId;
import platformer.images.Texture;

public class Enemy extends GameObject {

	private int width = 32, height = 32;
	public boolean dead = false;
	public int velX = -3;
	// ObjectId is either Left or Right
	public ObjectId direction;
	public Handler handler;
	// scale to the specified integer
	public int objectscale = 50;
	Texture tex = Game.getTexture();

	/**
	 * . An enemy that starts at the given x and y coordinate. The Handler to
	 * keep track other GameObjects. ObjectId is Enemy. The enemy can move back
	 * and forth, and is dead upon collision with a Weapon.
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @param handler
	 *            handler
	 * @param id
	 *            ObjectId should be Enemy
	 */
	public Enemy(int x, int y, Handler handler, ObjectId id) {

		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick(LinkedList<GameObject> object) {

		if (velX < 0)
			direction = ObjectId.Left;
		else if (velX > 0)
			direction = ObjectId.Right;

		hit(null);
		Collision(object);
		move();

	}

	/**
	 * Begins the movement of the enemy by adding velX to the x coordinate
	 * 
	 */
	private void move() {
		x += velX;

	}

	/**
	 * Checks to see if any Weapon intersects with the Enemy. If any do, then
	 * the Enemy is considered dead.
	 * 
	 * @param weapon
	 *            ArrayList of Weapon
	 */
	private void hit(ArrayList<Weapon> weaponlist) {

		for (int i = 0; i < handler.lw.size(); i++) {
			Weapon weap = handler.lw.get(i);
			if (this.getBounds().intersects(weap.getBounds()))
				this.dead = true;
		}

	}

	/**
	 * If the Enemy intersects/collides with a block in the list of GameObjects,
	 * then the enemy's velX is reversed (so it moves in the opposite
	 * direction).
	 * 
	 * @param object
	 *            GameObject list
	 */
	private void Collision(LinkedList<GameObject> objectlist) {

		for (int i = 0; i < handler.objectlist.size(); i++) {
			GameObject tempObject = handler.objectlist.get(i);
			if (tempObject.getId() == ObjectId.Block) {
				if (this.getBounds().intersects(tempObject.getBounds()))
					velX = -velX;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		if (direction == ObjectId.Left)
			g.drawImage(tex.enemy[0], x, y, objectscale, objectscale, null);
		else
			g.drawImage(tex.enemy[1], x, y, objectscale, objectscale, null);

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
	public boolean isDead() {
		return dead;
	}

}
