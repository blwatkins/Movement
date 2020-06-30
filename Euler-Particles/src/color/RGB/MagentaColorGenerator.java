package color.RGB;

import processing.core.PApplet;

public class MagentaColorGenerator extends RGBColorGenerator {

    public MagentaColorGenerator(PApplet p) {
        super(p);
    }

    public int randomColor() {
        p.colorMode(PApplet.RGB, 255);
        int r = (int)p.random(100, 255);
        int g = (int)p.random(50, 100);
        int b = (int)p.random(100, 255);
        return p.color(r, g, b);
    }

}
