class WhiteColorGenerator extends RGBColorGenerator {

    getRandomColor() {
        colorMode(RGB, 255);
        let gray = int(random(100, 255));
        return color(gray);
    }
}
