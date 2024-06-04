package codexnaturalis.game;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import codexnaturalis.card.Card;
import codexnaturalis.card.Coordinates;
import codexnaturalis.player.Player;
import fr.umlv.zen5.ApplicationContext;

public class Board {
	private final LinkedHashMap<Coordinates, Card> board;
	private final LinkedHashMap<Pair, Card> boardUtilisateur;

	public Board() {
		this.board = new LinkedHashMap<Coordinates, Card>();
		this.boardUtilisateur = new LinkedHashMap<Pair, Card>();
	}
	
	public HashMap<Coordinates, Card> board() {
		return board;
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

	public void move(Coordinates coordinates) {
		/*
		* Fonction qui bouge toutes les coordonnées du plateau, ne réalise pas la mise à jour à l'écran
		 */
		Objects.requireNonNull(coordinates);
		HashMap<Coordinates, Card> newBoard = new LinkedHashMap<>();
		for (Coordinates cardCoordinates : board.keySet()) {
			newBoard.put(cardCoordinates.add(coordinates), board.get(cardCoordinates));
		}
		board.clear();
		for (Coordinates cardCoordinates : newBoard.keySet()) {
			board.put(cardCoordinates, newBoard.get(cardCoordinates));
		}
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
