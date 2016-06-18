package kataminesweeper;

import java.io.ByteArrayOutputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Kai Hempel
 */
public class PlaygroundInternalViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public PlaygroundInternalViewTest() {
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
        Playground playground       = this.getPlayground();
        PlaygroundInternalView view = new PlaygroundInternalView(playground);
        view.draw();

    }

}
