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

class Circle extends Fade {
  
    int radius;
    
    Circle(int x_, int y_, float tf_, int r_, PApplet pa) {
        super(x_, y_, tf_, pa); // Pass PApplet instance to the super constructor
        radius = r_;
    }
    
    void drawShape() {
        pa.ellipse(0, 0, radius*2, radius*2); // Use pa to access ellipse() function
    }
  
}

class Rectangle extends Fade {
    int w;
    int h;
    
    Rectangle(int x_, int y_, float tf_, int w_, int h_, PApplet pa) {
        super(x_, y_, tf_, pa); // Pass PApplet instance to the super constructor
        w = w_;
        h = h_;
    }
    
    void drawShape() {
        pa.rectMode(pa.CENTER);
        pa.rect(0, 0, w, h); // Use pa to access rect() function
    }
  
}


