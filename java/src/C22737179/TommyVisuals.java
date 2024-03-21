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
    float roosterY = 1.4f;
    float roosterX = 1200 / 4;
    ResponsiveShape responsiveShape;


    public TommyVisuals() {  
         
    }

    public void cloud(CallSet e, float cloudX, float cloudY) {
        
        e.pushMatrix();
        e.lights();
        e.noStroke();
        e.fill(0, 0, 255);
        e.translate(cloudX, cloudY);
        e.sphere(50);
        e.translate(60, 0);
        e.sphere(50);
        e.translate(60, 0);
        e.sphere(40);
        e.translate(-80, -40);
        e.sphere(40);
        e.popMatrix();

    }

    public void randomClouds(CallSet e) {

        float x;
        float y;
        
        for(int i = 0; i < e.random(10, 50); i++) {
            x = e.random(e.width);
            y = e.random(e.height);
            cloud(e, x, y);
        }

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
        //rooster = e.loadShape("GS0D6S94RVZNHC4AZDRXMJDLF.obj");
        e.shape(e.rooster);
        e.popMatrix();
    }

    
    
    public void draw(CallSet e) {
        
        e.colorMode(HSB, 360, 100, 100);
        e.background(0);
        e.calculateAverageAmplitude();

        responsiveShape = new ResponsiveShape();
        
        e.background(0);

        e.translate(e.width / 2, e.height / 2);
        e.stroke(180, 50, 80);
        responsiveShape.render(e);

        e.translate(4, 3);
        e.stroke(10, 50, 80);
        responsiveShape.render(e);

        e.translate(-4, -3);
        e.stroke(0, 0, 50);
        responsiveShape.render(e);




        /* if(e.getAudioPlayer().position() > 1 && e.getAudioPlayer().position() < 2000 && e.paused == false) {

            //float elapsedTime = millis() - startTime;
            //* scale = 50.0f;
            //roosterGrow += scale;
            roosterGrow = Visual.lerp(roosterGrow, 200, 0.1f);

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

        if(e.getAudioPlayer().position() > 15000 && e.getAudioPlayer().position() < 28000 && e.paused == false) {

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
            
            cloud(e, cloudX, e.height / 4);
            
        }

        if(e.getAudioPlayer().position() > 28000 && e.getAudioPlayer().position() < 42000 && e.paused == false) {

            
            roosterY += 0.1f;

            e.pushMatrix();
            e.translate(e.width / 4, e.height / 1.5f);
            e.rotateX(0);
            e.rotateY(roosterY);
            e.rotateZ(3);
            e.scale(200);
            rooster(e);
            e.popMatrix();

            randomClouds(e);
            
        }

        if(e.getAudioPlayer().position() > 42000 && e.getAudioPlayer().position() < 43000 && e.paused == false) {
            roosterX += 25.0f;
            e.background(279, 87, 94);

            e.pushMatrix();
            e.translate(roosterX, e.height / 1.5f);
            e.rotateX(0);
            e.rotateY(roosterY);
            e.rotateZ(3);
            e.scale(200);
            rooster(e);
            e.popMatrix();

            randomClouds(e);
            
        }

        if(e.getAudioPlayer().position() > 43000 && e.getAudioPlayer().position() < 44000 && e.paused == false) {
            roosterX += 25.0f;
            e.background(0, 87, 94);

            e.pushMatrix();
            e.translate(roosterX, e.height / 1.5f);
            e.rotateX(0);
            e.rotateY(roosterY);
            e.rotateZ(3);
            e.scale(200);
            rooster(e);
            e.popMatrix();

            randomClouds(e);
            
        }

        if(e.getAudioPlayer().position() > 44000 && e.getAudioPlayer().position() < 460000 && e.paused == false) {
            roosterX += 25.0f;
            e.background(60, 87, 94);

            e.pushMatrix();
            e.translate(roosterX, e.height / 1.5f);
            e.rotateX(0);
            e.rotateY(1.4f);
            e.rotateZ(3);
            e.scale(200);
            rooster(e);
            e.popMatrix();

            randomClouds(e);
            
        }

        if(e.getAudioPlayer().position() > 54000 && e.getAudioPlayer().position() < 460000 && e.paused == false) {

            e.background(0);

            
            
            
        } */
        //* e.translate(e.width / 2, e.height / 2);
        //showSphere(e, 5);
        //print(e.width, e.height);
        //print(e.getAudioPlayer().position() + "\n");
        //print(e.getSmoothedAmplitude() + "\n");
    }

}