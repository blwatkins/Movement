import processing.core.PApplet;
import processing.core.PVector;

import color.Color;

public class Circle {
    private PApplet p;
    private PVector position;
    private PVector velocity;
    private float radius;
    private float mass;
    private Color color;

    public Circle(PApplet p) {
        this.p = p;
        radius = p.random(5, 100);
        mass = radius;
        position = new PVector(p.random(radius, p.width - radius), p.random(radius, p.height - radius));
        velocity = new PVector(p.random(-5, 5), p.random(-5, 5));
        color = new Color(p, p.color(0, 0, 255));
    }
}
