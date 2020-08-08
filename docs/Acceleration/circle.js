class Circle {

    constructor() {
        this.radius = 5;
        this.postion = createVector(random(this.radius, width - radius), random(this.radius, height - radius));
        this.speed = createVector(random(-5, 5), random(-5, 5));
        this.acceleration = createVector(0, 0);
        this.color = new Color(color(0, 0, 255));
        this.maxSpeed = 8;
        this.maxAcceleration = 0.5;
        this.deltaAcceleration = 0.2;
    }
}
