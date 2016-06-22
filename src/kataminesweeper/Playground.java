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

    public Playground(int width, int height) {
        this.width      = width;
        this.height     = height;
        this.playground = new Field[width][height];
    }

    public void initialzePlayground() {
        Boolean placeBombs = true;
        this.initialzePlayground(placeBombs);
    }

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

    private int calculateNumberOfBombs() {
        int divisor;
        if (this.width < this.height) {
            divisor = this.width;
        } else {
            divisor = this.height;
        }

        return Math.round((this.width + this.height) / divisor);
    }

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

    private void updateFieldCounters(int x, int y) {

        int startX  = this.getUpdateStartPosition(x);
        int endX    = this.getUpdateEndPosition(x);
        int startY  = this.getUpdateStartPosition(y);
        int endY    = this.getUpdateEndPosition(y);

        this.incrementFieldCounterInRange(startX, startY, endX, endY);
    }

    private int getUpdateStartPosition(int pos) {

        if (pos == 0) {
            return 0;
        }

        return pos - 1;
    }

    private int getUpdateEndPosition(int pos) {
        int endPos = pos + 1;

        if (endPos >= this.width) {
            return pos;
        }

        return endPos;
    }

    private void incrementFieldCounterInRange(int startX, int startY, int endX, int endY) {

        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {

                if (! this.hasBomb(x, y)) {
                    this.playground[x][y].incrementCounter();
                }
            }
        }
    }

    public boolean isEmpty() {
        return (this.width == 0 || this.height == 0);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean hasBomb(int x, int y) {
        return this.playground[x][y].hasBomb();
    }

    public void setBomb(int x, int y) {
        if (! this.isEmpty() && this.playground[x][y] != null) {
            this.playground[x][y].setBomb();
            this.updateFieldCounters(x, y);
        }
    }

    public Field[][] getPlayground() {
        return this.playground;
    }

    public int getFieldCounter(int x, int y) throws Exception {

        if (this.playground[x][y].hasBomb()) {
            throw new Exception("Booom!");
        }

        return this.playground[x][y].getCounter();
    }
}
