/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kataminesweeper;

/**
 *
 * @author erosol
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
