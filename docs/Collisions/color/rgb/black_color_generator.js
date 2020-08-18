class BlackColorGenerator extends RGBColorGenerator {

    getRandomColor() {
        colorMode(RGB, 255);
        let gray = int(random(100));
        return color(gray);
    }
}
