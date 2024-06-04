package codexnaturalis.player;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Objects;
import codexnaturalis.card.Card;
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
		context.renderFrame(graphics -> {
			graphics.setColor(Color.GRAY);
            graphics.fill(new Rectangle2D.Float(300, 1200, 1000, 300));
		});
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
