import processing.core.PApplet;

import shape.Shape;
import shape.ShapeFactory;

public class EulerParticles extends PApplet {
    Shape[] shapes;
    ShapeFactory shapeFactory;
    boolean hasBlackBackground;
    boolean showTrails;

    public static void main(String[] args) {
        String[] processingArgs = {"EulerParticles"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        shapeFactory = new ShapeFactory(this);
        shapes = new Shape[100];
        hasBlackBackground = true;
        showTrails = false;

        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = shapeFactory.getShape();
        }
    }

    public void draw() {
        displayBackground();
        displayShapes();
    }

    public void keyPressed() {

        if (key == 'a') {
            hasBlackBackground = !hasBlackBackground;
        } else if (key == 's') {
            showTrails = !showTrails;
        }
    }

    private void displayBackground() {
        int color;

        if (hasBlackBackground) {
            color = color(0);
        } else {
           color = color(255);
        }

        if (showTrails) {
            fill(color, 25);
            rect(-10, -10, width + 10, height + 10);
        } else {
            background(color);
        }
    }

    private void displayShapes() {

        for (Shape s: shapes) {
            s.display();
            s.move();
        }
    }
}
