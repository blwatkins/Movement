// Acceleration Sketch
// Press 'a' to change the background to black or white
// Press 's' to turn the trails on and off

var circles;
var hasBlackBackground;
var isShowingTrails;

function setup() {
    createCanvas(windowWidth-20, windowHeight-20);
    frameRate(60);
    circles = [];
    hasBlackBackground = true;
    isShowingTrails = false;
    createCircles();
}

function draw() {
    displayBackground();
    displayCircles();
}

function keyTyped() {

    if (key === 'a') {
        hasBlackBackground = !hasBlackBackground;
    } else if (key === 's') {
        isShowingTrails = !isShowingTrails;
    }
}

function createCircles() {

    for (let i = 0; i < 100; i++) {
        let circle = new Circle();
        circles.push(circle);
    }
}

function displayBackground() {
    let color = 255;

    if (hasBlackBackground) {
        color = 0;
    }

    if (isShowingTrails) {
        fill(color, 25);
        rect(-10, -10, width + 10, height + 10);
    } else {
        background(color)
    }
}

function displayCircles() {

    circles.forEach((circle) => {
        circle.display();
        circle.move();
    });
}
