package C22737179;
import ie.tudublin.*;

public class Ellipse extends Visual {

    private EllipseProperties properties;
    private EllipseDrawer drawer;

    public Ellipse(float x, float y, float angle, int value) {
        this.properties = new EllipseProperties(x, y, angle, value);
        this.drawer = new EllipseDrawer(properties);
    }

    public void draw(CallSet e) {
        drawer.draw(e);
    }

}
    

