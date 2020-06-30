package shape;

import processing.core.PApplet;
import processing.core.PVector;

public class Star extends Polygon {

    public Star(PApplet p) {
        super(p);
        int points = (int)p.random(4, 12);
        initVertices(points);
    }

    public Star(PApplet p, int points) {
        super(p, points);
    }

    protected void initVertices(int points) {
        float theta = 0;
        PApplet p = getPApplet();
        points = PApplet.constrain(points, 3, 20);
        PVector[] vertices = new PVector[points * 2];
        float deltaTheta = p.TWO_PI / (points * 2);

        for (int i = 0; i < vertices.length; i++) {
            float r = getRadius();

            if (i % 2 == 0) {
                r /= 2;
            }

            float x = PApplet.cos(theta) * r;
            float y = PApplet.sin(theta) * r;
            theta += deltaTheta;
            vertices[i] = new PVector(x, y);
        }

        setVertices(vertices);
    }
}
