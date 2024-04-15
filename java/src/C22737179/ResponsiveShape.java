package C22737179;

import ie.tudublin.Visual;

public class ResponsiveShape {

    int vert = 11;

    public ResponsiveShape() {
        
    }

    public void render(CallSet e) {
        
        for(int i = 0; i < vert; i++) {
            for(int j = 0; j < vert; j++) {
                for(int k = 0; k < vert; k++) {
                    float x = Visual.map(i, 0, vert, -300, 300);
                    float y = Visual.map(j, 0, vert, -300, 300);
                    float z = Visual.map(k, 0, vert, -300, 300);
                    e.strokeWeight(8);
                    e.point(x, y, z); 
                }
            }
        }

    }    
}
