# Tennis Game Computer

Simple project of Tennis Score computer

## How to run

`mvn compile exec:java -D"exec.mainClass"="org.bevilacqua1996.Main" -D"exec.args"="<game1> <game2>"`

Example: `mvn compile exec:java -D"exec.mainClass"="org.bevilacqua1996.Main" -D"exec.args"="ABABABBAAA BBBB"`

Since you have maven installed on your development environment, you can package(`mvn clean install`) your application and run through executable jar.

Exemple: `java -jar .\tennis-score-1.0-SNAPSHOT-jar-with-dependencies.jar AAAA ABABBAABBB`

Each argument after the command will be one game. For each win ball, the program will write the currently points for Player A and B and at the end who won the game.
If game doesn't have an end, the program will show the following message: **There is no winner for this game input!**
Also, if input comes with at least one character different from A or B, the program will show the following message: **Not a valid Input**

## Architecture

![tennisGameArchitecture](https://github.com/bevilacqua1996/TennisScoreGame/assets/18063196/77a351c9-5b96-435f-a451-5541a7e29451)

Regarding the architecture and organization of the code, the program is dived in three parts:

- Input Block;
- Logic Block;
- Output Block.

Logic block will take care of rules of the game. Basically, all the Tennis game rules is handled by Logic Block.

Input Block will process the arguments. At first, we have an interface **InputData** which any form of input will have to implement this interface and its method _process_.
So far, we only have one concrete class implementing **InputData** (SimpleInputString), however if we have a new requirement that asks for a new kind of Input, we just need to create a new concrete class implementing **InputData** interface and configure it at **InputEnum**.
The chosen Input is defined by the _app.properties_ file, specifically on property `architecture.input`.

Same thing is going to happen for Output block, where we have an interface **OutputScores** which any concrete class of output has to implement this interface and its method _print_.
So far, we have two concrete classes, **OutputLog** and **OutputSysout**. The chosen output is defined also by the _app.properties_ file, specifically on property `architecture.output`.

This structure is implemented, in order to try to be more agnostic to the Input and Output format.

## Tests

We also have unit tests covering some situations which can happen in a Tennis game.
Unit tests were designed to test mainly the business rule of the program, so the main goal of Unit tests in this case is test the **Logic block**, and the different situations that can happen in a Tennis game.
