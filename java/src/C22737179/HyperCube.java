package C22737179;

public class HyperCube {

    public HyperCube() {

    }

    public void render(CallSet e) {

        e.calculateAverageAmplitude();

        e.pushMatrix();
        e.noFill();
        e.strokeWeight(2);
        e.box(50 + (100 * e.getAmplitude()));
        e.box(150 + (100 * e.getAmplitude()));
        e.box(300 + (100 * e.getAmplitude()));
        e.box(500 + (100 * e.getAmplitude()));
        e.popMatrix();
        

    }
}
