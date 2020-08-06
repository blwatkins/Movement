class Star extends Polygon {

    constructor(points) {
        super(points);
    }

    _initVertices(points) {
        let theta = 0;
        points = constrain(points, 3, 20);
        let deltaTheta = TWO_PI / (points * 2);

        for (let i = 0; i < points * 2; i++) {
            let r = this.radius;

            if (i % 2 == 0) {
                r /= 2;
            }

            let x = cos(theta) * r;
            let y = sin(theta) * r;
            theta += deltaTheta;
            this.vertices.push(createVector(x, y));
        }
    }
}
