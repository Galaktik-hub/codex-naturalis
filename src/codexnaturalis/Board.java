package codexnaturalis;

import java.util.HashMap;
import java.util.Objects;
import codexnaturalis.card.Card;
import codexnaturalis.card.Coordinates;
import codexnaturalis.player.Player;
import fr.umlv.zen5.ApplicationContext;

public class Board {
	private final HashMap<Coordinates, Card> board;
	private final HashMap<Pair, Card> boardUtilisateur;

	public Board() {
		this.board = new HashMap<Coordinates, Card>();
		this.boardUtilisateur = new HashMap<Pair, Card>();
	}
	
	public void add(Coordinates coordinates, Card card) {
		Objects.requireNonNull(coordinates);
		Objects.requireNonNull(card);
		board.put(coordinates, card);
	}
	
	public int getSize() {
		return board.size();
	}
	
	public boolean isValidCorner(Coordinates coordinates) {
		Objects.requireNonNull(coordinates);
		return true;
	}
	
	public void drawBoard(Player p, ApplicationContext context) {
		Objects.requireNonNull(p);
		Objects.requireNonNull(context);
		p.drawHand(context);
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
