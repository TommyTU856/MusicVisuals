package C22737179;
import processing.core.PApplet;

class TimeClock {

    PApplet pa; 

    public TimeClock(PApplet pa) {
        this.pa = pa;
    }

    public void drawTimeClock() {
        //pa.background(pa.color(142, 228, 175)); // Use color() function for background color
        
        pa.translate(pa.width/2, pa.height/2);
        pa.pushMatrix();
        // rotate coordinate system so that 0 is located at the top
        pa.rotate(-pa.HALF_PI);
        
        // Arc display for hour
        float H_a = pa.map(pa.hour(), 0, 23, 0, pa.TWO_PI);
        pa.noFill();
        pa.stroke(pa.color(5, 56, 107)); // Use color() function for stroke color
        pa.strokeWeight(60);
        pa.arc(50, 0, 400, 400, 0, H_a);
        
        // Arc display for minute
        float M_a = pa.map(pa.minute(), 0, 59, 0, pa.TWO_PI);
        pa.stroke(pa.color(55, 150, 131)); // Use color() function for stroke color
        pa.strokeWeight(30);
        pa.arc(30, 0, 250, 250, 0, M_a);
        
        // Arc display for second
        float S_a = pa.map(pa.second(), 0, 59, 0, pa.TWO_PI);
        pa.stroke(pa.color(92, 219, 149)); // Use color() function for stroke color
        pa.strokeWeight(15);
        pa.arc(20, 0, 150, 150, 0, S_a);
        pa.popMatrix();
        
        // Display time of day as text
        pa.fill(pa.color(237, 245, 225)); // Use color() function for text color
        pa.textSize(30);
        pa.textAlign(pa.CENTER, pa.CENTER);
        String time = pa.hour() + ":" + pa.minute() + ":" + pa.second(); // join time values into a string
        pa.text(time, 0, 0);
    }
}
