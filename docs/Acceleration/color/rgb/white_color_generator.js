class WhiteColorGenerator extends RGBColorGenerator {

    randomColor() {
        colorMode(RGB, 255);
        let gray = int(random(100, 255));
        return color(gray);
    }
}
