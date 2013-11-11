Litty's Game of Life
====================

A Java implementation of Conway's Game of Life. Made with Slick2D, a game engine wrapper for LWJGL.

The repository is nested into directories to match the main Java package: com.alexlitty.asynchrony.littylife

Build Instructions
------------------

Before compiling, add the following .jar files (found in /lib) to the classpath:

```
lwjgl.jar
slick.jar
jinput.jar
lwjgl_util.jar
```

Change the Java library path to:

```
x/lib/natives/y
```
Where x is the absolute path to the /lib folder, and y is windows, mac, or linux.

If you're not using an IDE, the final command for compilation is:

```
javac -cp .:com/alexlitty/asynchrony/littylife/lib/slick.jar com/alexlitty/asynchrony/littylife/LittyLife.java
```

Play the game! I recommend breathing exercises before you begin, it's pretty hardcore:

```
java -cp .:com/alexlitty/asynchrony/littylife/lib/* -Djava.library.path=x/com/alexlitty/asynchrony/littylife/lib/natives/y com/alexlitty/asynchrony/littylife/LittyLife
```
