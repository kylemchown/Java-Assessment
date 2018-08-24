package assessment;

public class Player extends Fighter {
	private int xcoord;
	private int ycoord;
	
	Player(int hp, int atk){
		super(hp, atk);
		this.xcoord = 0;
		this.ycoord = 0;
	}

	public void moveNorth() {
		xcoord++;
	}
	
	public void moveSouth() {
		xcoord--;
	}
	
	public void moveEast() {
		ycoord++;
	}
	
	public void moveWest() {
		ycoord--;
	}
	
	public int getXcoord() {
		return xcoord;
	}

	public void setXcoord(int xcoord) {
		this.xcoord = xcoord;
	}

	public int getYcoord() {
		return ycoord;
	}

	public void setYcoord(int ycoord) {
		this.ycoord = ycoord;
	}
	
	
}
