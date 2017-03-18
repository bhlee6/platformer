package platformer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import platformer.gameobjects.GameObject;
import platformer.gameobjects.Weapon;
import platformer.images.BufferedImageLoader;
import platformer.images.Texture;

public class Game extends Canvas implements Runnable {

	// Class can be serialized (converted to format/bytes for storage and
	// reconstructed later to another computer environment)
	private static final long serialVersionUID = 7106137843682525935L;

	private boolean running = false;
	private Thread thread;
	public static int WIDTH, HEIGHT;
	// Number of Buffer Strategy
	public int bufferstrategy = 3;

	// Levels
	public BufferedImage level1 = null, level2 = null, background = null;
	public static int LEVEL = 1;

	// Set background color
	public Color backgroundcolor = new Color(0, 255, 238);

	// Initialize Objects
	Handler handler; // contains game objects
	Camera cam; // camera
	static Texture tex; // textures

	/**
	 * Initializes game components
	 */
	private void init() {
		// Gets Width and height of the window
		WIDTH = getWidth();
		HEIGHT = getHeight();
		tex = new Texture();

		BufferedImageLoader loader = new BufferedImageLoader();
		level1 = loader.loadImage("/level.png");// loads level 1
		background = loader.loadImage("/background.png");// loads background

		cam = new Camera(0, 0);
		handler = new Handler(cam);
		handler.LoadImageLevel(level1);
		this.addKeyListener(new KeyInput(handler));

	}

	/**
	 * Sets the game running to be true, and starts the thread
	 */
	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * Ends the game and exits with a game over message
	 */
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "You have died!", "Game Over",
				JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	// When an object implementing interface Runnable is used to create a
	// thread, starting the thread causes the object's run method to be called
	// in that separately executing thread.

	@Override
	public void run() {
		init();
		// brings the game to focus (front)
		this.requestFocus();

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		// game loop, keeps looping until the end of game
		// controls how fast the game updates, based on the system time
		// rather than the execution of loops
		// (number of ticks per second is 60)
		while (running) {
			// how long since the last update, and the tick
			//
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;

			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			// draws the components (render is called often), but updated at 60
			// ticks
			render();
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}
		}
	}

	/**
	 * Updates the GameObjects in the game
	 * 
	 */
	private void tick() {
		// ticks all GameObjects in handler
		handler.tick();
		// Player
		for (int i = 0; i < handler.objectlist.size(); i++) {
			GameObject tempObject = handler.objectlist.get(i);
			if (tempObject.getId() == ObjectId.Player) {
				// ticks for the camera
				cam.tick(handler.objectlist.get(i));

				// game over for player death
				if (tempObject.isDead()) {
					gameOver();
				}
				// remove weapon if passes the screen
				for (int i1 = 0; i1 < handler.lw.size(); i1++) {
					Weapon weap = handler.lw.get(i1);
					if (weap.x > tempObject.x + WIDTH / 2 + 100
							|| weap.x < tempObject.x - WIDTH / 2 + 100)
						handler.removeWeapon(weap);
				}
			}
			// If a GameObject is dead, remove
			if (tempObject.isDead())
				handler.removeObject(tempObject);
		}

	}

	/**
	 * Creates a buffer strategy for the game, and Draws the images of the game
	 * 
	 */
	private void render() {
		// Buffers the next image if the process has time, this extends Canvas
		// Creates multiple images
		BufferStrategy bs = this.getBufferStrategy();
		// buffer starts null
		if (bs == null) {
			this.createBufferStrategy(bufferstrategy);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;

		// Draws inside the window
		g2d.setColor(backgroundcolor); // Sets background window color (sky
										// color
										// set)
		g2d.fillRect(0, 0, getWidth(), getHeight()); // Fills the window

		// CAMERA
		// Translates the origin of the Graphics2D context to the point (x, y)
		// in the current coordinate system. Modifies the Graphics2D context so
		// that its new origin corresponds to the point (x, y) in the Graphics2D
		// context's former coordinate system. All coordinates used in
		// subsequent rendering operations on this graphics context are relative
		// to this new origin.

		g2d.translate(cam.getX(), cam.getY()); // begin cam
		g.drawImage(background, 0, 90, this);
		handler.render(g);

		// clears
		g.dispose();

		// buffer just drawn becomes current buffer for the JFrame
		bs.show();
	}

	/**
	 * Grabs the texture
	 * 
	 * @return Texture
	 */
	public static Texture getTexture() {
		return tex;
	}

	/**
	 * Main Adds the window, and runs Game
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		new Window(800, 600, "Adventure Game", new Game());
	}

}
