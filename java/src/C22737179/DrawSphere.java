package C22737179;

public class DrawSphere {


    void setup() {
        
       
    }

    void draw(CallSet e, float x, float y) {

        e.pushMatrix();
        e.translate(x, y, 0);
        e.strokeWeight(1);
        e.sphere(100);
        e.popMatrix();
        
    }

}
