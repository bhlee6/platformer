package platformer.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import platformer.Camera;
import platformer.Handler;
import platformer.ObjectId;
import platformer.gameobjects.Player;

public class PlayerTest {

	Player p1;
	Handler h1;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.h1 = new Handler(new Camera(100, 100));
		new Player(100, 100, h1, ObjectId.Player);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTick() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBounds() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWidth() {
		assertEquals(p1.getWidth(), 48);
	}

	@Test
	public void testIsDead() {
		assertEquals(p1.isDead(), false);
	}

	@Test
	public void testGetBoundsTop() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBoundsRight() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBoundsLeft() {
		fail("Not yet implemented");
	}

}
