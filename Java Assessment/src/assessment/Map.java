package assessment;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;



public class Map {
	private int locationx;
	private int locationy;
	private Player player;
	
	Scanner s = new Scanner(System.in);

	
	Map(){
	
	}
	
	public void runGame(Player player) {
		this.player = player;
		System.out.println("How many keys do you want there to be?");
		int keys = Integer.parseInt(s.nextLine());
		System.out.println("From the centre, how many spaces in each cardinal direction do you want objects to spawn?");
		int size = Integer.parseInt(s.nextLine());
		System.out.println("From 1 being least often and 100 being most, how often should monsters spawn?");
		int encounter = Integer.parseInt(s.nextLine());
		locationx = ThreadLocalRandom.current().nextInt(-size, size + 1);
		locationy = ThreadLocalRandom.current().nextInt(-size, size + 1);
		ArrayList<Key> keyList = new ArrayList<Key>();
		for(int i = 0; i < keys; i++) {
			keyList.add(new Key(ThreadLocalRandom.current().nextInt(-5, 5 + 1), ThreadLocalRandom.current().nextInt(-5, 5 + 1)));
		}
		
		System.out.println("You're in a swamp. It sucks, as all swamps do");
		System.out.println("Fortunately, you have a compass. Unfortunately, it's pointing in several directions.");
		System.out.println("The large hand points to " + distance() + "m");
		for (Key i : keyList) {
			System.out.println("A small hand points to " + keyDist(i)+ "m");
		}
		System.out.println("Use commands like 'North', 'N' or 'n' to move");
		
		boolean allKeys = false;
		while(allKeys == false) {
			while (locationx != player.getXcoord() || locationy != player.getYcoord() || allKeys == false) {
				System.out.println("Enter a direction");
				String direction = s.nextLine();
				move(direction);
				if (ThreadLocalRandom.current().nextInt(1, 101) < encounter) {
					fight(player);
				}
				System.out.println("The large hand points to " + distance() + "m");
				keyCheck(keyList);
				for (Key i : keyList) {
					if (i.isObtained() == false) {
						System.out.println("A small hand points to " + keyDist(i)+ "m");
					}
				}
				if (locationx == player.getXcoord() && locationy == player.getYcoord()) {
					allKeys = true;
					for (Key i : keyList) {
						if (i.isObtained() == false ) {
							allKeys = false;
						}
					}
				}
			}

		}
		System.out.println("After stumbling through the mist you finally reach the exit.");
		System.out.println("Congratulations");
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

	public double keyDist(Key key) {
		double x = Math.abs(key.getXpos() - player.getXcoord())*Math.abs(key.getXpos() - player.getXcoord());
		double y = Math.abs(key.getYpos() - player.getYcoord())*Math.abs(key.getYpos() - player.getYcoord());
		double dist = Math.sqrt(x + y);
		return dist;
	}
	
	public void keyCheck(ArrayList<Key> keyList) {
		for (Key i : keyList) {
			if (player.getXcoord() == i.getXpos() && player.getYcoord() == i.getYpos()) {
				if (i.isObtained() == false) {
					System.out.println("You pick up a key");
					i.setObtained(true);
				}
			}
		}
	}

	public void fight(Player player) {
		Monster monster = new Monster(50, 5);
		monster.fight(player);
	}
}
