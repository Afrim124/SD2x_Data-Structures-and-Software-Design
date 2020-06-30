
public class MazeGame {
	
	public Maze maze;
	
	public MazeGame() {
		maze = new Maze();
	}
	
	public MazeGame(int numberOfRooms) {
		this();
		for (int i=0;i<numberOfRooms-1;i++) {
			maze.addRoom(new Room());
		}
	}
	
	public Maze createMaze() {
		Maze maze2 = new Maze();
		maze2.addRoom(new Room());
		maze2.addRoom(new Room());
		maze2.addRoom(new Room());
		maze2.addRoom(new Room());
		maze2.addRoom(new Room());
		maze2.addRoom(new Room());
		maze2.addRoom(new Room());
		return maze2;
	}
	
	public void loadMaze() {
		
	}
}

