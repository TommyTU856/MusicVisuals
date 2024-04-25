package C22737179;
import ie.tudublin.*;

public class Ellipse extends Visual {

    private EllipseProperties properties;
    private EllipseDrawer drawer;

    public Ellipse(float x, float y, float angle, int value) {
        this.properties = new EllipseProperties(x, y, angle, value);//Ellipse Properties Class Object
        this.drawer = new EllipseDrawer(properties);//Ellipse Drawer class object taking Properties object as argument
    }

    public void draw(CallSet e) {
        drawer.draw(e);//Call EllipseDrawer class draw() method
    }

}
    

