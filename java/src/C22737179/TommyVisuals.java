package C22737179;

import ddf.minim.AudioPlayer;
import ie.tudublin.*;

public class TommyVisuals extends Visual{

    
    Lollipop[] lollipops;
    int numLollipops = 25;


    public TommyVisuals() {

        lollipops = new Lollipop[numLollipops];
        for(int i = 0; i < numLollipops; i++) {
            lollipops[i] = new Lollipop(i, 25);
        }
        
    }
    
    public void draw(CallSet e) {

        this.g = e.getGraphics();
        
        if(e.paused == false) {
            
            colorMode(HSB, 360, 100, 100);
            background(80, 100, 100);

            translate(w(0.5f), h(0.5f));
            for(int i = 0; i < numLollipops; i++) {
                pushMatrix();
                lollipops[i].display(e);
                lollipops[i].update(); 
                popMatrix();       
            }
        }
        
    }

    public float w(float val) {
        if (val == 0) return g.width;
        return g.width * val;
    }
      
    public float h(float val) {
        if (val == 0) return g.height;
        return g.height * val;
    }

}