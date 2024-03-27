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

    public TommyVisuals() {  
        lyrics1 = new Lyrics();
        lyrics2 = new Lyrics();
        hyperCube = new HyperCube();
        drawSphere = new DrawSphere();
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
        //e.stroke(map(e.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);

        e.noStroke();
        /* if (e.getSmoothedAmplitude() > 0.05) {
            e.fill(e.random(0,360), 250, 250);
        } */
        
        float sphereSize = 10 + (200 * e.getSmoothedAmplitude()); 
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
        e.background(0, 0, 0);
        e.calculateAverageAmplitude();
        

        /* hyperCube = new HyperCube();

        e.pushMatrix();
        e.translate(e.width / 2 - 4, e.height / 2);
        cubeAngleY = e.frameCount * 0.01f; 
        //e.rotateY(cubeAngleY);
        //e.stroke(0, 100, 50);
        e.stroke(240, 100, 50);
        hyperCube.render(e);
        e.popMatrix();

        e.pushMatrix();
        e.translate(e.width / 2 + 4, e.height / 2 - 8);
        cubeAngleY = e.frameCount * 0.01f;
        
        

        if(totalRotationZ < 30) {
            cubeAngleZ = e.frameCount * 0.01f; 
            e.rotateZ(cubeAngleZ);
            totalRotationZ += cubeAngleZ;
        } else {
            
            e.rotateY(cubeAngleY);
            e.rotateZ(PI / 4);
        }
        
        
        e.stroke(0, 100, 50);
        //e.stroke(240, 100, 50);
        hyperCube.render(e);
        e.popMatrix(); */

        /* responsiveShape = new ResponsiveShape();
        
        e.pushMatrix();
        e.translate(e.width / 2, e.height / 2);
        e.rotateX(rotX);
        //e.stroke(0, 100, 20);
        //e.stroke(240, 100, 20);
        //e.stroke(0, 100, 20);
        e.stroke(240, 100, 50);
        responsiveShape.render(e);
        e.popMatrix(); 

        
        e.pushMatrix();
        e.translate(e.width / 2 + 8, e.height / 2);
        e.rotateX(rotX);
        e.stroke(0, 100, 50);
        //e.stroke(240, 100, 20);
        //e.stroke(0, 100, 20);
        //e.stroke(240, 100, 50);
        responsiveShape.render(e);
        e.popMatrix();
 */

        /* e.pushMatrix();
        e.translate(e.width / 2 - 4, e.height / 2);
        e.rotateY(rotY);
        e.stroke(0, 0, 50);
        responsiveShape.render(e);
        e.popMatrix(); */


        /* e.pushMatrix();
        e.translate(e.width / 2 + 4, e.height / 2 - 3);
        e.rotateY(-rotY);
        e.stroke(10, 50, 80);
        responsiveShape.render(e);
        e.popMatrix(); */

        /* rotZ += .001;
        rotY += .001;
        rotX += .001; */
       
        /* e.pushMatrix();
        //e.translate(e.width / 2 - 10, e.height / 2);
        //e.stroke(0, 100, 50);
        e.fill(0, 100, 20);
        e.circle(e.width / 2 - 60, e.height / 2, 200);
        e.popMatrix(); */

        /* e.pushMatrix();
        e.translate(e.width / 2 + 10, e.height / 2);
        e.noStroke();
        e.fill(0, 100, 50);
        //e.circle(e.width / 2 - 30, e.height / 2, 200);
        showSphere(e);
        e.popMatrix();

    
        e.pushMatrix();
        e.translate(e.width / 2 - 10, e.height / 2);
        e.noStroke();
        e.fill(240, 100, 50);
        showSphere(e);
        //e.circle(e.width / 2, e.height / 2, 200);
        e.popMatrix(); */





//                          ------------START OF TIMED CODE--------------

        //String songWords = "Over the past few years To the traditional sounds of the English summer The drone of lawnmowers The smack of leather on willow";
        //lyrics = new Lyrics();
        //lyrics.render(e);
        

        if(e.getAudioPlayer().position() > 1 && e.getAudioPlayer().position() < 2000 && e.paused == false) {

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
        
        if(e.getAudioPlayer().position() > 4800 && e.getAudioPlayer().position() < 28000 && e.paused == false) {

            songWords1 = "Over the past few years\nTo the traditional sounds of the English summer\nThe drone of lawnmowers\n" + 
                            "The smack of leather on willow\nHas been added a new noise\n";

            e.pushMatrix();
            e.translate(-2, 0);
            e.fill(240, 100, 50);
            e.textSize(40);
            lyrics1.render(e, songWords1);
            e.popMatrix();

            e.pushMatrix();
            e.translate(2, 0);
            e.fill(0, 100, 50);
            e.textSize(40);
            lyrics1.render(e, songWords1);
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

            songWords2 = "What were the skies like when you were young?";
            
                    // \nThey went on forever and they, when I, we lived in Arizona\n" +
                    //"And the skies always had little fluffy clouds in them and, er\nThey were long and clear and"; 

            e.pushMatrix();
            e.translate(-548, -200);
            e.fill(0, 100, 50);
            e.textSize(60);
            lyrics2.render(e, songWords2);
            e.popMatrix();

            e.pushMatrix();
            e.translate(-552, -200);
            e.fill(240, 100, 50);
            e.textSize(60);
            lyrics2.render(e, songWords2);
            e.popMatrix();


            
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

        if(e.getAudioPlayer().position() > 46000 && e.getAudioPlayer().position() < 74400 && e.paused == false) {

            e.calculateAverageAmplitude();

            e.pushMatrix();
            e.translate(e.width / 2 - 4, e.height / 2);
            cubeAngleY = e.frameCount * 0.01f;
            cubeAngleZ = e.frameCount * 0.01f; 
            e.rotateZ(cubeAngleZ);
            totalRotationZ += cubeAngleZ;
            e.rotateY(cubeAngleY);
            e.rotateZ(PI / 4);
            //e.rotateY(cubeAngleY);
            //e.stroke(0, 100, 50);
            e.stroke(240, 100, 50);
            hyperCube.render(e);
            e.popMatrix();



            e.pushMatrix();
            e.translate(e.width / 2 + 4, e.height / 2 - 8);
            cubeAngleY = e.frameCount * 0.01f;
            cubeAngleZ = e.frameCount * 0.01f; 
            e.rotateZ(cubeAngleZ);
            totalRotationZ += cubeAngleZ;
            e.rotateY(cubeAngleY);
            e.rotateZ(PI / 4);
            e.stroke(0, 100, 50);
            //e.stroke(240, 100, 50);
            hyperCube.render(e);
            e.popMatrix();

        }

        if(e.getAudioPlayer().position() > 74400 && e.getAudioPlayer().position() < 84000 && e.paused == false) {


            e.pushMatrix();
            e.translate(e.width / 2 - 4, e.height / 2);
            cubeAngleY = e.frameCount * 0.01f;
            cubeAngleZ = e.frameCount * 0.01f; 
            e.rotateZ(cubeAngleZ);
            totalRotationZ += cubeAngleZ;
            e.rotateY(cubeAngleY);
            e.rotateZ(PI / 4);
            //e.rotateY(cubeAngleY);
            e.stroke(0, 100, 50);
            //e.stroke(240, 100, 50);
            hyperCube.render(e);
            e.popMatrix();



            e.pushMatrix();
            e.translate(e.width / 2 + 4, e.height / 2 - 8);
            cubeAngleY = e.frameCount * 0.01f;
            cubeAngleZ = e.frameCount * 0.01f; 
            e.rotateZ(cubeAngleZ);
            totalRotationZ += cubeAngleZ;
            e.rotateY(cubeAngleY);
            e.rotateZ(PI / 4);
            //e.stroke(0, 100, 50);
            e.stroke(240, 100, 50);
            hyperCube.render(e);
            e.popMatrix();

            e.pushMatrix();
            e.noFill();
            e.stroke(0, 100, 50);
            e.translate(e.width / 2, e.height / 2);
            e.sphere(100 + (1000 * e.getAmplitude()));
            e.popMatrix(); 

            e.pushMatrix();
            e.noFill();
            e.stroke(240, 100, 50);
            e.translate(e.width / 2 + 4, e.height / 2);
            e.sphere(100 + (1000 * e.getAmplitude()));
            e.popMatrix();
 
        }


        if(e.getAudioPlayer().position() > 84000 && e.getAudioPlayer().position() < 100000 && e.paused == false) {


            e.pushMatrix();
            e.translate(e.width / 2 - 4, e.height / 2);
            cubeAngleY = e.frameCount * 0.01f;
            cubeAngleZ = e.frameCount * 0.01f; 
            e.rotateZ(cubeAngleZ);
            totalRotationZ += cubeAngleZ;
            e.rotateY(cubeAngleY);
            e.rotateZ(PI / 4);
            //e.rotateY(cubeAngleY);
            e.stroke(0, 100, 50);
            //e.stroke(240, 100, 50);
            hyperCube.render(e);
            e.popMatrix();



            e.pushMatrix();
            e.translate(e.width / 2 + 4, e.height / 2 - 8);
            cubeAngleY = e.frameCount * 0.01f;
            cubeAngleZ = e.frameCount * 0.01f; 
            e.rotateZ(cubeAngleZ);
            totalRotationZ += cubeAngleZ;
            e.rotateY(cubeAngleY);
            e.rotateZ(PI / 4);
            //e.stroke(0, 100, 50);
            e.stroke(240, 100, 50);
            hyperCube.render(e);
            e.popMatrix();

            e.pushMatrix();
            e.noFill();
            e.stroke(0, 100, 50);
            e.translate(e.width / 2, e.height / 2);
            e.sphere(100);
            e.popMatrix(); 

            e.pushMatrix();
            e.noFill();
            e.stroke(240, 100, 50);
            e.translate(e.width / 2 + 4, e.height / 2);
            e.sphere(100);
            e.popMatrix();

            e.pushMatrix();
            e.circle(e.width / 6, e.height / 2, 100);
            e.popMatrix();
 
        }

         

        

            /* sphereX1 = e.width / 8;
            sphereX2 = e.width / 8;
            sphereX3 = e.width / 8;
            sphereX4 = e.width / 8 * 7;
            sphereX5 = e.width / 8 * 7;
            sphereX6 = e.width / 8 * 7;

            
            sphereY1 = e.height / 6;
            sphereY2 = e.height / 2;
            sphereY3 = e.height / 6 * 5;
            sphereY4 = e.height / 6;
            sphereY5 = e.height / 2;
            sphereY6 = e.height / 6 * 5;
            
            
            float maxSphereMove = 100;
            float sphereMoveZ = Visual.map(-Math.abs(100 * e.getAmplitude()), 0, 1, 0, maxSphereMove);
            float sphereMoveY = Visual.map(-Math.abs(100 * e.getAmplitude()), 0, 1, 0, maxSphereMove);
    
            sphereX1 = Visual.lerp(sphereX1, e.width / 4 + sphereMoveZ, 0.1f);
            sphereX2 = Visual.lerp(sphereX2, e.width / 2 + sphereMoveZ, 0.1f);
            sphereX3 = Visual.lerp(sphereX3, 3 * e.width / 4 + sphereMoveZ, 0.1f);
            
            sphereY1 = Visual.lerp(sphereY1, e.height / 2 + sphereMoveY, 0.1f);
            sphereY2 = Visual.lerp(sphereY2, e.height / 2 + sphereMoveY, 0.1f);
            sphereY3 = Visual.lerp(sphereY3, e.height / 2 + sphereMoveY, 0.1f);
            sphereY4 = Visual.lerp(sphereY4, e.height / 2 + sphereMoveY, 0.1f);
            sphereY5 = Visual.lerp(sphereY5, e.height / 2 + sphereMoveY, 0.1f);
            sphereY6 = Visual.lerp(sphereY6, e.height / 2 + sphereMoveY, 0.1f);

            e.pushMatrix();
            e.stroke(0, 100, 50);
            drawSphere.draw(e, sphereX1, sphereY1);
            drawSphere.draw(e, sphereX2, sphereY2);
            drawSphere.draw(e, sphereX3, sphereY3);
            e.popMatrix();

            e.pushMatrix();
            e.stroke(240, 100, 50);
            drawSphere.draw(e, sphereX4, sphereY4);
            drawSphere.draw(e, sphereX5, sphereY5);
            drawSphere.draw(e, sphereX6, sphereY6);
            e.popMatrix();

            e.pushMatrix();
            e.stroke(240, 100, 50);
            drawSphere.draw(e, sphereX1 + 4, sphereY1);
            drawSphere.draw(e, sphereX2 + 4, sphereY2);
            drawSphere.draw(e, sphereX3 + 4, sphereY3);
            e.popMatrix();

            e.pushMatrix();
            e.stroke(0, 100, 50);
            drawSphere.draw(e, sphereX4 + 4, sphereY4);
            drawSphere.draw(e, sphereX5 + 4, sphereY5);
            drawSphere.draw(e, sphereX6 + 4, sphereY6);
            e.popMatrix(); */


            //print(sphereMoveZ);

        /* float angleIncrement = TWO_PI / 10;
            float radius = 100;

            for (float phi = 0; phi <= TWO_PI; phi += angleIncrement) {
                float circleZ = e.height / 2 + Visual.cos(phi) * radius;
        
                e.beginShape();
                for (float theta = 0; theta <= TWO_PI; theta += angleIncrement) {
                    float circleX = e.width / 2 + Visual.cos(theta) * radius * Visual.sin(phi);
                    float circleY = e.height / 2 + Visual.sin(theta) * radius * Visual.sin(phi);
                    e.stroke(0,0,100);
                    e.vertex(circleX, circleY, circleZ);

                    circleX = e.width / 2 + Visual.cos(theta) * radius * Visual.sin(phi + angleIncrement);
                    circleY = e.height / 2 + Visual.sin(theta) * radius * Visual.sin(phi + angleIncrement);
                    e.vertex(circleX, circleY, circleZ);

                }
                e.endShape(CLOSE);
            } */

        //* e.translate(e.width / 2, e.height / 2);
        //showSphere(e, 5);
        //print(e.width, e.height);
        print(e.getAudioPlayer().position() + "\n");
        //print(e.getSmoothedAmplitude() + "\n");
    }

}