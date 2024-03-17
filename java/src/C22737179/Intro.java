package C22737179;

import ie.tudublin.*;
import processing.core.PShape;

public class Intro extends Visual{
    
        PShape rooster;
    
        public Intro() {
        }

        public void rooster() {
            pushMatrix();
            rooster = loadShape("java/data/GS0D6S94RVZNHC4AZDRXMJDLF.obj");
            shape(rooster);
            popMatrix();

        }
    
        public void draw(CallSet e) {

            e.background(0);
            rooster();

        }
}
