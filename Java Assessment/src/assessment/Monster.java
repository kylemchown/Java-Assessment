package assessment;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Fighter {
	
	Monster(int hp, int atk){
		super(hp, atk);
	}
	Scanner s = new Scanner(System.in);
	public void fight(Player player) {
		System.out.println("A Monster Appears");
		int turn = 0;
		while (player.getHp() > 0 && this.getHp() > 0) {
			System.out.println("Select commands by using the assosciated number");
			System.out.println("Choose a command: (1) Fight / (2) Guard");
			String action = s.nextLine();
			int monatk = ThreadLocalRandom.current().nextInt((int)(this.getAtk() - ((int) this.getAtk() * 0.25)), (int) (this.getAtk() + ((int) this.getAtk() * 0.25)));
			int plaatk = ThreadLocalRandom.current().nextInt((int)(player.getAtk() - ((int) player.getAtk() * 0.25)), (int) (player.getAtk() + ((int) player.getAtk() * 0.25)));
			turn++;
			if (turn % 3 == 0) {
				monatk = monatk * 3;
			}
			switch (action){
			case "1":
				System.out.println("You deal " + plaatk + " damage");
				this.setHp(this.getHp() - plaatk);
				System.out.println("The monster is on " + this.getHp() + " hp");
				break;
			case"2":
				System.out.println("You defend yourself");
				monatk = monatk / 2;
				break;
			default:
				System.out.println("Please enter a valid command");
				continue;
			}
			System.out.println("The Monster hits for " + monatk + " damage");
			player.setHp(player.getHp() - monatk);
			System.out.println("You are on " + player.getHp() + " hp");
			
			if (turn % 3 == 2) {
				System.out.println("The monster is gearing up for a strong attack");
			}
		}
		if (this.getHp() <= 0) {
			System.out.println("You beat the monster!");
		}
		else {
			System.out.println("You died. Maybe try harder next time.");
			System.exit(0);
		}
	}
}
