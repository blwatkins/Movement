import processing.core.PApplet;

import color.ColorGenerator;
import color.ColorGeneratorFactory;

public class Collisions extends PApplet {
    private Circle[] circles;
    private ColorGeneratorFactory colorGeneratorFactory;
    private ColorGenerator colorGenerator;

    public static void main(String[] args) {
        String[] processingArgs = {"Collisions"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        circles = new Circle[20];
        colorGeneratorFactory = new ColorGeneratorFactory(this);
        colorGenerator = colorGeneratorFactory.getRandomColorGenerator();
        createCircles();
    }

    public void draw() {
        displayBackground();
        displayCircles();
    }

    private void createCircles() {

        for (int i = 0; i < circles.length; i++) {
            Circle circle = new Circle(this);
            int color = colorGenerator.getRandomColor();
            circle.setColor(color);
            circles[i] = circle;
        }
    }

    private void displayBackground() {
        background(0);
    }

    private void displayCircles() {

        for (Circle circle: circles) {
            circle.display();
            circle.move();
        }
    }
}
