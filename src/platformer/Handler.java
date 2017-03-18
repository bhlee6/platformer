package platformer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;

import platformer.gameobjects.Block;
import platformer.gameobjects.End;
import platformer.gameobjects.Enemy;
import platformer.gameobjects.Fire;
import platformer.gameobjects.GameObject;
import platformer.gameobjects.Player;
import platformer.gameobjects.Weapon;
import platformer.images.BufferedImageLoader;

/**
 * @author Brian
 */
public class Handler {

	public LinkedList<GameObject> objectlist = new LinkedList<GameObject>();
	public ArrayList<Weapon> lw = new ArrayList<Weapon>();
	private GameObject tempObject;
	private Camera cam;
	private BufferedImage level2 = null;

	/**
	 * Manages the game objects made in the game.
	 * 
	 * @param cam
	 */
	public Handler(Camera cam) {
		this.cam = cam;
		BufferedImageLoader loader = new BufferedImageLoader();
		level2 = loader.loadImage("/level2.png");// loads level 2
		// + levels
	}

	/**
	 * Tick the GameObjects
	 */
	public void tick() {
		for (int i = 0; i < objectlist.size(); i++) {
			tempObject = objectlist.get(i);
			tempObject.tick(objectlist);
		}
		for (int i = 0; i < lw.size(); i++) {
			tempObject = lw.get(i);
			tempObject.tick(objectlist);
		}

	}

	/**
	 * Draws the GameObjects
	 * 
	 * @param g
	 *            graphics
	 */
	public void render(Graphics g) {
		for (int i = 0; i < objectlist.size(); i++) {
			tempObject = objectlist.get(i);
			tempObject.render(g);
		}

		for (int i = 0; i < lw.size(); i++) {
			tempObject = lw.get(i);
			tempObject.render(g);
		}
	}

	/**
	 * Loads the Image of the level, setting certain red,blue,green (rgb) values
	 * from pixels to indicate different GameObjects, and adding the appropriate
	 * GameObjects at each specified pixel.
	 * 
	 * @param image
	 */
	public void LoadImageLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();

		for (int x = 0; x < h; x++) {
			for (int y = 0; y < w; y++) {
				// Returns an integer pixel in the default RGB color model
				// (TYPE_INT_ARGB) and default sRGB colorspace. Color conversion
				// takes place if this default model does not match the image
				// ColorModel. There are only 8-bits of precision for each color
				// component in the returned data when using this method.
				int pixel = image.getRGB(x, y);
				// pixel is an int(which has 4 bytes)
				// transparency red green blue;
				// ie 0000 0000 0xA1 0x31
				// >> is a bit shift operator, moves over the number of bits
				// & 0xff (hexadecimal) adds the bits so the FF stays with the
				// desired pixel
				// and removes transparency byte
				// 0xA131 & 0x00FF, leaves with only 31

				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;

				if (red == 255 && green == 255 && blue == 255)
					addObject(new Block(x * 32, y * 32, 0, ObjectId.Block));
				if (red == 0 && green == 0 && blue == 255) {
					addObject(new Player(x * 32, y * 32, this, ObjectId.Player));
				}
				if (red == 100 && green == 100 && blue == 100)
					addObject(new Enemy(x * 32, y * 32, this, ObjectId.Enemy));
				if (red == 255 && green == 0 && blue == 0)
					addObject(new Fire(x * 32, y * 32, 0, ObjectId.Fire));
				if (red == 255 && green == 216 && blue == 0)
					addObject(new End(x * 32, y * 32, ObjectId.End));
			}
		}
	}

	/**
	 * Clears the objects in the current level, resets the camera, and then
	 * switches the game level, and increasing the level count.
	 * 
	 */
	public void switchLevel() {
		clearLevel();
		cam.setX(0);

		switch (Game.LEVEL) {
		case 1:
			LoadImageLevel(level2);
			break;
		}
		Game.LEVEL++;
	}

	/**
	 * Clears the objects in object list
	 */
	private void clearLevel() {
		objectlist.clear();
	}

	/**
	 * Adds the GameObject to the list
	 * 
	 * @param object
	 *            a GameObject
	 */
	public void addObject(GameObject object) {
		this.objectlist.add(object);
	}

	/**
	 * Removes the GameObject from the list
	 * 
	 * @param object
	 *            a GameObject
	 */
	public void removeObject(GameObject object) {
		this.objectlist.remove(object);
	}

	/**
	 * Adds the Weapon to the list
	 * 
	 * @param weapon
	 *            a Weapon
	 */
	public void addWeapon(Weapon weapon) {
		this.lw.add(weapon);
	}

	/**
	 * Removes the Weapon from the list
	 * 
	 * @param weapon
	 *            a Weapon
	 */
	public void removeWeapon(Weapon weapon) {
		this.lw.remove(weapon);
	}

}