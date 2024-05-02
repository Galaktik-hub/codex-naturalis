package codexnaturalis;

import java.util.HashMap;

import codexnaturalis.card.Card;
import codexnaturalis.card.Coordinates;

public class Board {
	private final HashMap<Coordinates, Card> board;

	public Board() {
		this.board = new HashMap<Coordinates, Card>();
	}
}