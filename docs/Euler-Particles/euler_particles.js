// Euler Particles Main Sketch
// Press 'a' to change background to black or white

var shapes;
var shapeCount;
var hasBlackBackground;
var showTrails;
var colorGenerator;
var colorGeneratorFactory;

function setup() {
    createCanvas(windowWidth-20, windowHeight-20);
    frameRate(60);
    shapes = [];
    shapeCount = 100;
    hasBlackBackground = true;
    showTrails = false;
    colorGeneratorFactory = new ColorGeneratorFactory();
    colorGenerator = colorGeneratorFactory.getRandomColorGenerator();
    createShapes();
    createInstructions();
}

function draw() {
    displayBackground();
    displayShapes();
}

function keyTyped() {

    if (key == 'a') {
        hasBlackBackground = !hasBlackBackground;
    } else if (key == 's') {
        showTrails = !showTrails;
    }
}

function createShapes() {

    for (let i = 0; i < shapeCount; i++) {
        let shape = new Circle;
        shape.setColor(colorGenerator.randomColor());
        shapes.push(shape);
    }
}

function createInstructions() {
    let div = createElement('div');
    let h1 = createElement('h1', 'Instructions');
    let instructionList = createElement('ul');
    let instructions = [];
    instructions.push(createElement('li', "Press the 'a' key to change the background to black or white"));
    instructions.push(createElement('li', "Press the 's' key to activate and deactivate trails"));
    div.id('instructions');
    h1.parent(div);
    instructionList.parent(div);

    instructions.forEach((instruction) => {
        instruction.parent(instructionList);
    });
}

function displayBackground() {
    let color = 255;

    if (hasBlackBackground) {
        color = 0;
    }

    if (showTrails) {
        fill(color, 25);
        rect(-10, -10, width + 10, height + 10);
    } else {
        background(color);
    }
}

function displayShapes() {

    shapes.forEach((shape) => {
        shape.display();
        shape.move();
    });
}
