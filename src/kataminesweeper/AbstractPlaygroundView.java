package kataminesweeper;

/**
 * @author Kai Hempel
 */
abstract public class AbstractPlaygroundView {

    Playground playground;

    public AbstractPlaygroundView(Playground playground) {
        this.playground = playground;
    }

    abstract public void draw();
}
