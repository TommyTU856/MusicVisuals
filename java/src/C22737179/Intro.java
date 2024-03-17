package C22737179;

import ie.tudublin.*;
import processing.core.PShape;

public class Intro extends Visual{
    
        PShape rooster;
    
        public Intro() {
        }

        public void rooster() {

            pushMatrix();
            rooster = loadShape("GS0D6S94RVZNHC4AZDRXMJDLF.obj");
            scale(200);
            shape(rooster);
            popMatrix();

        }
    
        public void draw(CallSet e) {
            this.g = e.getGraphics();
            e.background(255);
            rooster();

        }
}
