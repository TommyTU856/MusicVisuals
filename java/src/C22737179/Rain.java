package C22737179;

import processing.core.PApplet;

public class Rain {
    Drop[] d;
    PApplet e;

    Rain(PApplet e) {
        this.e = e;
        d = new Drop[100];
        for (int i = 0; i < d.length; i++) {
            // Start each drop at a random position along the x-axis
            d[i] = new Drop(e.random(e.width), e.random(-e.height, 0), e.random(5), e);
        }
    }

    public void render() {
        // e.calculateAverageAmplitude(); // This method does not exist in PApplet

        for (int i = 0; i < d.length; i++) {
            d[i].show();
            d[i].update();
        }
    }
}

class Drop {
    float x, y, z;
    PApplet e;

    Drop(float x, float y, float z, PApplet e) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.e = e;
    }

    void update() {
        float spd = e.map(z, 0, 5, 10, 4);
        y = y + 4;

        if (y > e.height + 10) {
            y = -10;
            x = e.random(e.width); // Start the drop from a random x-position again
        }
    }

    void show() {
        float t = e.map(z, 0, 5, 10, 2);
        e.strokeWeight(t);
        e.line(x, y, x, y + t * 2);
    }
}
