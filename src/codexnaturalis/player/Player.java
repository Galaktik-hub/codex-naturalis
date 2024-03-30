package codexnaturalis.player;

public class Player {
	private final int id;
	private int score = 0;
	
	public Player(int id) {
		this.id = id;
	}
	
	public int score() {
		return this.score;
	}
	
	public int id() {
		return this.id;
	}
	
	public void addPointsToScore(int points) {
		this.score += points;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Le joueur ")
			.append(this.id)
			.append(" a ")
			.append(this.score)
			.append(" points.");
		return sb.toString();
	}
}
