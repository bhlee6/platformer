package platformer.gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import platformer.Game;
import platformer.Handler;
import platformer.ObjectId;
import platformer.images.Animation;
import platformer.images.Texture;

public class Player extends GameObject {

	private int width = 48, height = 96;
	private int gravity = 1;

	// maximum Falling speed
	public final int MAX_SPEED = 10;
	public ObjectId direction;
	public boolean dead = false;
	private Handler handler;
	private Animation playerwalk, playerwalkleft;
	Texture tex = Game.getTexture();

	/**
	 * Creates a player at the x and y coordinate. Handler to keep track of
	 * gameObjects interacting with the player, and the ObjectId is Player.
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @param handler
	 *            handler
	 * @param id
	 *            ObjectId is Player
	 */
	public Player(int x, int y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		// Player walking Left Animation
		playerwalkleft = new Animation(5, tex.player[3], tex.player[2]);
		// Player walking Right Animation
		playerwalk = new Animation(5, tex.player[0], tex.player[1]);

	}

	/**
	 * Updates the player x and y and animations as they move left and right,
	 * and falls at a certain maximum speed. If the player drops below the game
	 * height and player height, then the player dies.
	 */
	@Override
	public void tick(LinkedList<GameObject> object) {

		x += velX;
		y += velY;

		if (velX < 0)
			direction = ObjectId.Left;
		else if (velX > 0)
			direction = ObjectId.Right;

		if (falling || jumping) {
			velY += gravity;
			if (velY > MAX_SPEED)
				velY = MAX_SPEED;
		}

		// If the player drops below the game height and player height, then the
		// player dies
		if (y > Game.HEIGHT + height)
			dead = true;

		Collision(object);
		playerwalk.runAnimation();
		playerwalkleft.runAnimation();

	}

	/**
	 * Detects Collision with GameObjects. If with an enemy or fire, the player
	 * dies. If colliding with a block, sets the player in the position next to
	 * the block so they cannot move through it. If colliding with the end, it
	 * switches the game level through the handler.
	 * 
	 * @param objectlist
	 *            GameObject list
	 */
	private void Collision(LinkedList<GameObject> objectlist) {
		for (int i = 0; i < handler.objectlist.size(); i++) {
			GameObject tempObject = handler.objectlist.get(i);
			// Runs into Enemy/Fire
			if (tempObject.getId() == ObjectId.Enemy
					|| tempObject.getId() == ObjectId.Fire) {
				if (getBoundsRight().intersects(tempObject.getBounds())) {
					dead = true;
				}

			}
			// Runs into Block
			if (tempObject.getId() == ObjectId.Block) {
				if (getBoundsTop().intersects(tempObject.getBounds())) {
					// if the below line is commented out, doesn't seem to
					// reproduce the bug where the player goes through a block
					// and dies but potentially introduces a new bug, where the
					// player can get stuck if touching a block above

					y = tempObject.getY() + height / 2;
					velY = 0;
				}

				if (getBounds().intersects(tempObject.getBounds())) {
					y = tempObject.getY() - height;
					velY = 0;
					falling = true;
					jumping = false;
				} else
					falling = true;

				if (getBoundsRight().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - width;
				}

				if (getBoundsLeft().intersects(tempObject.getBounds())) {
					x = tempObject.getX() + tempObject.getWidth();
				}

			}
			// Runs into End of Level
			if (tempObject.getId() == ObjectId.End) {
				// switch levels
				if (getBounds().intersects(tempObject.getBounds()))
					handler.switchLevel();
			}

		}
	}

	@Override
	public void render(Graphics g) {

		if (velX != 0) {
			if (direction == ObjectId.Left)
				playerwalkleft.drawAnimation(g, x, y, width, height);

			else
				playerwalk.drawAnimation(g, x, y, width, height);
		} else if (direction == ObjectId.Left)
			g.drawImage(tex.player[2], x, y, width, height, null);
		else
			g.drawImage(tex.player[1], x, y, width, height, null);
	}

	/**
	 * Creates a Rectangle representing the bottom part of the player
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x + (width / 2) - ((width / 4)), y + (height / 2),
				width / 2, height / 2);

	}

	/**
	 * Creates a Rectangle representing the top of the player.
	 * 
	 * @return A Rectangle
	 */
	public Rectangle getBoundsTop() {
		return new Rectangle(x + (width / 2) - (width / 4), y + 5, width / 2,
				height / 2);

	}

	/**
	 * Creates a Rectangle representing the Right of the player.
	 * 
	 * @return a Rectangle
	 */
	public Rectangle getBoundsRight() {
		return new Rectangle(x + width - 5, y, 5, height);

	}

	/**
	 * Creates a Rectangle representing the Left of the player.
	 * 
	 * @return a Rectangle
	 */
	public Rectangle getBoundsLeft() {
		return new Rectangle(x, y + 5, 5, height - 10);

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
