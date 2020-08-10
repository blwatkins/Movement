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

    public void display() {
        p.noStroke();
        p.fill(color.getColor());
        p.ellipse(position.x, position.y, radius * 2, radius * 2);
    }

    public void move() {
        incrementVectors();
        bounce();
    }

    private void incrementVectors() {
        position.add(velocity);
    }

    private void bounce() {

        if (position.x + radius >= p.width || position.x - radius <= 0) {
            velocity.x *= -1;
            position.x = PApplet.constrain(position.x, 0, p.width);
        }

        if (position.y + radius >= p.height || position.y - radius <= 0) {
            velocity.y *= -1;
            position.y = PApplet.constrain(position.y, 0, p.height);
        }
    }
}
