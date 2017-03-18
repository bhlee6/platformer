package platformer.images;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Brian
 *
 */
public class BufferedImageLoader {

	/**
	 * A BufferedImage
	 */
	private BufferedImage image;

	/**
	 * Grabs an image from the specified path, and returns the image
	 * 
	 * @param path
	 *            location of an image
	 * @return the image from the path
	 */
	public BufferedImage loadImage(String path) {
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

}
