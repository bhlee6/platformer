package platformer.images;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage image;

	/**
	 * Create a SpriteSheet from a Buffered Image.
	 * 
	 * @param image
	 */
	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}

	/**
	 * Pulls a subimage from the specified region.
	 * 
	 * @param col
	 *            representing the column
	 * @param row
	 *            representing the row
	 * @param width
	 *            width of the region
	 * @param height
	 *            height of the region
	 * @return the subImage as a Buffered Image
	 * 
	 */
	public BufferedImage grabImage(int col, int row, int width, int height) {
		// Subimage:
		// Returns a subimage defined by a specified rectangular region. The
		// returned BufferedImage shares the same data array as the original
		// image.
		BufferedImage img = image.getSubimage((col * width) - width,
				(row * height) - height, width, height);
		return img;
	}

}
