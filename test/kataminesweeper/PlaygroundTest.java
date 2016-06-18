/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kataminesweeper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erosol
 */
public class PlaygroundTest {

    public PlaygroundTest() {
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
    public void testEmptyPlayground() {
        Playground playground = new Playground(0, 0);

        assertTrue(playground.isEmpty());
        assertEquals(0, playground.getWidth());
        assertEquals(0, playground.getHeight());
    }

    @Test
    public void testFourByFourPlayground() {

        Playground playground = new Playground(4, 4);

        assertFalse(playground.isEmpty());
        assertEquals(4, playground.getWidth());
        assertEquals(4, playground.getHeight());
    }

    @Test
    public void testHasBomb() {

        Playground playground = new Playground(4, 4);

        assertFalse(playground.isEmpty());
        assertEquals(4, playground.getWidth());
        assertEquals(4, playground.getHeight());

        playground.initialzePlayground();
        
        assertFalse(playground.hasBomb(0,0));

        playground.setBomb(0,0);

        assertTrue(playground.hasBomb(0,0));
    }
}
