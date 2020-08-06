import processing.core.PApplet;
import processing.core.PVector;

public class Circle {
    private PApplet p;
    private PVector position;
    private PVector speed;
    private PVector acceleration;
    private float radius;
    private float maxSpeed;
    private float maxAcceleration;
    private float deltaAcceleration;

    public Circle(PApplet p) {
        this.p = p;
        radius = 10;
        position = new PVector(p.random(radius, p.width - radius), p.random(radius, p.height - radius));
        speed = new PVector(p.random(-5, 5), p.random(-5, 5));
        acceleration = new PVector(0, 0);
        maxSpeed = 8;
        maxAcceleration = 0.5f;
        deltaAcceleration = 0.2f;
    }
}
