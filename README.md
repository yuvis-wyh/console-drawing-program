# drawing-program

# how to run the project
- This is a java maven project.
- Please run DrawingProgram.java to start the program.

# assumptions
- Case insensitive for input command.
- Allow 1 or more whitespaces in between 2 inputs.
- Filled color can be changed.
- New canvas can be created at anytime. 
- The maximum width and height of the canvas will be 80x300.

# special cases
- Color can be changed back to defult background color.
enter command: C 18 5
--------------------
|                  |
|                  |
|                  |
|                  |
|                  |
--------------------
enter command: L 1 3 7 3
--------------------
|                  |
|                  |
|xxxxxxx           |
|                  |
|                  |
--------------------
enter command: L 3 1 3 5
--------------------
|  x               |
|  x               |
|xxxxxxx           |
|  x               |
|  x               |
--------------------
enter command: B 1 1 o
--------------------
|oox               |
|oox               |
|xxxxxxx           |
|  x               |
|  x               |
--------------------
enter command: B 1 1
--------------------
|  x               |
|  x               |
|xxxxxxx           |
|  x               |
|  x               |
--------------------

- Not allowed to fill color on a drawn grid.
enter command: C 18 5
--------------------
|                  |
|                  |
|                  |
|                  |
|                  |
--------------------
enter command: R 1 1 7 3
--------------------
|xxxxxxx           |
|x     x           |
|xxxxxxx           |
|                  |
|                  |
--------------------
enter command: B 1 1 o
[1,1] is occupied
