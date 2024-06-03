package codexnaturalis.player;

import java.util.ArrayList;
import java.util.Objects;

import codexnaturalis.card.Card;
import codexnaturalis.card.Coordinates;
import fr.umlv.zen5.ApplicationContext;

public class Player {
	private final int id;
	private int score = 0;
	private final ArrayList<Card> hand = new ArrayList<>();
	
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
	
	public void addToHand(Card card) {
		Objects.requireNonNull(card);
		if (hand.size() < 3) {
			hand.add(card);			
		} else {
			System.out.println("La main est pleine");
		}
	}
	
	public boolean removeFromHand(Card card) {
		Objects.requireNonNull(card);
		if (hand.contains(card)) {
			hand.remove(card);
			return true;
		} else {
			return false;
		}
	}
	
	public void drawHand(ApplicationContext context) {
		Objects.requireNonNull(context);
		
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
