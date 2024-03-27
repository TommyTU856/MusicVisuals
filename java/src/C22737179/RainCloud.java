package C22737179;


import processing.core.PApplet;
import java.util.ArrayList;
import processing.core.PConstants;
import processing.core.PVector;

public class RainCloud {
    PApplet parent;
    PVector position;
    ArrayList<Drop> drops;
    boolean spawning = true;
    float w;
    float h;
    Circle[] circles;

    RainCloud(PApplet parent, PVector pos) {
        this.parent = parent;
        position = pos;
        drops = new ArrayList<Drop>();
        w = 130;
        h = 20;
        circles = new Circle[5];
        PVector p = pos.copy();
        circles[0] = new Circle(parent, p.x - w / 2, p.y + h + 3, 20);
        circles[1] = new Circle(parent, p.x - w / 4, p.y + h - 7, 30);
        circles[2] = new Circle(parent, p.x + w / 8, p.y + h - 17, 40);
        circles[3] = new Circle(parent, p.x + (w / 6 * 3) - 10, p.y + h / 2, 10);
        circles[4] = new Circle(parent, p.x + w / 2, p.y + (h / 3 * 3) + 8, h / 4 * 3);
    }

    void spawnDrop() {
        Drop d = new Drop(parent);
        d.position = PVector.add(position, new PVector(parent.random(-65, 65), parent.random(15, 20)));
        d.push();
        drops.add(d);
    }

    void drawDrops() {
        for (Drop d : drops) {
            if (d.offScreen() && spawning) {
                spawning = false;
                break;
            }
        }
        if (spawning) {
            spawnDrop();
        }
        for (Drop d : drops) {
            d.draw();
        }
    }

    void draw() {
        PVector p = position.copy();
        parent.pushStyle();
        drawDrops();
        parent.fill(255);
        parent.stroke(255);
        parent.rectMode(PConstants.CENTER); // Accessing PConstants.CENTER statically
        parent.rect(p.x, p.y + p.y / 3 * 2, w, h);
        for (Circle c : circles) {
            c.draw();
        }
        parent.popStyle();
    }
}

class Circle {
    PApplet parent;
    float x, y, r;

    Circle(PApplet parent, float x, float y, float r) {
        this.parent = parent;
        this.x = x;
        this.y = y;
        this.r = r;
    }

    void draw() {
        parent.pushStyle();
        parent.fill(255);
        parent.stroke(255);
        parent.ellipse(x, y, r * 2, r * 2);
        parent.popStyle();
    }
}

class Drop {
    PApplet parent;
    PVector position;
    float velocity;
    float gravity;
    Drop originalState;

    Drop(PApplet parent) {
        this.parent = parent;
        position = new PVector();
        velocity = 0;
        gravity = 0.3f;
    }

    boolean offScreen() {
        if (position.y > parent.height) {
            return true;
        }
        return false;
    }

    void push() {
        originalState = new Drop(parent);
        originalState.position = position.copy();
        originalState.velocity = velocity;
    }

    void update() {
        position.y += velocity;
        velocity += gravity;
        if (originalState != null && position.y > parent.height) {
            position = originalState.position.copy();
            velocity = originalState.velocity;
        }
    }

    void draw() {
        update();
        PVector p = position.copy();
        parent.pushStyle();
        parent.stroke(255);
        parent.line(p.x, p.y, p.x, p.y - 10);
        parent.popStyle();
    }
}
