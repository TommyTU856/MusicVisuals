package C22737179;

import ie.tudublin.*;

public class Lollipop extends Visual {


    float angle;
    float angleSpeed;
    float radius;

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }


    public Lollipop(int n, float radius){
        this.angle = 0;
        this.angleSpeed = 0.01f + n * 0.001f;
        this.radius = 30 + n * 6;
        
    }

    void update() {
        angle += angleSpeed;
    }

    void display(CallSet e) {
        
        e.lights();
        e.calculateAverageAmplitude();
        e.stroke(map(e.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);

        float x = radius * cos(angle);
        float y = radius * sin(angle);

        //println(getSmoothedAmplitude());
        //line(0, 0, x, y);
        e.noStroke();
        if (e.getSmoothedAmplitude() > 0.1) {
            e.fill(random(0,360), 80, 100);
        }
        
        e.translate(x, y);
        float sphereSize = 25 + (200 * e.getSmoothedAmplitude()); 
        e.sphere(sphereSize);
        //ellipse(x, y, 25 + getSmoothedAmplitude(), 25 + getSmoothedAmplitude());
    }

}
