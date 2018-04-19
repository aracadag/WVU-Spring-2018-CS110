Double-Exposure Generator

by Alan Racadag

CS 110 Spring 2018 at WVU

My class "CrossFade" contains a method that produces a
double-exposure image of two images of Lena Soderberg.
The user may specify a number from 0 to 10 that controls
how present the second, more recent image of Lena appears
in the double-exposure image (0 being not present at all
and 10 being totally present without the older image).

The class "CrossFadeTester" tests the "CrossFade" class,
and this is the class you should run. When run, input will
be taken from the user to specify the opacity of the second
image via the text console. Following this, a new display
window will display the original two images and the new
double exposure. After this, the program terminates.

If the user inputs anything outside the accepted range
of 0-10 or inputs something that is not an integer,
the program terminates.