
public class Door extends MapSite{
	
	public boolean isOpen;
	public Room room1;
	public Room room2;
	
	public Door() {
		isOpen = true;
		room1 = new Room();
		room2 = new Room();
	}
	
	public void enter() {}
}
