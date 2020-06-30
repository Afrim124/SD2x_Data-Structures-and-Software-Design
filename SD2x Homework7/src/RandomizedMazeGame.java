import java.util.Collections;
import java.util.Random;

public class RandomizedMazeGame extends MazeGame {

	public RandomizedMazeGame() {
		super();
	}

	public Maze randomize(int roomNumbers) {
		Random r = new Random(roomNumbers);
		MazeGame mazegame = new MazeGame(roomNumbers);
		//Collections.shuffle(mazegame.maze.rooms);
		return mazegame.maze;
	}
}
