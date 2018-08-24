package assessment;

public abstract class Fighter {
	
	private int hp;
	private int atk;
	
	Fighter(int hp, int atk){
		this.hp = hp;
		this.atk = atk;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}
	
	
}
