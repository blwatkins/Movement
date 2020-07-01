// Particle Generator
// Press 'a' to change background to black or white
// Press 's' to activate fading trails
// Press 'd' to change color scheme
// Press 'f' to save the frame

import processing.core.PApplet;

import color.ColorGenerator;
import color.ColorGeneratorFactory;
import shape.Shape;
import shape.ShapeFactory;

public class EulerParticles extends PApplet {
    private Shape[] shapes;
    private ShapeFactory shapeFactory;
    private ColorGeneratorFactory colorGeneratorFactory;
    private ColorGenerator colorGenerator;
    private boolean hasBlackBackground;
    private boolean showTrails;

    public static void main(String[] args) {
        String[] processingArgs = {"EulerParticles"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        shapeFactory = new ShapeFactory(this);
        colorGeneratorFactory = new ColorGeneratorFactory(this);
        colorGenerator = colorGeneratorFactory.getRandomColorGenerator();
        shapes = new Shape[100];
        hasBlackBackground = true;
        showTrails = false;
        createShapes();
    }

    public void draw() {
        displayBackground();
        displayShapes();
    }

    public void keyPressed() {

        if (key == 'a') {
            hasBlackBackground = !hasBlackBackground;
        } else if (key == 's') {
            showTrails = !showTrails;
        } else if (key == 'd') {
            changeColors();
        } else if (key == 'f') {
            saveFrame("output/########.png");
        }
    }

    private void createShapes() {

        for (int i = 0; i < shapes.length; i++) {
            int color = colorGenerator.getRandomColor();
            shapes[i] = shapeFactory.getShape();
            shapes[i].setColor(color);
        }
    }

    private void displayBackground() {
        int color;

        if (hasBlackBackground) {
            color = color(0);
        } else {
           color = color(255);
        }

        if (showTrails) {
            fill(color, 25);
            rect(-10, -10, width + 10, height + 10);
        } else {
            background(color);
        }
    }

    private void displayShapes() {

        for (Shape s: shapes) {
            s.display();
            s.move();
        }
    }

    private void changeColors() {
        colorGenerator = colorGeneratorFactory.getRandomColorGenerator();

        for (Shape s: shapes) {
            int color = colorGenerator.getRandomColor();
            s.setColor(color);
        }
    }
}
