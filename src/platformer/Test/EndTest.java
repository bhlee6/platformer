package platformer.Test;

import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import platformer.ObjectId;
import platformer.gameobjects.End;

public class EndTest {
	End e1;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.e1 = new End(100, 100, ObjectId.End);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetBounds() {
		assertEquals(e1.getBounds(), new Rectangle(100, 50, 50, 100));
	}

	@Test
	public void testGetWidth() {
		assertEquals(e1.getWidth(), 50);
	}

}
