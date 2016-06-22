package kataminesweeper;

/**
 * Field class
 *
 * @author Kai Hempel
 */
public class Field {

    int counter = 0;
    boolean hasBomb = false;

    /**
     * Empty field constructor
     */
    public Field() {
    }

    /**
     * Bomb field constructor
     *
     * @param hasBomb
     */
    public Field(boolean hasBomb) {
        this.hasBomb = hasBomb;
    }

    /**
     * Checks if the field has a bomb
     *
     * @return True if the field has a bomb
     */
    public boolean hasBomb() {
        return this.hasBomb;
    }

    /**
     * Checks if the field is empty
     *
     * @return True if there is no bomb
     */
    public boolean isEmpty() {
        return (this.hasBomb == false);
    }

    /**
     * Place a bomb
     */
    public void setBomb() {
        this.counter = 0;
        this.hasBomb = true;
    }

    /**
     * Returns the number of bombs in the neighbourhood
     *
     * @return Number of bombs near to this field
     */
    public int getCounter() {
        return this.counter;
    }

    /**
     * Increase the counter
     */
    public void incrementCounter() {
        this.counter++;
    }
}
