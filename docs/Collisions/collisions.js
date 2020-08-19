// Collisions Sketch
// Press 'a' to change the background to black or white

var circles;
var hasBlackBackground;

function setup() {
    createCanvas(windowWidth-20, windowHeight-20);
    frameRate(60);
    circles = [];
    hasBlackBackground = true;
    createCircles();
    createInstructions();
}

function draw() {
    displayBackground();
    displayCircles();
    checkForCircleCollisions();
}

function keyTyped() {

    if (key === 'a') {
        toggleBackgroundColor();
    }
}

function createCircles() {

    for (let i = 0; i < 20; i++) {
        let circle = new Circle();
        circles.push(circle);
    }
}

function createInstructions() {
    let div = createElement('div');
    let h1 = createElement('h1', 'Instructions');
    let instructionList = createElement('ul');
    let instructions = [];
    instructions.push(createElement('li', "Press the 'a' key to change the background to black or white"));
    instructions.push(createElement('li', "Press the 's' key to activate and deactivate trails"));
    instructions.push(createElement('li', "Press the 'd' key to change the color scheme"));
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

    background(color);
}

function displayCircles() {

    circles.forEach((circle) => {
        circle.display();
        circle.move();
    });
}

function checkForCircleCollisions() {

    for (let i = 0; i < circles.length; i++) {

        for (let k = i; k < circles.length; k++) {
            circles[i].collideAndBounce(circles[k]);
        }
    }
}

function toggleBackgroundColor() {
    hasBlackBackground = !hasBlackBackground;
}
