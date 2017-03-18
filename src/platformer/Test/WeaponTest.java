package platformer.Test;

import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import platformer.ObjectId;
import platformer.gameobjects.Weapon;

public class WeaponTest {

	Weapon w1;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.w1 = new Weapon(100, 100, ObjectId.Right, ObjectId.Weapon);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetBounds() {
		assertEquals(w1.getBounds(), new Rectangle(100, 100, 20, 5));
	}

	@Test
	public void testGetWidth() {
		assertEquals(w1.getWidth(), 20);
	}

	@Test
	public void testIsDead() {
		assertEquals(w1.isDead(), false);
	}

}
