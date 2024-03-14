package C22737179;

public class Lollipop extends TommyVisuals{


    /* Lollipop[] lollipops;
    int numLollipops = 25; */
    float angle;
    float angleSpeed;
    float radius;

    TommyVisuals t;

    Lollipop(int n) {
        this.angle = 0;
        this.angleSpeed = 0.01f + n * 0.001f;
        this.radius = 30 + n * 6;
    }

    void update() {
        angle += angleSpeed;
    }

    void display() {
        
        lights();
        calculateAverageAmplitude();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);

        float x = radius * cos(angle);
        float y = radius * sin(angle);

        //println(getSmoothedAmplitude());
        //line(0, 0, x, y);
        noStroke();
        if (getSmoothedAmplitude() > 0.1) {
            fill(random(0,360), 80, 100);
        }
        
        translate(x, y);
        float sphereSize = 25 + (200 * getSmoothedAmplitude()); 
        sphere(sphereSize);
        //ellipse(x, y, 25 + getSmoothedAmplitude(), 25 + getSmoothedAmplitude());
    }

}
