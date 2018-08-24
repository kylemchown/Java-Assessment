package assessment;

public class Key {
	private int xpos;
	private int ypos;
	private boolean obtained = false;
	
	Key(int xpos, int ypos){
		this.xpos = xpos;
		this.ypos = ypos;
	}

	public int getXpos() {
		return xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	public boolean isObtained() {
		return obtained;
	}

	public void setObtained(boolean obtained) {
		this.obtained = obtained;
	}
	
	

}
