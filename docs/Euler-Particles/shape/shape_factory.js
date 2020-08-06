class ShapeFactory {

    constructor() {
        this._CIRCLE = 0;
        this._POLYGON = 1;
        this._STAR = 2;
        this._RANDOMPOLYGON = 3;
        this._RANDOMSTAR = 4;
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
            case this._RANDOMPOLYGON:
                shape = new Polygon(int(random(3, 12)));
                break;
            case this._RANDOMSTAR:
                shape = new Star(int(random(4, 12)));
                break;
            default:
                shape = new Circle();
                break;
        }

        return shape;
    }

    randomize() {
        let r = int(random(500));

        switch (r % 5) {
            case 1:
                this.type = this._CIRCLE;
                break;
            case 2:
                this.type = this._POLYGON;
                break;
            case 3:
                this.type = this._RANDOMPOLYGON;
                break;
            case 4:
                this.type = this._RANDOMSTAR;
                break;
            default:
                this.type = this._STAR;
                break;
        }

        this.sides = int(random(3, 12));
    }
}
