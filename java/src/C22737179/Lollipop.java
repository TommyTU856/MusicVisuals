package C22737179;

import ie.tudublin.*;
import processing.core.PApplet;
import processing.core.PConstants;

public class Lollipop extends Visual {

    float angle;
    float angleSpeed;
    float radius;
    float count;
    float rotSpeed = 0.5f;
    float sphereBaseSize = 25;
    /* float pit = 0;
    float yaw = 0;
    float rol = 0; */

    public Lollipop(int n){
        this.angle = 0;
        this.angleSpeed = 0.01f + n * 0.001f;
        this.radius = 30 + n * 10;
        this.count = 0;
    }

    void update() {

        angle += angleSpeed * rotSpeed;
    }

    

    void display(CallSet e) {
        
        e.lights();
        e.calculateAverageAmplitude();
        //e.stroke(map(e.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        float c = (e.frameCount % 360);
        float sphereSize = sphereBaseSize + (250 * e.getSmoothedAmplitude());
        float x = radius * cos(angle);
        float y = radius * sin(angle);

        if (e.keyPressed) {
            if (e.keyCode == PConstants.LEFT) {
                rotSpeed -= 0.01f;
            } else if (e.keyCode == PConstants.RIGHT) {
                rotSpeed += 0.01f;
            } else if (e.keyCode == PConstants.UP) {
                radius += 1;
            } else if (e.keyCode == PConstants.DOWN) {
                radius -= 1;
            } else if (e.keyCode == PConstants.SHIFT) {	
                rotSpeed = 0;
            } else if (e.keyCode == PConstants.CONTROL) {
                sphereBaseSize -= .5f;
            } else if (e.keyCode == PConstants.ALT) {
                sphereBaseSize += .5f;
            } /* else if (e.keyCode == PConstants.BACKSPACE) {
                pit = 0;
                yaw = 0;
                rol = 0;
            } else if (e.key == 'w') {
                pit += 1;
            } else if (e.key == 's') {
                pit -= 1;
            } else if (e.key == 'a') {
                yaw += 1;
            } else if (e.key == 'd') {
                yaw -= 1;
            } else if (e.key == 'q') {
                rol += 1;
            } else if (e.key == 'e') {
                rol -= 1;
            } */
        }
        
        //println(getSmoothedAmplitude());
        //line(0, 0, x, y);
        e.noStroke();
        e.fill(c, 255, 255);
        e.pushMatrix();
        e.translate(x, y);
        //float sphereSize = 25 + (200 * e.getSmoothedAmplitude()); 

        /* e.rotateX(radians(pit));
        e.rotateY(radians(yaw));
        e.rotateZ(radians(rol)); */

        e.sphere(sphereSize);
        //ellipse(x, y, 25 + getSmoothedAmplitude(), 25 + getSmoothedAmplitude());
        e.popMatrix();
        //System.out.println(rol + " " + yaw + " " + pit);
    }

}
