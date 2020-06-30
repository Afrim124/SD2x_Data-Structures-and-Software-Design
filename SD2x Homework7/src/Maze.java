import java.util.ArrayList;

public class Maze {

	public Room[] rooms;
	
	public Maze() {
		rooms = new Room[1];
		rooms[0] = new Room();
	}

	public void addRoom(Room room) {
		Room[] oldrooms = rooms;
		rooms = new Room[rooms.length+1];
		for (int i=0;i<oldrooms.length-1;i++)
			rooms[i]=oldrooms[i];
		rooms[rooms.length-1] = room;
	}
}
