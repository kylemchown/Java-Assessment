package assessment;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Map {
	private int locationx;
	private int locationy;
	private Player player;
	
	Scanner s = new Scanner(System.in);

	
	Map(){
	
	}
	
	public void runGame(Player player) {
		this.player = player;
		locationx = ThreadLocalRandom.current().nextInt(-5, 5 + 1);
		locationy = ThreadLocalRandom.current().nextInt(-5, 5 + 1);
		System.out.println("You're in a swamp. It sucks, as all swamps do");
		System.out.println("Fortunately, you have a compass that points the way to the exit!");
		System.out.println("It reads " + distance() + "m");
		System.out.println("Use commands like 'North', 'N' or 'n' to move");
		
		while (locationx != player.getXcoord() || locationy != player.getYcoord()) {
			System.out.println("Enter a direction");
			String direction = s.nextLine();
			move(direction);
			System.out.println("The compass reads " + distance() + "m");
		}
		System.out.println("Win");
	}
	
	
	public void move(String direction) {
		//String direction = s.nextLine();
		if (direction.equals("North") || direction.equals("N") || direction.equals("n")) {
			player.moveNorth();
		}
		else if(direction.equals("South") || direction.equals("S") || direction.equals("s")) {
			player.moveSouth();
		}
		else if(direction.equals("East") || direction.equals("E") || direction.equals("e")) {
			player.moveEast();
		}
		else if(direction.equals("West") || direction.equals("W") || direction.equals("w")) {
			player.moveWest();
		}
		else {
			System.out.println("Please enter a valid direction");
		}
	}
	
	public double distance() {
		/*int x = Math.abs(locationx - player.getXcoord());
		int y = Math.abs(locationy - player.getYcoord());
		int dist = x + y;
		System.out.println("You are "+ dist + " spaces away");*/
		double x = Math.abs(locationx - player.getXcoord())*Math.abs(locationx - player.getXcoord());
		double y = Math.abs(locationy - player.getYcoord())*Math.abs(locationy - player.getYcoord());
		double dist = Math.sqrt(x + y);
		return dist;
	}
}
