package kataminesweeper;

import java.util.Random;

/**
 * Playground class
 *
 * @author Kai Hempel
 */
public class Playground {

    int width = 0;
    int height = 0;

    Field[][] playground;

    /**
     * Constructor
     *
     * @param width
     * @param height
     */
    public Playground(int width, int height) {
        this.width      = width;
        this.height     = height;
        this.playground = new Field[width][height];
    }

    /**
     * Initialize the playground.
     * Bombs will placed randomly!
     */
    public void initialzePlayground() {
        Boolean placeBombs = true;
        this.initialzePlayground(placeBombs);
    }

    /**
     * Initialize the playground.
     * Bomb placement can deactivated!
     *
     * @param placeBombs
     */
    public void initialzePlayground(Boolean placeBombs) {

        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                this.playground[x][y] = new Field();
            }
        }

        if (placeBombs) {
            this.placeBombs();
        }
    }

    /**
     * Calculates the number of bombs based on the field size.
     *
     * @return Maximum number of bombs
     */
    private int calculateNumberOfBombs() {
        int divisor;
        if (this.width < this.height) {
            divisor = this.width;
        } else {
            divisor = this.height;
        }

        return Math.round((this.width + this.height) / divisor);
    }

    /**
     * Set the bombs on random positions
     */
    private void placeBombs() {
        int numberOfBombs = this.calculateNumberOfBombs();
        int x = 0;
        int y = 0;
        Random rand = new Random();

        do {
            x = rand.nextInt(this.width);
            y = rand.nextInt(this.height);

            if (this.hasBomb(x, y) == false) {
                this.setBomb(x, y);
                numberOfBombs--;
            }
        } while (numberOfBombs > 0);
    }

    /**
     * Updates the field counters of all neighbour fields of the placed bomb
     *
     * @param x
     * @param y
     */
    private void updateFieldCounters(int x, int y) {

        int startX  = this.getUpdateStartPosition(x);
        int endX    = this.getUpdateEndPosition(x);
        int startY  = this.getUpdateStartPosition(y);
        int endY    = this.getUpdateEndPosition(y);

        this.incrementFieldCounterInRange(startX, startY, endX, endY);
    }

    /**
     * Returns the start position for counter update
     *
     * @param pos
     * @return Start position; Zero is the minimal start position
     */
    private int getUpdateStartPosition(int pos) {
        if (pos == 0) {
            return 0;
        }

        return pos - 1;
    }

    /**
     * Returns the end position for counter update
     *
     * @param pos
     * @return End position
     */
    private int getUpdateEndPosition(int pos) {
        int endPos = pos + 1;

        if (endPos >= this.width) {
            return pos;
        }

        return endPos;
    }

    /**
     * Increments the counter of all bombfree fields
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    private void incrementFieldCounterInRange(int startX, int startY, int endX, int endY) {

        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {

                if (! this.hasBomb(x, y)) {
                    this.playground[x][y].incrementCounter();
                }
            }
        }
    }

    /**
     * Checks if the playfield size is zero
     *
     * @return True if playground size is zero
     */
    public boolean isEmpty() {
        return (this.width == 0 || this.height == 0);
    }

    /**
     * Returns the width
     *
     * @return Playground width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height
     *
     * @return Playground height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Checks if the field has a bomb
     *
     * @param x
     * @param y
     * @return True if the field has a bomb
     */
    public boolean hasBomb(int x, int y) {
        return this.playground[x][y].hasBomb();
    }

    /**
     * Place a bomb on the given position
     *
     * @param x
     * @param y
     */
    public void setBomb(int x, int y) {
        if (! this.isEmpty() && this.playground[x][y] != null) {
            this.playground[x][y].setBomb();
            this.updateFieldCounters(x, y);
        }
    }

    /**
     * Returns the playground data array
     *
     * @return Playground array
     */
    public Field[][] getPlayground() {
        return this.playground;
    }

    /**
     * Returns the field counter
     *
     * @param x
     * @param y
     * @return Number of bombs in the neighbourhood
     * @throws Exception
     */
    public int getFieldCounter(int x, int y) throws Exception {

        if (this.playground[x][y].hasBomb()) {
            throw new Exception("Booom!");
        }

        return this.playground[x][y].getCounter();
    }
}
