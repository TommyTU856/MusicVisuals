package C22737179;

import ie.tudublin.*;
import processing.core.PConstants;
import processing.core.PShape;


public class TommyVisuals extends Visual{

    float angle;
    float angleSpeed;
    float radius;
    CallSet e;
    PShape rooster;
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
    HyperCube hyperCube;
    float rotZ;
    float rotY;
    float rotX;
    float cubeAngleY;
    float cubeAngleZ;
    float totalRotationZ = 0;

    float textSpacing = 0;
    Lyrics lyrics1;
    Lyrics lyrics2;
    String songWords1;
    String songWords2;

    DrawSphere drawSphere;
    float sphereX1, sphereX2, sphereX3, sphereX4, sphereX5, sphereX6;
    float sphereY1, sphereY2, sphereY3, sphereY4, sphereY5, sphereY6;

    Lollipop[] lollipops;
    int numLollipops = 150;

    float pit = 0;
    float yaw = 0;
    float rol = 0;

    float c1;
    float c2;
    float alpha = 1;


    public TommyVisuals() {  
        lyrics1 = new Lyrics();
        lyrics2 = new Lyrics();
        hyperCube = new HyperCube();
        drawSphere = new DrawSphere();

        lollipops = new Lollipop[numLollipops];
        for (int i = 0; i < numLollipops; i++) {
            lollipops[i] = new Lollipop(i);
        }
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
        e.noStroke();
        float sphereSize = 10 + (200 * e.getSmoothedAmplitude()); 
        e.sphere(sphereSize);

    }

    public void rooster(CallSet e) {
        e.pushMatrix();
        e.shape(e.rooster);
        e.popMatrix();
    }

    
    public void draw(CallSet e) {
        
        e.colorMode(HSB, 360, 100, 100);
        e.background(0, 0, 0);
        e.calculateAverageAmplitude();

//                          ------------START OF TIMED CODE--------------

        
        

        if(e.getAudioPlayer().position() > 1 && e.getAudioPlayer().position() < 2000 && e.paused == false) {

            
            roosterGrow = Visual.lerp(roosterGrow, 200, 0.1f);
            e.pushMatrix();
            e.background(198, 100, 100);
            e.translate(e.width / 4, e.height / 1.5f);
            e.rotateX(0);
            e.rotateY(1.4f);
            e.rotateZ(3);

            if(roosterGrow < 200) {
                e.scale(roosterGrow);
            } else {
                e.scale(200);
            }
            
            rooster(e);
            e.popMatrix();
            
        }

        if(e.getAudioPlayer().position() > 2000 && e.getAudioPlayer().position() < 4800 && e.paused == false) {

            e.pushMatrix();
            e.background(198, 100, 100);
            e.translate(e.width / 4, e.height / 1.5f);
            e.rotateX(0);
            e.rotateY(1.4f);
            e.rotateZ(3);
            e.scale(200);
            rooster(e);
            e.popMatrix();
            
        }
        
        if(e.getAudioPlayer().position() > 4800 && e.getAudioPlayer().position() < 15000 && e.paused == false) {

            e.pushMatrix();
            e.background(198, 100, 100);
            e.translate(e.width / 4, e.height / 1.5f);
            e.rotateX(0);
            e.rotateY(1.4f);
            e.rotateZ(3);
            e.scale(200);
            rooster(e);
            e.popMatrix();

            songWords1 = "Over the past few years\nTo the traditional sounds of the English summer\nThe drone of lawnmowers\n" + 
                            "The smack of leather on willow\nHas been added a new noise\n";

            e.pushMatrix();
            e.translate(-2, 0);
            e.fill(0);
            e.textSize(40);
            lyrics1.render(e, songWords1);
            e.popMatrix();

        }

        if(e.getAudioPlayer().position() > 15000 && e.getAudioPlayer().position() < 28000 && e.paused == false) {

            e.background(198, 100, 100);
            songWords1 = "Over the past few years\nTo the traditional sounds of the English summer\nThe drone of lawnmowers\n" + 
                            "The smack of leather on willow\nHas been added a new noise\n";

            e.pushMatrix();
            e.translate(-2, 0);
            e.fill(0);
            e.textSize(40);
            lyrics1.render(e, songWords1);
            e.popMatrix();

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

            songWords2 = "What were the skies like when you were young?";
             
            e.pushMatrix();
            e.translate(-548, -200);
            e.fill(0);
            e.textSize(60);
            lyrics2.render(e, songWords2);
            e.popMatrix();

        }

        if(e.getAudioPlayer().position() > 28000 && e.getAudioPlayer().position() < 42000 && e.paused == false) {

            
            roosterY += 0.1f;

            e.pushMatrix();
            e.background(198, 100, 100);
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

        if(e.getAudioPlayer().position() > 44000 && e.getAudioPlayer().position() < 46000 && e.paused == false) {
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

        if(e.getAudioPlayer().position() > 46000 && e.paused == false) {

            if (e.keyCode == PConstants.BACKSPACE) {
                pit = 0;
                yaw = 0;
            } else if (e.key == 'q') {
                pit += 0.5f;
            } else if (e.key == 'a') {
                pit -= 0.5f;
            } else if (e.key == 'w') {
                yaw += 0.5f;
            } else if (e.key == 's') {
                yaw -= 0.5f;
            } else if (e.key == 'e') {
                pit += 0.5f;
                yaw += 0.5f;
            } else if (e.key == 'z' && alpha > 0) {
                alpha -= 0.5f;
            } else if (e.key == 'x' && alpha < 70) {
                alpha += 0.5f;
            }

            e.translate(e.width/2, e.height/2);

            e.rotateX(radians(pit));
            e.rotateY(radians(yaw));
            e.rotateZ(radians(rol));
            
            for(int i = 0; i < numLollipops; i++) {
                e.pushMatrix();
                lollipops[i].display(e);
                lollipops[i].update(); 
                e.popMatrix();       
            }
        

            c1 = (e.frameCount % 360);
            c2 = (e.frameCount % 360) / 2;

            e.pushMatrix();
            e.translate(-4, 0);
            cubeAngleY = e.frameCount * 0.01f;
            cubeAngleZ = e.frameCount * 0.01f; 
            e.rotateZ(cubeAngleZ);
            e.rotateY(cubeAngleY);
            e.stroke(c1, 100, 100, alpha);
            hyperCube.render(e);
            e.popMatrix();


            e.pushMatrix();
            e.translate(4, -8);
            cubeAngleY = e.frameCount * 0.01f;
            cubeAngleZ = e.frameCount * 0.01f; 
            e.rotateZ(cubeAngleZ);
            e.rotateY(cubeAngleY);
            e.stroke(c2, 100, 100, alpha);
            hyperCube.render(e);
            e.popMatrix();

        }

    }

}