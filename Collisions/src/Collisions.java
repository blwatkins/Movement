// Collisions
// Press 'a' to change background to black or white
// Press 's' to turn trails on or off
// Press 'd' to change the color scheme

import processing.core.PApplet;

import color.ColorGenerator;
import color.ColorGeneratorFactory;

public class Collisions extends PApplet {
    private Circle[] circles;
    private ColorGeneratorFactory colorGeneratorFactory;
    private ColorGenerator colorGenerator;
    private boolean hasBlackBackground;
    private boolean isShowingTrails;

    public static void main(String[] args) {
        String[] processingArgs = {"Collisions"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        circles = new Circle[10];
        colorGeneratorFactory = new ColorGeneratorFactory(this);
        colorGenerator = colorGeneratorFactory.getRandomColorGenerator();
        hasBlackBackground = true;
        isShowingTrails = false;
        createCircles();
    }

    public void draw() {
        displayBackground();
        displayCircles();
        checkForCircleCollision();
    }

    public void keyPressed() {

        if (key == 'a') {
            toggleBackgroundColor();
        } else if (key == 's') {
            toggleTrails();
        } else if (key == 'd') {
            changeColorScheme();
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

        if (isShowingTrails) {
            fill(color, 25);
            rect(-10, -10, width + 10, height + 10);
        } else {
            background(color);
        }
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

    private void toggleBackgroundColor() {
        hasBlackBackground = !hasBlackBackground;
    }

    private void toggleTrails() {
        isShowingTrails = !isShowingTrails;
    }

    private void changeColorScheme() {
        colorGenerator = colorGeneratorFactory.getRandomColorGenerator();

        for (Circle circle: circles) {
            int color = colorGenerator.getRandomColor();
            circle.setColor(color);
        }

    }
}
