import java.util.ArrayList;
import java.util.Random;

public class Room extends MapSite {
	
	public int roomNumber;
	public Wall[] sides = new Wall[4];
	public MapSite[] mapsites;
	//protected int maxRoomNumber = 10;
	
	public Room() {
		Random r = new Random();
		this.roomNumber=r.nextInt(10);
		sides[0] = new Wall();
	}
	
	public Room(int roomNumber) {
		this.roomNumber = roomNumber;
		sides[0] = new Wall();
	}
	public Wall getSide(int wallNumber) {
		return sides[wallNumber];
	}
	
	public void setSide(int wallNumber, Wall wall) {
		sides[wallNumber] = wall;
	}
}
