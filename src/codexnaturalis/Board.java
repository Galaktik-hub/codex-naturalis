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
	
	public void add(Coordinates coordinates, Card card) {
		Objects.requireNonNull(coordinates);
		Objects.requireNonNull(card);
		board.put(coordinates, card);
	}
	
	public int getSize() {
		return board.size();
	}
	
	public boolean isNoneCorner(Coordinates coordinates) {
		Objects.requireNonNull(coordinates);
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (HashMap.Entry<Coordinates, Card> entry : board.entrySet()) {
			Coordinates key = entry.getKey();
			Card val = entry.getValue();
			builder.append(key);
			builder.append(" : ");
			builder.append(val);
			builder.append("\n");
		}
		return builder.toString();
	}
}