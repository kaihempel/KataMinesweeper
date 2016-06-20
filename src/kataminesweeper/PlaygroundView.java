package kataminesweeper;

/**
 * @author Kai Hempel
 */
public class PlaygroundView extends AbstractPlaygroundView {

    public PlaygroundView(Playground playground) {
        super(playground);
    }

    protected void renderOutputString() {
        Field[][] playfield;
        playfield = this.playground.getPlayground();

        for (int x = 0; x < this.playground.getWidth(); x++) {
            for (int y = 0; y < this.playground.getHeight(); y++) {

            }
        }
    }
}
