package codexnaturalis;

import java.awt.Color;
import codexnaturalis.card.Deck;
import codexnaturalis.player.Player;
import fr.umlv.zen5.Application;

public class CodexNaturalis {

	public static void main(String[] args) {
		Player p1 = new Player(1);
		Deck deck = new Deck();
		
		System.out.println(p1);
		System.out.println(deck);
		Application.run(Color.ORANGE, context -> {
			while (true) {
				for (int i = 0; i < deck.getSize(); i++) {
					for (int j = 50; j < deck.getSize()*250; j+=250) {
						deck.get(i).draw(context, j, 20);
					}
				}
			}
		});
	}
}