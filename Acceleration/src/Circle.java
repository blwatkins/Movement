import processing.core.PApplet;
import processing.core.PVector;

import color.Color;

public class Circle {
    private PApplet p;
    private PVector position;
    private PVector speed;
    private PVector acceleration;
    private Color color;
    private float radius;
    private float maxSpeed;
    private float maxAcceleration;
    private float deltaAcceleration;

    public Circle(PApplet p) {
        this.p = p;
        radius = 5;
        position = new PVector(p.random(radius, p.width - radius), p.random(radius, p.height - radius));
        speed = new PVector(p.random(-5, 5), p.random(-5, 5));
        acceleration = new PVector(0, 0);
        color = new Color(p, p.color(0, 0, 255));
        maxSpeed = 8;
        maxAcceleration = 0.5f;
        deltaAcceleration = 0.2f;
    }

    public void setColor(int color) {
        this.color.setColor(color);
    }

    public void display() {
        p.fill(color.getColor());
        p.noStroke();
        p.ellipse(position.x, position.y, radius * 2, radius * 2);
    }

    public void move() {
        incrementVectors();
        constrainVectors();
        bounce();
    }

    private void incrementVectors() {
        position.add(speed);
        speed.add(acceleration);
        float deltaAccelerationX = p.random(-deltaAcceleration, deltaAcceleration);
        float deltaAccelerationY = p.random(-deltaAcceleration, deltaAcceleration);
        acceleration.add(new PVector(deltaAccelerationX, deltaAccelerationY));
    }

    private void constrainVectors() {
        constrainVector(speed, -maxSpeed, maxSpeed);
        constrainVector(acceleration, -maxAcceleration, maxAcceleration);
    }

    private void constrainVector(PVector vector, float minValue, float maxValue) {
        float x = PApplet.constrain(vector.x, minValue, maxValue);
        float y = PApplet.constrain(vector.y, minValue, maxValue);
        vector.set(x, y);
    }

    private void bounce() {
        if (position.x + radius >= p.width || position.x - radius <= 0) {
            speed.x *= -1;
            position.x = PApplet.constrain(position.x, radius, p.width - radius);
        }

        if (position.y + radius >= p.height || position.y - radius <= 0) {
            speed.y *= -1;
            position.y = PApplet.constrain(position.y, radius, p.height - radius);
        }
    }
}
