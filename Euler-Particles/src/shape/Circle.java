package shape;

import processing.core.PApplet;
import processing.core.PVector;

public class Circle extends RadialShape {

    public Circle(PApplet p) {
        super(p);
    }

    public void display() {
        PApplet p = getPApplet();
        PVector position = getPosition();
        p.noStroke();
        p.fill(getColor());
        p.pushMatrix();
        p.translate(position.x, position.y);
        p.ellipse(0, 0, getRadius() * 2, getRadius() * 2);
        p.popMatrix();
    }
}
