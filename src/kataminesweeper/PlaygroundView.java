package kataminesweeper;

/**
 * @author Kai Hempel
 */
public class PlaygroundView extends AbstractPlaygroundView {

    /**
     * Constructor
     *
     * @param playground
     */
    public PlaygroundView(Playground playground) {
        super(playground);
    }

    /**
     * 
     */
    @Override
    protected void renderOutputString() {

        Field[][] playfield;
        String output;

        playfield = this.playground.getPlayground();

        for (int x = 0; x < this.playground.getWidth(); x++) {
            for (int y = 0; y < this.playground.getHeight(); y++) {

                if (this.playground.hasBomb(x, y)) {
                    this.playfieldViewData += "*";
                } else {
                    this.playfieldViewData += ".";
                }
            }

            this.playfieldViewData += "\n";
        }
    }
}
