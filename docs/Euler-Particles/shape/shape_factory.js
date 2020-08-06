class ShapeFactory {

    constructor() {
        this._CIRCLE = 0;
        this._POLYGON = 1;
        this._STAR = 2;
        this.type = this._CIRCLE;
        this.sides = 0;
        this.randomize();
    }

    getShape() {
        let shape = null;

        switch (this.type) {
            case this._POLYGON:
                shape = new Polygon(this.sides);
                break;
            case this._STAR:
                shape = new Star(this.sides);
                break;
            default:
                shape = new Circle();
                break;
        }

        return shape;
    }

    randomize() {
        let r = int(random(300));

        switch (r % 3) {
            case 1:
                this.type = this._CIRCLE;
                break;
            case 2:
                this.type = this._POLYGON;
                break;
            default:
                this.type = this._STAR;
                break;
        }

        this.sides = int(random(3, 12));
    }


}
