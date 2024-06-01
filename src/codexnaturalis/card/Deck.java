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
	}
	
	public void add(Card c) {
		this.deck.add(c);
	}

	public int getSize() {
		return deck.size();
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card drawCard() {
		return deck.removeLast();
	}
	
	public boolean isEmpty() {
		return getSize() == 0;
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
