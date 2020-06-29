package color;

import processing.core.PApplet;

public class Color {
    private PApplet p;
    private int r;
    private int g;
    private int b;
    private int a;

    public Color(PApplet p) {
        this.p = p;
        initColor(p.color(0));
    }

    public Color(PApplet p, int color) {
        this.p = p;
        initColor(color);
    }

    private void initColor(int color) {
        p.colorMode(PApplet.RGB, 255);
        r = (int)p.red(color);
        g = (int)p.green(color);
        b = (int)p.blue(color);
        a = (int)p.alpha(color);
    }

    public int getColor() {
        p.colorMode(PApplet.RGB, 255);
        return p.color(r, g, b, a);
    }

    public void setColor(int color) {
        initColor(color);
    }

    public int getRed() {
        return r;
    }

    public int getGreen() {
        return g;
    }

    public int getBlue() {
        return b;
    }

    public int getAlpha() {
        return a;
    }

    public void setRed(int red) {
        r = PApplet.constrain(red, 0, 255);
    }

    public void setGreen(int green) {
        g = PApplet.constrain(green, 0, 255);
    }

    public void setBlue(int blue) {
        b = PApplet.constrain(blue, 0, 255);
    }

    public void setAlpha(int alpha) {
        a = PApplet.constrain(alpha, 0, 255);
    }
}
