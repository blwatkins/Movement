import color.Color;
import color.ColorGenerator;
import color.ColorGeneratorFactory;
import processing.core.PApplet;

public class Acceleration extends PApplet {
    private Circle[] circles;
    private ColorGenerator colorGenerator;
    private ColorGeneratorFactory colorGeneratorFactory;

    public static void main(String[] args) {
        String[] processingArgs = {"Acceleration"};
        PApplet.main(processingArgs);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        colorGeneratorFactory = new ColorGeneratorFactory(this);
        colorGenerator = colorGeneratorFactory.getRandomColorGenerator();
        circles = new Circle[50];
        createCircles();
    }

    public void draw() {
        displayBackground();
        displayCircles();
    }

    public void keyPressed() {

        if (key == 'a') {

        } else if (key == 's') {
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
        background(0);
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
