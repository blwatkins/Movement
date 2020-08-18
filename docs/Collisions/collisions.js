// Collisions Sketch

var circles;

function setup() {
    createCanvas(windowWidth-20, windowHeight-20);
    frameRate(60);
    circles = [];
    createCircles();
}

function draw() {
    displayBackground();
    displayCircles();
    checkForCircleCollisions();
}

function createCircles() {

    for (let i = 0; i < 20; i++) {
        let circle = new Circle();
        circles.push(circle);
    }
}

function displayBackground() {
    background(0);
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
