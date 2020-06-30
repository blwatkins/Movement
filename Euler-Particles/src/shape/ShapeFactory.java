package shape;

import processing.core.PApplet;

public class ShapeFactory {
    private final int CIRCLE = 0;
    private final int POLYGON = 1;
    private final int STAR = 2;
    private final int RANDOMPOLYGONS = 3;
    private final int RANDOMSTARS = 4;
    private PApplet p;
    private int type;
    private int sides;

    public ShapeFactory(PApplet p) {
        this.p = p;
    }

    public Shape getShape() {
        Shape shape;

        switch (type) {
            case POLYGON:
                shape = new Polygon(p, sides);
                break;
            case STAR:
                shape = new Star(p, sides);
                break;
            case RANDOMPOLYGONS:
                shape = new Polygon(p);
                break;
            case RANDOMSTARS:
                shape = new Star(p);
                break;
            default:
                shape = new Circle(p);
                break;
        }

        return shape;
    }

    public void randomize() {
        int r = (int)p.random(500);

        switch (r % 5) {
            case 1:
                type = POLYGON;
                break;
            case 2:
                type = STAR;
                break;
            case 3:
                type = RANDOMPOLYGONS;
                break;
            case 4:
                type = RANDOMSTARS;
                break;
            default:
                type = CIRCLE;
                break;
        }

        sides = (int)p.random(3, 12);
    }
}
