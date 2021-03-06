package shape;

import processing.core.PApplet;
import processing.core.PVector;

import color.Color;

public abstract class Shape {
    private PApplet p;
    private PVector position;
    private PVector speed;
    private Color color;

    public Shape(PApplet p) {
        this.p = p;
        position = new PVector(p.random(p.width), p.random(p.height));
        speed = new PVector(p.random(-5, 5), p.random(-5, 5));
        color = new Color(p, p.color(0, 0, 255));
    }

    public PApplet getPApplet() {
        return p;
    }

    public PVector getPosition() {
        return position;
    }

    public PVector getSpeed() {
        return speed;
    }

    public int getColor() {
        return color.getColor();
    }

    public void setPosition(PVector position) {
        this.position = position.copy();
    }

    public void setColor(int color) {
        this.color.setColor(color);
    }

    public abstract void display();

    public void move() {
        position.add(speed);
        bounce();
    }

    protected abstract void bounce();
}
