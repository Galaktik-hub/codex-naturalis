package codexnaturalis;

import codexnaturalis.card.Deck;
import codexnaturalis.player.Player;

public class CodexNaturalis {

	public static void main(String[] args) {
		Player p1 = new Player(1);
		Deck deck = new Deck();
		
		System.out.println(p1.toString());
		System.out.println(deck.toString());
//		Application.run(Color.ORANGE, event -> {});
	}
}