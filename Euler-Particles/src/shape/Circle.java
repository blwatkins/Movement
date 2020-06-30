package shape;

import processing.core.PApplet;
import processing.core.PVector;

public class Circle extends Shape {
    private float radius;

    public Circle(PApplet p) {
        super(p);
        radius = p.random(10, 50);
    }

    public void display() {
        PApplet p = getPApplet();
        PVector position = getPosition();
        p.noStroke();
        p.fill(getColor());
        p.pushMatrix();
        p.translate(position.x, position.y);
        p.ellipse(0, 0, radius * 2, radius * 2);
        p.popMatrix();
    }
}
