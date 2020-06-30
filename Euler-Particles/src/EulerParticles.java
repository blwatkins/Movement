import processing.core.PApplet;

import shape.Shape;
import shape.ShapeFactory;

public class EulerParticles extends PApplet {
    Shape[] shapes;
    ShapeFactory shapeFactory;

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

        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = shapeFactory.getShape();
        }
    }

    public void draw() {
        background(0);

        for (Shape s: shapes) {
            s.display();
            s.move();
        }
    }
}
