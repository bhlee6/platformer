package platformer;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * @author Brian
 *
 */
public class Window {

	/**
	 * 
	 * Creates a visible window for the game at a preferred size for width and
	 * height. The window is centered on the screen, is not resizeable, and can
	 * be closed.
	 * 
	 * @param width
	 *            width of the window
	 * @param height
	 *            height of the window
	 * @param title
	 *            title of the window
	 * @param game
	 *            game instance
	 */
	public Window(int width, int height, String title, Game game) {

		// sets preferred size to constant values, stored in Dimension
		game.setPreferredSize(new Dimension(width, height));

		JFrame frame = new JFrame(title);
		frame.add(game);
		// Causes this Window to be sized to fit the preferred size and layouts
		// of its subcomponents. The resulting width and height of the window
		// are automatically enlarged if either of dimensions is less than the
		// minimum size as specified by the previous call to the setMinimumSize
		// method.
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		// centers window
		frame.setLocationRelativeTo(null);
		// shows window
		frame.setVisible(true);

		// starts game
		game.start();
	}
}
