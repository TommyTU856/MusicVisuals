# Music Visualiser Project

# Group Members
| Name | Student Number |
|-----------|-----------|
|Aaron Baggot | C22716399 |
|Thomas Burke | C22737179 |
|Aniket Bedade | C22737179 |
|Basak Deveci | D22124576 |

# Video Of Our Visualisations
[<img src="Image of Youtube link here" width="600px" target="_blank">](Youtube Link Here "Our group Video")


# Description of the assignment
In this project, our team collaborated to create four unique visualizations using Java Processing, with each section contributed by a different team member. Our chosen song is "Little Fluffy Clouds" by The Orb. The goal was to develop visualizations that respond dynamically to music, adjusting colours, shapes, and sizes based on the amplitude and frequency of the audio. To extract audio data from MP3 files, we utilized the Audio Minim library.

The implementation consists of several classes and components, each serving a specific purpose:

Minim, AudioInput, and FFT: These classes from the Minim library handle audio input and fast Fourier transform (FFT) analysis, allowing us to extract features such as amplitude and frequency from the audio.
Visual Elements: Various visual elements, including shapes, images, and text, are used to create the visualizations. These elements respond to the audio features and change dynamically over time.


# Instructions
Execution: 
Run the main.java file located in the ie\tudublin package to start the project.
Controls and Functionality:
Play/Pause: 
Use the space bar to toggle between pausing and resuming the audio playback.
Visualization Selection: 
Switch between different visualizations by pressing the 6, 7, 8, and 9 keys. Each key corresponds to a specific visualization created by Tommy, Aniket, Basak, and Aaron, respectively.
Reset: Press "r" to reset the song to its beginning.
Automatic Transitions: 
Note that the visualizations automatically transition at specific segments of the song to match the corresponding visuals.

# How it works
Each visualization is encapsulated within its own class, all residing within the same package. The driver file for the project is CallSet.java. In this project, objects were instantiated for each visualization. Utilizing inheritance, methods like "calculateAverageAmplitude" from the Visual class were inherited. Minim was employed to load the audio file "LittleFluffyClouds.mp3" within the setup method. Additionally, assets such as .obj files and .png pictures were loaded.
The code utilizes the Minim library for audio processing. It initializes audio objects such as AudioInput and FFT to analyse the audio input. The draw method continuously updates and renders the visuals based on the audio amplitude and frequency.

'''
 	AaronVisuals Aaron = new AaronVisuals();
    AniketVisuals Aniket = new AniketVisuals();
    BasakVisuals Basak = new BasakVisuals();
    TommyVisuals Tommy = new TommyVisuals();
'''
    
'''
public void keyPressed()
    {
        if (key >= '5' && key <= '9')
        {
		    mode = key - '0';
	    }

        switch (key)
        {
            case '5':
            {
                if (paused)
                {
                    getAudioPlayer().play();
                    paused = false;
                }

                else
                {
                    getAudioPlayer().pause();
                    paused = true;
                }

                break;
            }

            case '1':
            {
                getAudioPlayer().play();
                break;
            }

            case 'r':
            {
                getAudioPlayer().cue(0);
                getAudioPlayer().play();
                break;
            }
        }
        
    }
	
'''

### Section 1 - Aaron

![Aaron's visual](link to images)

### Section 2 - Tommy
![TommyVisual](https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/vis9.png)
![TommyVisual](https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/vis1.png)
![TommyVisual](https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/vis2.png)
![TommyVisual](https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/vis3.png)
![TommyVisual](https://github.com/TommyTU856/MusicVisuals/blob/master/.vscode/Images/vis7.png)


### Section 3 - Basak

![Basak's visual](link to images)



### Section 4 - Aniket

![Aniket's visual](link to images)

# Accomplishments in Our Assignment - What we are most proud of.
Our collaboration on this assignment, centered around a song featuring skies and clouds, was a testament to our teamwork and dedication. Throughout the process, we navigated various challenges, particularly concerning the implementation across different operating systems, Mac and Windows. Despite initial differences in ideas, we effectively coordinated our efforts to synchronize colors, map amplitudes, shape visuals, integrate a clock, and even incorporate a rooster object in OBJ format, all harmonized to the music.

Working closely with our lecturer during labs, we overcame obstacles together and grew in our understanding of advanced concepts. Our regular meetings allowed us to discuss our progress and ensure alignment with our goals. Utilizing tools like Git enhanced our collaboration and will undoubtedly benefit us in future career endeavors and team projects.

The diversity of elements in our project, including cubes, various cloud formations, rain effects, responsive shapes, lollipops, balls, lyrics integration, ellipses, and stars, showcases our comprehensive exploration of visualizations. Our use of inheritance, polymorphism, the PApplet library, and other programming principles reflects the depth of our learning in this module.

Ultimately, seeing the final project come together was immensely rewarding, reaffirming our hard work and dedication as a group. This experience has not only enriched our understanding but also provided us with invaluable lessons and memories to carry forward in our academic and professional journeys.


# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

