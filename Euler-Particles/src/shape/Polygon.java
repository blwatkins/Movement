package shape;

import processing.core.PApplet;
import processing.core.PVector;

public class Polygon extends RadialShape {
    private PVector[] vertices;

    public Polygon(PApplet p) {
        super(p);
        int sides = (int)p.random(3, 12);
        initVertices(sides);
    }

    public Polygon(PApplet p, int sides) {
        super(p);
        initVertices(sides);
    }

    protected void initVertices(int sides) {
        PApplet p = getPApplet();
        float theta = 0;
        sides = PApplet.constrain(sides, 3, 20);
        vertices = new PVector[sides];
        float deltaTheta = PApplet.TWO_PI / sides;

        for (int i = 0; i < sides; i++) {
            float x = PApplet.cos(theta) * getRadius();
            float y = PApplet.sin(theta) * getRadius();
            theta += deltaTheta;
            vertices[i] = new PVector(x, y);
        }
    }

    protected void setVertices(PVector[] vertices) {
        this.vertices = new PVector[vertices.length];
        System.arraycopy(vertices, 0, this.vertices, 0, vertices.length);
    }

    public void display() {
        PApplet p = getPApplet();
        PVector position = getPosition();
        p.noStroke();
        p.fill(getColor());
        p.pushMatrix();
        p.translate(position.x, position.y);
        p.beginShape();

        for (PVector vertex: vertices) {
            p.vertex(vertex.x, vertex.y);
        }

        p.endShape(p.CLOSE);
        p.popMatrix();
    }
}
