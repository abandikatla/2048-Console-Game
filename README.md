# 2048-Console-Game
2048 Game with Console input 

***************** INSTRUCTIONS TO PLAY **********************

1. The game begins with a 4x4 matrix, with all zeroes except one. When atleast one tile has 2048 value, the player wins.
2. The player is allowed 4 different types of moves : left, right, up or down. The move has to be typed in as string on the console. Enter "exit" to exit the game.
3. Refer https://gabrielecirulli.github.io/2048/ for further details.

***************** How To Compile **********************
mvn clean package

***************** How To Run **********************
java -cp target/2048-Console-Game-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.abandikatla.game.App

