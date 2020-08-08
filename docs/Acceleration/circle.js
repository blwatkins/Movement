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

    setColor(color) {
        this.color.setColor(color);
    }

    display() {
        fill(this.color.getColor());
        noStroke();
        ellipse(this.position.x, this.postion.y, radius * 2, radius * 2);
    }

    move() {
        this._incrementVectors();
        this._constrainVectors();
        this._bounce();
    }

    _incrementVectors() {
        this.position.add(this.speed);
        this.speed.add(this.acceleration);
        let deltaAccelerationX = random(-this.deltaAcceleration, this.deltaAcceleration);
        let deltaAccelerationY = random(-this.deltaAcceleration, this.deltaAcceleration);
        this.acceleration.add(createVector(deltaAccelerationX, deltaAccelerationY));
    }

    _constrainVectors() {
        this._constrainVector(this.speed, -this.maxSpeed, this.maxSpeed);
        this._constrainVector(this.acceleration, -this.maxAcceleration, this.maxAcceleration);
    }

    _constrainVector(vector, minValue, maxValue) {
        let x = constrain(vector.x, minValue, maxValue);
        let y = constrain(vector.y, minValue, maxValue);
        vector.set(x, y);
    }

    _bounce() {

        if (this.postion.x + this.radius >= width || this.postion.x - this.radius <= 0) {
            this.speed.x *= -1;
            let x = constrain(this.position.x, 0, width);
            this.postion.set(x, this.postion.y);
        }

        if (this.position.y + this.radius >= height || this.position.y - this.radius <= 0) {
            this.speed.y *= -1;
            let y = constrain(this.position.y, 0, height);
            this.position.set(this.postion.x, y);
        }
    }
}
