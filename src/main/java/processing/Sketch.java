package main.java.processing;

import processing.core.PApplet;

/**
 * Graphics and user interface handling for the project.
 * This file contains the central part of the sketch, combining everything into a final product.
 *
 * @author Nat Anderson
 * Date Last Modified: 2021-08-31
 */
public class Sketch extends PApplet {

    public void settings() {
        fullScreen();
    }

    public void draw() {

        // TODO: Everything related to graphics

    }

    public static void main(String[] args) {
        String[] processingArgs = new String[] {"Title"};
        Sketch sketch = new Sketch();
        PApplet.runSketch(processingArgs, sketch);
    }
}
