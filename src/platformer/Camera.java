package platformer;

import platformer.gameobjects.GameObject;

public class Camera {

	/**
	 * Camera class x,y coordinates for the camera
	 */
	private int x, y;

	/**
	 * 
	 * This creates a Camera at the given x and y coordinate
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 */
	public Camera(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * Tick for the camera based around the player. Sets the x value to the
	 * specified distance next to the player and the game width.
	 * 
	 * @param player
	 *            the player GameObject
	 */
	public void tick(GameObject player) {
		// Camera's x centers player
		x = -player.getX() + Game.WIDTH / 2 - 100;
	}

}
