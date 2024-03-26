package C22737179;

public class DrawSphere {


    void setup() {
        
       
    }

    void draw(CallSet e, float x, float y) {

        e.pushMatrix();
        e.translate(x, y, 0);
        e.sphere(50);
        e.popMatrix();
        
    }

}
