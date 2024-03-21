package C22737179;
import ie.tudublin.*;

public class EllipseProperties extends Visual {
    float x; // height
    float y; // width
    float angle;
    int value;
    float value2;

    public EllipseProperties(float x, float y, float angle, int value) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.value = value;
        this.value2 = x * sin(radians(angle));
    }
    
}
