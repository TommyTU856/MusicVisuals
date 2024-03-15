package C22737179;

import ie.tudublin.*;

public class TommyVisuals extends Visual{


    Lollipop[] lollipops;
    int numLollipops = 25;
    float radius = 25;
    int p;

    public TommyVisuals() {

        lollipops = new Lollipop[numLollipops];
        for(int i = 0; i < numLollipops; i++) {
            lollipops[i] = new Lollipop(i, radius);
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
            p = p + 1;
            println(p);
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