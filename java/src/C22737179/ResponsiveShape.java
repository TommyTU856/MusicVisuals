package C22737179;

import ie.tudublin.Visual;

public class ResponsiveShape {

    int vert = 11;

    public ResponsiveShape() {
        
    }

    public void render(CallSet e) {

        //e.background(0);
        //e.translate(e.width / 2, e.height / 2);
        
        for(int i = 0; i < vert; i++) {
            for(int j = 0; j < vert; j++) {
                for(int k = 0; k < vert; k++) {
                    float x = Visual.map(i, 0, vert, -300, 300);
                    float y = Visual.map(j, 0, vert, -300, 300);
                    float z = Visual.map(k, 0, vert, -300, 300);
                    e.strokeWeight(8);
                    e.point(x, y, z);
                    //e.triangle(x, y, x / 2, y / 2, x / 4, y / 4); 
                }
            }
        }

    }    
}
