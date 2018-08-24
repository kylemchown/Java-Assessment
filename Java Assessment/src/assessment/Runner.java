package assessment;

/*
	Current state of project
	Movement complete
	Win condition complete
	Distance complete
	Collectables complete
	Encounters complete
*/

public class Runner {

	public static void main(String[] args) {
		Player player = new Player(200, 10);
		Map map = new Map();
		
		map.runGame(player);
		
	}

}
