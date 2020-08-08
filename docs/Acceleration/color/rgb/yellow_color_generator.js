class YellowColorGenerator extends RGBColorGenerator {

    getRandomColor() {
        colorMode(RGB, 255);
        let r = int(random(100, 255));
        let g = int(random(100, 255));
        let b = int(random(50, 100));
        return color(r, g, b);
    }
}
