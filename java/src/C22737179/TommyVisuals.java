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
    float scale = 0;
    float roosterGrow = 0;
    float startTime = millis();
    float roosterSize;
    float cloudX = -100;
    float cloudY;
    float cloudSpeed = 50;
    boolean movingRight = true;

    public TommyVisuals() {   
    }

    public void cloud(CallSet e, float cloudX) {

        e.pushMatrix();
        e.lights();
        e.noStroke();
        e.fill(0, 0, 255);
        e.translate(cloudX, e.height / 2);
        e.sphere(50);
        e.translate(60, 0);
        e.sphere(50);
        e.translate(60, 0);
        e.sphere(40);
        e.translate(-80, -40);
        e.sphere(40);
        e.popMatrix();

    }

    

    public void showSphere(CallSet e) {

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
        e.shape(rooster);
        e.popMatrix();
    }
    
    public void draw(CallSet e) {
        
        e.background(0);


        if(e.getAudioPlayer().position() > 1 && e.getAudioPlayer().position() < 2000 && e.paused == false) {

            //float elapsedTime = millis() - startTime;
            /* scale = 50.0f;
            roosterGrow += scale; */
            roosterGrow = Visual.lerp(roosterGrow, 200, 0.5f);

            e.translate(e.width / 4, e.height / 1.5f);
            e.rotateX(0);
            e.rotateY(1.4f);
            e.rotateZ(3);

            if(roosterGrow < 200) {
                e.scale(roosterGrow);
            } else {
                e.scale(200);
            }
            
            //e.rotateY(theta);
            rooster(e);

        }

        if(e.getAudioPlayer().position() > 2000 && e.getAudioPlayer().position() < 15000 && e.paused == false) {

            e.pushMatrix();
            e.translate(e.width / 4, e.height / 1.5f);
            e.rotateX(0);
            e.rotateY(1.4f);
            e.rotateZ(3);
            e.scale(200);
            rooster(e);
            e.popMatrix();
            
        }

        if(e.getAudioPlayer().position() > 15000 && e.getAudioPlayer().position() < 27000 && e.paused == false) {

            e.pushMatrix();
            e.translate(e.width / 4, e.height / 1.5f);
            e.rotateX(0);
            e.rotateY(1.4f);
            e.rotateZ(3);
            e.scale(200);
            rooster(e);
            e.popMatrix();

            if(movingRight) {
                cloudX += cloudSpeed;
                if(cloudX > e.width + 100) {
                    movingRight = false;
                    cloudX = -200;
                }
            }
            
            cloud(e, cloudX);
            
        }

        if(e.getAudioPlayer().position() > 27000 && e.getAudioPlayer().position() < 270000 && e.paused == false) {

            e.pushMatrix();
            e.translate(e.width / 4, e.height / 1.5f);
            e.rotateX(0);
            e.rotateY(1.4f);
            e.rotateZ(3);
            e.scale(200);
            rooster(e);
            e.popMatrix();

            
            
        }

        

        
        /* e.translate(e.width / 2, e.height / 2);
        showSphere(e, 5); */
        //print(e.width, e.height);
        print(e.getAudioPlayer().position() + "\n");
        print(e.getSmoothedAmplitude() + "\n");
    }

}