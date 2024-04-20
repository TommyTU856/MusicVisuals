package C22737179;

public class HyperCube {


    float boxSize2 = 150;
    float grow1;

    public HyperCube() {

    }

    public void render(CallSet e) {

        
        e.calculateAverageAmplitude();

        e.pushMatrix();
        e.noFill();
        e.strokeWeight(2);
        e.box(50 + (1000 * e.getAmplitude()));
        e.box(150 + (100 * e.getAmplitude()));
        e.box(300 + (100 * e.getAmplitude()));
        e.box(500 + (2000 * e.getAmplitude()));
        e.popMatrix();
        
        
    }
}
