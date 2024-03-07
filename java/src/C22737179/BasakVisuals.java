package C22737179;

import ie.tudublin.*;

public class BasakVisuals extends Visual {
    
    public void render(CallSet e) {
        
        this.g = e.getGraphics(); // Initialize the "g" variable
        background(0);
        stroke(255);
        line(800, 50, 1100, 300);

    }


}
