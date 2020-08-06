class Polygon extends RadialShape {

    constructor(sides) {
        super();
        this.vertices = [];
        this._initVertices(sides);
    }

    _initVertices(sides) {
        let theta = 0;
        sides = constrain(3, 20);
        let deltaTheta = TWO_PI / sides;

        for (let i = 0; i < sides; i++) {
            let x = cos(theta) * this.radius;
            let y = sin(theta) * this.radius;
            theta += deltaTheta;
            this.vertices.push(createVector(x, y));
        }
    }

    display() {
        push();
        noStroke();
        fill(this.color.getColor());
        translate(this.position.x, this.position.y);
        beginShape();

        this.vertices.forEach((v) => {
            vertex(v);
        });

        endShape(CLOSE);
        pop();
    }
}
