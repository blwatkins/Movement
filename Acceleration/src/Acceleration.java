// Acceleration
// Press 'a' to change the background to black or white
// Press 's' to turn trails on and off
// Press 'd' to change the color scheme

import color.ColorGenerator;
import color.ColorGeneratorFactory;
import processing.core.PApplet;

public class Acceleration extends PApplet {
    private ColorGenerator colorGenerator;
    private ColorGeneratorFactory colorGeneratorFactory;
    private Circle[] circles;
    private boolean hasBlackBackground;
    private boolean isShowingTrails;

    public static void main(String[] args) {
        String[] processingArgs = {"Acceleration"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        fullScreen();
        //size(800, 800);
    }

    public void setup() {
        colorGeneratorFactory = new ColorGeneratorFactory(this);
        colorGenerator = colorGeneratorFactory.getRandomColorGenerator();
        circles = new Circle[200];
        hasBlackBackground = true;
        isShowingTrails = false;
        createCircles();
    }

    public void draw() {
        displayBackground();
        displayCircles();
    }

    public void keyPressed() {

        if (key == 'a') {
            hasBlackBackground = !hasBlackBackground;
        } else if (key == 's') {
            isShowingTrails = !isShowingTrails;
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

    private void changeColorScheme() {
        colorGenerator = colorGeneratorFactory.getRandomColorGenerator();

        for (Circle circle: circles) {
            int color = colorGenerator.getRandomColor();
            circle.setColor(color);
        }
    }
}
