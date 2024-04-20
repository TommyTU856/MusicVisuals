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
    float alph = 255;
    
    public Lollipop(int n){
        this.angle = 0;
        this.angleSpeed = 0.01f + n * 0.001f;
        this.radius = 50 + n * 10;
        this.count = 0;
    }

    void update() {

        angle += angleSpeed * rotSpeed;
        
    }

    

    void display(CallSet e) {
        
        e.lights();
        e.calculateAverageAmplitude();
        
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
            } else if (e.key == 'p') {
                c = 290; 
            } else if (e.key == 'o') {
                c = 360; 
            } else if (e.key == 'i') {
                c = 60; 
            } else if (e.key == 't') {
                alph += 0.5f;
            } else if (e.key == 'g') {
                alph -= 0.5f;
            } 
        }
        
        e.noStroke();
        if (e.getSmoothedAmplitude() > 0.01) {
            e.fill(e.random(0, 360), 80, 100, alph);
        } else {
            e.fill(c, 100, 100, alph);
        }
        //e.fill(c, 100, 100, alph);
        e.pushMatrix();
        e.translate(x, y);
        e.sphereDetail(20);
        e.sphere(sphereSize);
        e.popMatrix();
        System.out.println(e.getSmoothedAmplitude());
    }

}
