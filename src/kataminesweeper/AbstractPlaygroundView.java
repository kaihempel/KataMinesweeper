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
abstract public class AbstractPlaygroundView {

    Playground playground;

    public AbstractPlaygroundView(Playground playground) {
        this.playground = playground;
    }
    
    abstract public void draw();
}
