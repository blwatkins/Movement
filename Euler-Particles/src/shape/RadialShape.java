package shape;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class RadialShape extends Shape{
    private float radius;

    public RadialShape(PApplet p) {
        super(p);
        radius = p.random(5, 50);
        setPosition(new PVector(p.random(radius, p.width - radius), p.random(radius, p.height - radius)));
    }

    public float getRadius() {
        return radius;
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
