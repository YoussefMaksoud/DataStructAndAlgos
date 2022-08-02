# Assignment 1

## Build instructions

javac MainTraversalProgram.java Matrix.java TraversalClass.java FileReadHelper.java

It should compile all the java source files that need to be re-built. The build has been tested with Terminal mac OS sierra.

## Usage

From the Command Prompt, type "java" with a class name of the program. Then type the name of the textfile as a command line argument. The list of textfiles is as following:

3x3_data.txt
5x5_data.txt
7x7_data.txt
9x9_data.txt
11x11_data.txt

As example, if MainTraversalProgram.java produces MainTraversalProgram.class after compliation, then type as below:

java  MainTraversalProgram 3x3_data.txt

If all goes well, the program will produce three files called NxN_Graph.txt, NxN_DFT.txt, NxN_MST.txt should have been created in your directory containing the program output (depends on the neighbourhood dimensions of the input data).


