package platformer.gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import platformer.ObjectId;

public abstract class GameObject {

	public int x;
	protected int y;
	protected ObjectId id;
	protected int velX = 0, velY = 0;
	protected boolean falling = true;
	protected boolean jumping = false;
	public ObjectId direction;
	protected int width, height;
	public boolean dead;

	/**
	 * A GameObject at the x and y coordinate, with the given ObjectId to
	 * indicate what kind of Object it is.
	 * 
	 * @param x
	 * @param y
	 * @param id
	 */
	public GameObject(int x, int y, ObjectId id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	/**
	 * @param object
	 */
	public abstract void tick(LinkedList<GameObject> object);

	/**
	 * Draws the GameObject
	 * 
	 * @param g
	 */
	public abstract void render(Graphics g);

	/**
	 * Obtains a Rectangle that contains the boundaries of the GameObject
	 * 
	 * @return Rectangle
	 */
	public abstract Rectangle getBounds();

	/**
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets x to the given x
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelX() {
		return velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public ObjectId getId() {
		return id;
	}

	public ObjectId getDirection() {
		return direction;
	}

	public void setDirection(ObjectId o) {
		this.direction = o;
	}

	/**
	 * @return the falling
	 */
	public boolean isFalling() {
		return falling;
	}

	/**
	 * @param falling
	 *            the falling to set
	 */
	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	/**
	 * @return the jumping
	 */
	public boolean isJumping() {
		return jumping;
	}

	/**
	 * @param jumping
	 *            the jumping to set
	 */
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	/**
	 * 
	 * @return the width of the GameObject
	 */
	public abstract int getWidth();

	public boolean isDead() {
		return dead;
	};

}
