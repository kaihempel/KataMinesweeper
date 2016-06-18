package kataminesweeper;

/**
 * Field class
 *
 * @author Kai Hempel
 */
public class Field {

    int counter = 0;
    boolean hasBomb = false;

    public Field() {
    }

    public Field(boolean hasBomb) {
        this.hasBomb = hasBomb;
    }

    public boolean hasBomb() {
        return this.hasBomb;
    }

    public boolean isEmpty() {
        return (this.hasBomb == false);
    }

    public void setBomb() {
        this.hasBomb = true;
    }

    public int getCounter() {
        return this.counter;
    }

    public void incrementCounter() {
        this.counter++;
    }
}
