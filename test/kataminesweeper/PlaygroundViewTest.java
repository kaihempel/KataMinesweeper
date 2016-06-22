package kataminesweeper;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Kai Hempel
 */
public class PlaygroundViewTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public PlaygroundViewTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterClass
    public static void tearDownClass() {
        System.setOut(null);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    private Playground getPlayground() {
        Playground playground = new Playground(4,4);
        playground.initialzePlayground();

        return playground;
    }
    /**
     * Test of draw method, of class PlaygroundInternalView.
     */
    @Test
    public void testDraw() {
        Playground playground   = this.getPlayground();
        PlaygroundView view     = new PlaygroundView(playground);
        view.draw();

        String pattern = "^[\\.\\*]{4}\n[\\.\\*]{4}\n[\\.\\*]{4}\n[\\.\\*]{4}\n$";
        String output = outContent.toString();

        assertTrue(output.matches(pattern));
    }

}