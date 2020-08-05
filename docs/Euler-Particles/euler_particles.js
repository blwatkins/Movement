// Euler Particles Main Sketch

var shapes;
var shapeCount;
var colorGenerator;
var colorGeneratorFactory;

function setup() {
    createCanvas(windowWidth-20, windowHeight-20);
    frameRate(60);
    shapes = [];
    shapeCount = 100;
    colorGeneratorFactory = new ColorGeneratorFactory();
    colorGenerator = colorGeneratorFactory.getRandomColorGenerator();
    createShapes();
}

function draw() {
    displayBlackground();
    displayShapes();
}

function createShapes() {

    for (let i = 0; i < shapeCount; i++) {
        let shape = new Circle;
        shape.setColor(colorGenerator.randomColor());
        shapes.push(shape);
    }
}

function displayBlackground() {
    background(0);
}

function displayShapes() {

    shapes.forEach((shape) => {
        shape.display();
        shape.move();
    });
}
