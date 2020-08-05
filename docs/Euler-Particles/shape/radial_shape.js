class RadialShape extends Shape {

    constructor() {
        super();
        this.radius = random(5, 50);
        this.position = createVector(random(this.radius, width - this.radius), random(this.radius, height - this.radius));
    }

    bounce() {
        if (this.position.x + this.radius >= width || this.position.x - this.radius <= 0) {
            this.speed.x *= -1;
        }

        if (this.position.y + this.radius >= height || this.position.y - this.radius <= 0) {
            this.speed.y *= -1;
        }
    }
}
