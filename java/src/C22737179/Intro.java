package C22737179;

import ie.tudublin.*;

public class Intro  extends Visual{
    
        
    
        public Intro() {
        }
    
        public void draw(CallSet e) {
            e.background(0);
            e.textAlign(e.CENTER, e.CENTER);
            e.textSize(32);
            e.fill(255);
            e.text("Press space to play", e.width / 2, e.height / 2);
        }
}
