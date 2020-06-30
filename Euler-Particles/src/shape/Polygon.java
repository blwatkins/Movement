package shape;

import processing.core.PApplet;
import processing.core.PVector;

public class Polygon extends Shape {
    private float radius;

    public Polygon(PApplet p) {
        super(p);
        setPosition(new PVector(p.random(radius, p.width - radius), p.random(radius, p.height - radius)));
    }

    public void display() {

    }

    protected void bounce() {
        PApplet p = getPApplet();
        PVector position = getPosition();
        PVector speed = getSpeed();

        if (position.x + radius >= p.width || position.x - radius <= 0) {
            speed.x *= -1;
        }

        if (position.y + radius >= p.height || position.y - radius <= 0) {
            speed.y *= -1;
        }
    }
}
