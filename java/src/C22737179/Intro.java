package C22737179;

import ie.tudublin.*;
import processing.core.PGraphics;
import processing.core.PShape;

public class Intro extends Visual{
    
        
        float startTime;
        float speed;
        float roosterX;
        PShape rooster;
    
        public Intro(PGraphics pg) {
            this.g = pg;
            this.rooster = g.loadShape("GS0D6S94RVZNHC4AZDRXMJDLF.obj");
            this.speed = g.width / 5.0f;
            this.roosterX = -100;
            this.startTime = millis();
        }

        public void draw(CallSet e) {

            this.g = e.getGraphics();
            e.background(255);
            rooster();

        }

        public void rooster() {

            pushMatrix();
            
            float elapsedTime = millis() - startTime;

            roosterX = (elapsedTime / 1000.0f) * speed;

            if(roosterX < g.width / 2) {
                translate(roosterX, g.height / 2);
            } else {
                translate(g.width / 2, g.height / 2);
            }

            
            //translate(g.width / 2, g.height / 2);
            rotateX(0);
            rotateY(45);
            rotateZ(210);
            scale(200);
            shape(rooster);
            popMatrix();

        }
    
        
}
