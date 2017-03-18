package platformer.Test;

import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import platformer.ObjectId;
import platformer.gameobjects.Block;

public class BlockTest {

	Block b1;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.b1 = new Block(100, 100, 0, ObjectId.Block);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetBounds() {
		assertEquals(b1.getBounds(), new Rectangle(100, 100, 32, 32));
	}

	@Test
	public void testGetWidth() {
		assertEquals(b1.getWidth(), 32);
	}

	@Test
	public void testIsDead() {
		assertEquals(b1.isDead(), false);
	}

}
