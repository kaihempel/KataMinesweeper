package kataminesweeper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Kai Hempel
 */
public class FieldTest {

    public FieldTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testEmptyField() {
        Field field = new Field();

        assertFalse(field.hasBomb());
        assertTrue(field.isEmpty());
    }

    @Test
    public void testBombField() {
        Field field = new Field(true);

        assertTrue(field.hasBomb());
        assertFalse(field.isEmpty());
    }

    @Test
    public void testSetBomb() {
        Field field = new Field();

        assertFalse(field.hasBomb());
        assertTrue(field.isEmpty());

        field.setBomb();

        assertTrue(field.hasBomb());
        assertFalse(field.isEmpty());
    }

    @Test
    public void testCounter() {
        Field field = new Field();

        assertEquals(0, field.getCounter());

        field.incrementCounter();

        assertEquals(1, field.getCounter());

        field.incrementCounter();

        assertEquals(2, field.getCounter());
    }
}