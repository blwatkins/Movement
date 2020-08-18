class Circle {

    constructor() {
        this.radius = random(5, 75);
        this.mass = this.radius;
        this.position = createVector(random(this.radius, width - this.radius), random(this.radius, height - this.radius));
        this.velocity = createVector(random(-5, 5), random(-5, 5));
        this.color = new Color(color(0, 0, 255));
    }

    setColor(color) {
        this.color.setColor(color);
    }

    display() {
        noStroke();
        fill(this.color.getColor());
        ellipse(this.position.x, this.position.y, this.radius * 2, this.radius * 2);
    }

    move() {
        this._incrementVectors();
        this._bounce();
    }

    _incrementVectors() {
        this.position.add(this.velocity);
    }

    _bounce() {
        
        if (this.position.x - this.radius <= 0 || this.position.x + this.radius >= width) {
            let velocityX = this.velocity.x * -1;
            let x = constrain(this.position.x, this.radius, width - this.radius);
            this.velocity.set(velocityX, this.velocity.y);
            this.position.set(x, this.position.y);
        }

        if (this.position.y - this.radius <= 0 || this.position.y + this.radius >= height) {
            let velocityY = this.velocity.y * -1;
            let y = constrain(this.position.y, this.radius, height - this.radius);
            this.velocity.set(this.velocity.x, velocityY);
            this.position.set(this.position.x, y);
        }
    }
}
