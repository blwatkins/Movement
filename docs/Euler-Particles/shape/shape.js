class Shape {

    constructor() {
        this.position = createVector(random(width), random(height));
        this.speed = createVector(random(-5, 5), random(-5, 5));
        this.color = new Color(color(0, 0, 255));
    }

    getColor() {
        return this.color.getColor();
    }

    setColor(color) {
        this.color.setColor(color);
    }

    display() {

    }

    move() {
        this.position.add(speed);
        this.bounce();
    }

    bounce() {

    }
}
