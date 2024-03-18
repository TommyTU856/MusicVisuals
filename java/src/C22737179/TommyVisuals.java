package C22737179;

import ie.tudublin.*;
import processing.core.PGraphics;
import processing.core.PShape;

public class TommyVisuals extends Visual{

    float angle;
    float angleSpeed;
    float radius;
    CallSet e;
    PShape rooster;
    float theta = 0;
    float speed = 0;

    public TommyVisuals() {   
    }

    public void showSphere(CallSet e, int n) {

        angle = 0;
        angleSpeed = 0.01f + n * 0.001f;
        radius = 30 + n * 6;

        e.lights();
        e.calculateAverageAmplitude();
        e.stroke(map(e.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);

        e.noStroke();
        if (e.getSmoothedAmplitude() > 0.05) {
            e.fill(e.random(0,360), 250, 250);
        }
        
        float sphereSize = 25 + (200 * e.getSmoothedAmplitude()); 
        e.sphere(sphereSize);

    }

    public void rooster(CallSet e) {
        e.pushMatrix();
        rooster = e.loadShape("GS0D6S94RVZNHC4AZDRXMJDLF.obj");
        e.scale(200);
        e.shape(rooster);
        e.popMatrix();
    }
    
    public void draw(CallSet e) {
        
        e.background(0);

        

        e.translate(e.width / 2, e.height / 2);
        e.rotateY();
        rooster(e);

        /* e.translate(e.width / 2, e.height / 2);
        showSphere(e, 5); */
        //print(e.width, e.height);
        
    }

}