class Circle extends RadialShape {

    constructor() {
        super();
    }

    display() {
        pushMatrix();
        noStroke();
        fill(this.color.getColor());
        translate(this.position.x, this.position.y);
        ellipse(0, 0, this.radius * 2, this.radius * 2);
        popMatrix();
    }
}
