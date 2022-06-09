# Programming Assignment 4

In this assignment you are to write programs to solve the following problems. As with all assignments, remember the
following submission steps:

- Make sure your code passes at least all the provided JUnit tests
- Create and test Javadoc code documentation
- Save, commit, and push all code changes
- Confirm the latest code is visible on your repository website

## Part A (PA4a.java)

Your task is to write a command-line program that helps to decrypt a message that has been encrypted using a Caesar
cipher . Using this method, a string may contain letters, numbers, and other ASCII characters, but only the letters
(upper- and lower-case) are encrypted – a constant number, the shift, is added to the ASCII value of each letter and
when letters are shifted beyond ‘z’ or ‘Z’ they are wrapped around (e.g. “Crazy?” becomes “Etcba?” when shifted by 2).

When your program is correctly run, it will be provided two strings: the encrypted message and a string that is in the
deciphered text. If fewer/more arguments are provided, your program is to output an error:

    $ java edu.wit.cs.comp1050.PA4a
    Please supply correct inputs: <encrypted string> <substring>

    $ java edu.wit.cs.comp1050.PA4a a
    Please supply correct inputs: <encrypted string> <substring>

    $ java edu.wit.cs.comp1050.PA4a a b c
    Please supply correct inputs: <encrypted string> <substring>

If the correct arguments are supplied, you are to output any shifts (00-25) that contain the supplied substring:

    $ java edu.wit.cs.comp1050.PA4a 'Jvtwbaly zjplujl pz mbu!' is
    09: Secfkjuh isyudsu yi vkd!
    19: Computer science is fun!

    $ java edu.wit.cs.comp1050.PA4a 'Jvtwbaly zjplujl pz mbu!' 'fun!'
    19: Computer science is fun!

If no shifts contain the substring, provide an error:

    $ java edu.wit.cs.comp1050.PA4a 'Jvtwbaly zjplujl pz mbu!' '?'
    No valid shifts found.

To build this program in an object-oriented fashion, you must first implement a Shifter class. This class is constructed
with the encrypted string, and then has methods to both shift by an arbitrary amount and find substrings across all
shifts.

To implement this class in an efficient manner, you should use a StringBuilder to shift the encrypted string. You might
also find it useful to use an ArrayList to accumulate an unknown number of valid shifts. Look to the JavaDoc’s of the
String class for methods to search a string for a substring.

## Part B (PA4b.java)

Your task is to write a program that will output colored shape vertices in CSV format (comma-separated value ; something
Microsoft Excel can open!). To build up to this capability, you will be implementing a set of classes, including two
subclasses. Here is the recommended sequence:

1.	To start, implement the Point2D class. It is quite similar to the class in a previous assignment, but now has you
    override the equals method to detect points that represent the same location, within a distance threshold.
2.	Then implement the Rectangle class, which is a subclass of Shape2D (provided for you). You will use simple
    arithmetic to implement such functionality as computing area, perimeter, and center point. The vertices (think
    corner points) for a rectangle are expected to start at the lower-left corner and proceed clockwise. Two rectangles
    are considered “equal” if they have lower-left and upper-right points that are “equal”.
3.	Now move on to the Triangle class, which is also a subclass of Shape2D. The math here can get a little more complex
    for area  and center point (centroid ). An axis-aligned bounding box (AABB ) is simply the rectangle that most
    closely bounds the vertices of the triangle. The vertices should be returned in the order they were provided in the
    constructor.
4.	Now move on to the PA4b class. The shapeVertices method receives an array of Shape2D objects and must produce a
    string which includes all the vertices in CSV format (on each line: "color",x,y). If the method encounters a
    triangle object, it should include the vertices of the AABB after the triangle. This is an opportunity to experiment
    with polymorphic code. When this method is complete, proceed to main – validate command-line arguments for a single
    colored triangle and use the method you just completed to output the corresponding CSV to the terminal.

Here are example runs of a completed program:

    $ java edu.wit.cs.comp1050.PA4b
    Please supply correct inputs: color x1 y1 x2 y2 x3 y3

    $ java edu.wit.cs.comp1050.solution.PA4b blue 0 0 0 1 1 0
    "blue",0.000,0.000
    "blue",0.000,1.000
    "blue",1.000,0.000
    "blue",0.000,0.000
    "blue",0.000,1.000
    "blue",1.000,1.000
    "blue",1.000,0.000

Note: if you copy-paste the output into a file (typically with a .csv extension) and open it in Excel, you could then plot the last two columns using an XY plot!

## Part C (PA4c.java)

Your task is to write a program that reads any number of integers from the console (via a Scanner), stores them in an
ArrayList, removes duplicates from the list, and then outputs the remaining distinct values. First, implement the
removeRepeated method, which removes duplicates from a supplied list – note that you are not allowed to use advanced
data structures (e.g. sets) to do this for you. Then implement the main method, which reads as many integers as the user
desires into an ArrayList, adds them to an ArrayList, uses the removeRepeated method, and then outputs the distinct
values. When you are testing your code in Eclipse, and are done typing integers, press enter (i.e. to proceed to a new
line) and then press CTRL+D (Mac) or CTRL+Z (Windows) to indicate to Eclipse that you are done typing (this is code for
EOF, or end-of-file; sometimes you may need to change focus to the code window and then back to the console for Eclipse
to properly register the EOF).

Below are example runs of a completed program…

    Enter integers: 
    No values entered.

    Enter integers: 1 2 3 2 1
    The distinct integer(s): 1 2 3

    Enter integers: 1 1 1 2 1 2 2 1 2 3 2 1 2 3 1 
    The distinct integer(s): 1 2 3

    Enter integers: 8 8 8 8 8 8 8 6 6 6 6 8 8 8 8 6 6 6 7 7 7 7 7 6 6 6 8 8 8 7 7 7 5 8 8 7 6 6 6 6 7 5 5 3 3 8 7 6 5 0 0 0 9 3 0 9 8 6 7 5
    The distinct integer(s): 8 6 7 5 3 0 9

