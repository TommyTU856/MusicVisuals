package C22737179;

public class Lyrics {

    /* String lyrics = "Over the past few years\nTo the traditional sounds of the English summer\nThe drone of lawnmowers\n" + 
                    "The smack of leather on willow\nHas been added a new noise\n"; */
                    
    /* String lyrics2 = "What were the skies like when you were young?\nThey went on forever and they, when I, we lived in Arizona\n" +
                    "And the skies always had little fluffy clouds in them and, er\nThey were long and clear and"; */

    int index = 1; 
    int xPos = 700;
    int yPos = 350; 
    int typingSpeed = 30; 


    public void render(CallSet e, String lyrics) {

        
        
        //e.textSize(40);
        //e.fill(0, 0, 100);
        e.text(lyrics.substring(0, index), xPos, yPos);
  
  
        if (index < lyrics.length()) {
            index += 1;
            e.delay(typingSpeed);
        }
    }

}
