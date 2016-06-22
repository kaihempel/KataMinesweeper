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

            if (this.playground[x][y].hasBomb() == false) {
                this.playground[x][y].setBomb();
                numberOfBombs--;
            }
        } while (numberOfBombs > 0);
    }

    private void updateFieldValue(int x, int y) {

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
