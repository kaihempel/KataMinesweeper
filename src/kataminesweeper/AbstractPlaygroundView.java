package kataminesweeper;

/**
 * @author Kai Hempel
 */
abstract public class AbstractPlaygroundView {

    protected Playground playground;

    protected String playfieldViewData;

    public AbstractPlaygroundView(Playground playground) {
        this.playground = playground;
        this.playfieldViewData = "";
    }

    abstract protected void renderOutputString();

    public void draw() {
        this.renderOutputString();
        System.out.print(playfieldViewData);
    }
}
