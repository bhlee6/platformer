package platformer.Test;

import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import platformer.ObjectId;
import platformer.gameobjects.Fire;

public class FireTest {

	Fire f1;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.f1 = new Fire(100, 100, 0, ObjectId.Fire);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetBounds() {
		assertEquals(f1.getBounds(), new Rectangle(100, 100, 32, 32));
	}

	@Test
	public void testGetWidth() {
		assertEquals(f1.getWidth(), 32);
	}

	@Test
	public void testIsDead() {
		assertEquals(f1.isDead(), false);
	}

}
