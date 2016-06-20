package kataminesweeper;

/**
 * @author Kai Hempel
 */
abstract public class AbstractPlaygroundView {

    Playground playground;
    String outputString;

    public AbstractPlaygroundView(Playground playground) {
        this.playground = playground;
        this.outputString = "";
    }

    abstract protected void renderOutputString();

    public void draw() {
        this.renderOutputString();
        System.out.print(outputString);
    }
}
