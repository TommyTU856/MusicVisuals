package C22737179;

import processing.core.PApplet;

class Fade {
    PApplet pa;
    int x;
    int y;
    float t_initial;
    float t_final;
    int alpha;

    public Fade(int x_, int y_, float tf_, PApplet pa) {
        this.pa = pa;
        x = x_;
        y = y_;
        t_final = tf_;
        t_initial = pa.millis();
        alpha = 255;
    }

    void update() {
        alpha = (int) pa.map(pa.millis() - t_initial, 0, t_final, 255, 0);
    }

    void display() {
        pa.pushMatrix();
        pa.translate(x, y);
        pa.noStroke();
        pa.fill(0, alpha);
        drawShape();
        pa.popMatrix();
    }

    void drawShape() {
        // Implement this method according to your needs
    }

    boolean died() {
        return pa.millis() - t_initial > t_final;
    }
}
