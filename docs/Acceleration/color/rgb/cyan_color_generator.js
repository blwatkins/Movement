class CyanColorGenerator extends RGBColorGenerator {

    getRandomColor() {
        colorMode(RGB, 255);
        let r = int(random(50, 100));
        let g = int(random(100, 255));
        let b = int(random(100, 255));
        return color(r, g, b);
    }
}
