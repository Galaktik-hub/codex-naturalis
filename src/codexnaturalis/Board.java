package codexnaturalis;

import java.util.HashMap;
import java.util.Objects;

import codexnaturalis.card.Card;
import codexnaturalis.card.Coordinates;

public class Board {
	private final HashMap<Coordinates, Card> board;

	public Board() {
		this.board = new HashMap<Coordinates, Card>();
	}
	
	public void add(Card card) {
		Objects.requireNonNull(card);
		board.put(null, card);
	}
}