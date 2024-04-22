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

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
In this project, our team collaborated to create four unique visualizations using Java Processing, with each section contributed by a different team member. Our chosen song is “Little Fluffy Clouds” by The Orb. The goal was to develop visualizations that respond dynamically to music, adjusting colours, shapes, and sizes based on the amplitude and frequency of the audio. To extract audio data from MP3 files, we utilized the Audio Minim library.

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

# What I am most proud of in the assignment

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

