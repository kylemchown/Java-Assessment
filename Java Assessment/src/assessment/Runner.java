package assessment;

public class Runner {

	public static void main(String[] args) {
		Player player = new Player(100, 10);
		Map map = new Map();
		
		map.runGame(player, 2);
		
	}

}
