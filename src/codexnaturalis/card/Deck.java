package codexnaturalis.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	/*
	 * Deck of card is represented by a list of Card.
	 */
	private final List<Card> deck;
	
	public Deck() {
		this.deck = new ArrayList<>();
		fill();	// À l'initialisation du deck, on le rempli
		shuffle();	// Puis on le mélange
	}

	public int getSize() {
		return deck.size();
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card drawCard() {
		Card card = deck.removeLast();
		return card;
	}
	
	public boolean isEmpty() {
		return getSize() == 0;
	}

	private void fill() {
		this.deck.add(new RessourceCard(RessourceType.ANIMAL, RessourceType.NONE, RessourceType.ANIMAL, RessourceType.ANIMAL, RessourceType.NONE, 0));
		this.deck.add(new RessourceCard(RessourceType.ANIMAL, RessourceType.ANIMAL, RessourceType.NONE, RessourceType.NONE, RessourceType.ANIMAL, 0));
		this.deck.add(new RessourceCard(RessourceType.ANIMAL, RessourceType.ANIMAL, RessourceType.NONE, RessourceType.NONE, RessourceType.NONE, 0));
		this.deck.add(new RessourceCard(RessourceType.ANIMAL, RessourceType.NONE, RessourceType.ANIMAL, RessourceType.NONE, RessourceType.ANIMAL, 0));
		this.deck.add(new RessourceCard(RessourceType.ANIMAL, RessourceType.ANIMAL, RessourceType.NONE, RessourceType.ANIMAL, RessourceType.NONE, 0)); 
		this.deck.add(new RessourceCard(RessourceType.ANIMAL, RessourceType.NONE, RessourceType.ANIMAL, RessourceType.NONE, RessourceType.NONE, 1));
		this.deck.add(new RessourceCard(RessourceType.ANIMAL, RessourceType.NONE, RessourceType.ANIMAL, RessourceType.ANIMAL, RessourceType.NONE, 1));
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Contenu du deck de taille ")
			.append(getSize())
			.append("\n---\n");
		for (Card card : deck) {
			sb.append(card.toString())
			  .append("\n");
		}
		return sb.toString();
	}
}
