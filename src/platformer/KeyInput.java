package platformer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import platformer.gameobjects.GameObject;
import platformer.gameobjects.Weapon;

public class KeyInput extends KeyAdapter {

	Handler handler;
	public int jumpHeight = -17;
	public int movement = 5;
	public int maxBullets = 4;

	/**
	 * A key handling class, the usable keys are : Right, Left, to move right
	 * and left respectively, Space to jump, and Ctrl to shoot Weapon.
	 * 
	 * @param handler
	 *            Takes in a handler class
	 */
	public KeyInput(Handler handler) {
		this.handler = handler;

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.objectlist.size(); i++) {
			GameObject tempObject = handler.objectlist.get(i);
			if (tempObject.getId() == ObjectId.Player) {
				// Moves the character right, changes direction to "Right"
				if (key == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(movement);
					tempObject.direction = ObjectId.Right;
				}
				// Moves the character left, changes direction to "Left"
				if (key == KeyEvent.VK_LEFT) {
					tempObject.setVelX(-movement);
					tempObject.direction = ObjectId.Left;
				}
				// Makes the character jump the specified height, must not
				// already be jumping
				if (key == KeyEvent.VK_SPACE && !tempObject.isJumping()) {
					tempObject.setJumping(true);
					tempObject.setVelY(jumpHeight);
				}
				// Shoots up to the maximum number of bullets, else returns
				if (key == KeyEvent.VK_CONTROL) {
					if (handler.lw.size() < maxBullets) {
						handler.addWeapon(new Weapon(tempObject.getX() + 30,
								tempObject.getY() + 60, tempObject
										.getDirection(), ObjectId.Weapon));
					}
				}

			}
		}

	}

	@Override
	// Stops the player from moving left or right upon key release
	public void keyReleased(KeyEvent e) {

		for (int i = 0; i < handler.objectlist.size(); i++) {
			GameObject tempObject = handler.objectlist.get(i);
			if (tempObject.getId() == ObjectId.Player) {
				tempObject.setVelX(0);
			}
		}
	}
}
