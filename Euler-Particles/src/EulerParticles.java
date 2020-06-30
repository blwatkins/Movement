import processing.core.PApplet;

import shape.Circle;
import shape.Polygon;
import shape.Shape;

public class EulerParticles extends PApplet {
    Shape[] shapes;

    public static void main(String[] args) {
        String[] processingArgs = {"EulerParticles"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        shapes = new Shape[100];

        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = new Polygon(this);
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
