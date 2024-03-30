package codexnaturalis.card;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	private final List<Card> deck;
	private int size;
	
	public Deck() {
		this.deck = new ArrayList<>();
		this.size = 0;
		fill();
	}
	
	public void incrementDeckSize() {
		this.size++;
	}
	
	public void decrementDeckSize() {
		this.size--;
	}
	
	public Card get() {
		return deck.getFirst();
	}
	
	private void fill() {
		this.deck.add(new RessourceCard(RessourceType.ANIMAL, RessourceType.NONE, RessourceType.ANIMAL, RessourceType.ANIMAL, RessourceType.NONE, 0)); incrementDeckSize();
		this.deck.add(new RessourceCard(RessourceType.ANIMAL, RessourceType.ANIMAL, RessourceType.NONE, RessourceType.NONE, RessourceType.ANIMAL, 0)); incrementDeckSize();
		this.deck.add(new RessourceCard(RessourceType.ANIMAL, RessourceType.ANIMAL, RessourceType.NONE, RessourceType.NONE, RessourceType.NONE, 0)); incrementDeckSize();
		this.deck.add(new RessourceCard(RessourceType.ANIMAL, RessourceType.NONE, RessourceType.ANIMAL, RessourceType.NONE, RessourceType.ANIMAL, 0)); incrementDeckSize();
		this.deck.add(new RessourceCard(RessourceType.ANIMAL, RessourceType.ANIMAL, RessourceType.NONE, RessourceType.ANIMAL, RessourceType.NONE, 0)); incrementDeckSize();
		this.deck.add(new RessourceCard(RessourceType.ANIMAL, RessourceType.NONE, RessourceType.ANIMAL, RessourceType.NONE, RessourceType.NONE, 1)); incrementDeckSize();
		this.deck.add(new RessourceCard(RessourceType.ANIMAL, RessourceType.NONE, RessourceType.ANIMAL, RessourceType.ANIMAL, RessourceType.NONE, 1)); incrementDeckSize();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Contenu du deck de taille ")
			.append(this.size)
			.append("\n---\n");
		for (Card card : deck) {
			sb.append(card.toString())
				.append("\n");
		}
		return sb.toString();
	}
}
