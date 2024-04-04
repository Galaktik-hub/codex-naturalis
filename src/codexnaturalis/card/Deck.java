package codexnaturalis.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	public Card get(int position) {
		return deck.get(position);	// On récupère une carte, sans la supprimer
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Card getAndRemove(int position) {
		Card card = deck.get(position);	// On récupère la carte
		deck.remove(position);	// Puis on l'enlève
		this.decrementDeckSize();
		return card;
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
	
	public Card drawRandomCard() {
		Random r = new Random();
		return getAndRemove(r.nextInt(this.size));
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
