package platformer.images;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {

	private int speed;
	private int frames;

	private int index = 0;
	private int count = 0;

	private BufferedImage[] images;
	private BufferedImage currentImg;

	/**
	 * Class to represent an animation which cycles through the given images at
	 * a given speed.
	 * 
	 * @param speed
	 *            the rate at which the frames change
	 * @param args
	 *            the buffered images
	 */
	public Animation(int speed, BufferedImage... args) {
		this.speed = speed;
		images = new BufferedImage[args.length];
		for (int i = 0; i < args.length; i++) {
			images[i] = args[i];
		}
		frames = args.length;
	}

	/**
	 * Increments the index, and if index is greater than speed, and resets the
	 * index and calls nextFrame
	 */
	public void runAnimation() {
		index++;
		if (index > speed) {
			index = 0;
			nextFrame();
		}

	}

	/**
	 * Goes through the images and cycles through
	 * 
	 */
	public void nextFrame() {
		if (count < frames) {
			currentImg = images[count];
			count++;
		} else {
			count = 0;
		}

	}

	/**
	 * Draws the image at the x and y coordinates
	 * 
	 * @param g
	 *            graphic
	 * @param x
	 *            x coord
	 * @param y
	 *            y coord
	 */
	public void drawAnimation(Graphics g, int x, int y) {
		g.drawImage(currentImg, x, y, null);
	}

	/**
	 * Draws graphics except to scale the image according to given scaling x/y
	 * 
	 * @param g
	 *            graphic
	 * @param x
	 *            x coord
	 * @param y
	 *            y coord
	 * @param scaleX
	 *            x scale
	 * @param scaleY
	 *            y scale
	 */
	public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY) {
		g.drawImage(currentImg, x, y, scaleX, scaleY, null);
	}
}
