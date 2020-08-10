// Collisions
// Press 'a' to change background to black or white

import processing.core.PApplet;

import color.ColorGenerator;
import color.ColorGeneratorFactory;

public class Collisions extends PApplet {
    private Circle[] circles;
    private ColorGeneratorFactory colorGeneratorFactory;
    private ColorGenerator colorGenerator;
    private boolean hasBlackBackground;

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
        hasBlackBackground = true;
        createCircles();
    }

    public void draw() {
        displayBackground();
        displayCircles();
        checkForCircleCollision();
    }

    public void keyPressed() {

        if (key == 'a') {
            hasBlackBackground = !hasBlackBackground;
        }
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
        int color = color(255);

        if (hasBlackBackground) {
            color = color(0);
        }

        background(color);
    }

    private void displayCircles() {

        for (Circle circle: circles) {
            circle.display();
            circle.move();
        }
    }

    private void checkForCircleCollision() {

        for (int i = 0; i < circles.length; i++) {

            for (int k = i + 1; k < circles.length; k++) {
                circles[i].collideAndBounce(circles[k]);
            }
        }
    }
}
