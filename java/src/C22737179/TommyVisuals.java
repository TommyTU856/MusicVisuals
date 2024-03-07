package C22737179;

import ie.tudublin.*;

public class TommyVisuals extends Visual{
    
    public void render(CallSet e) {
        
        this.g = e.getGraphics(); // Initialize the "g" variable
        background(0);
        stroke(255);
        line(50, 50, 300, 300);

    }



}