class Circle {

    constructor() {
        this.radius = random(5, 75);
        this.mass = this.radius;
        this.position = createVector(random(this.radius, width - this.radius), random(this.radius, height - this.radius));
        this.velocity = createVector(random(-5, 5), random(-5, 5));
        this.color = new Color(color(0, 0, 255));
    }

    getRadius() {
        return this.radius;
    }

    getMass() {
        return this.mass;
    }

    getPosition() {
        return this.position;
    }

    getVelocity() {
        return this.velocity;
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

    collideAndBounce(circle) {
        let totalRadius = this.radius + circle.getRadius();
        let difference = p5.Vector.sub(this.position, circle.getPosition());
        let distance = difference.mag();
        let hasCollision = distance <= totalRadius;

        if (hasCollision) {
            this._bounceCircle(circle);
        }
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

    _bounceCircle(circle) {
        let totalRadius = this.radius + circle.getRadius();
        let difference = p5.Vector.sub(this.position, circle.getPosition());
        let distance = difference.mag();
        let distanceCorrection = (totalRadius - distance) / 2;
        let correction = difference.normalize().mult(distanceCorrection);
        this.position.add(correction);
        circle.getPosition().sub(correction);
        let tempVelocityX = this.velocity.x;
        let tempVelocityY = this.velocity.y;
        let velocityX = (((this.mass - circle.getMass()) * this.velocity.x) + (2 * circle.getMass() * circle.getVelocity().x)) / (this.mass + circle.getMass());
        let velocityY = (((this.mass - circle.getMass()) * this.velocity.y) + (2 * circle.getMass() * circle.getVelocity().y)) / (this.mass + circle.getMass());
        let circleVelocityX = (((circle.getMass() - this.mass) * circle.getVelocity().x) + (2 * this.mass * tempVelocityX)) / (this.mass + circle.getMass());
        let circleVelocityY = (((circle.getMass() - this.mass) * circle.getVelocity().y) + (2 * this.mass * tempVelocityY)) / (this.mass + circle.getMass());
        this.velocity.set(velocityX, velocityY);
        circle.getVelocity().set(circleVelocityX, circleVelocityY);
    }
}
