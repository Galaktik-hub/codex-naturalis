package codexnaturalis;

import java.awt.Color;
import codexnaturalis.card.Deck;
import codexnaturalis.player.Player;
import fr.umlv.zen5.Application;
import fr.umlv.zen5.Event.Action;

public class CodexNaturalis {

	public static void main(String[] args) {
		Player p1 = new Player(1);
		Deck deck = new Deck();
		
		System.out.println(p1);
		System.out.println(deck);
		Application.run(Color.ORANGE, context -> {
			int x = 40;
			int y = 40;
			int i = 0;
			int widthRectangle = 200;
			
			while (true) {
				var event = context.pollOrWaitEvent(10);
				if (event == null) {
					continue;
				}
				var action = event.getAction();
				if (action == Action.POINTER_DOWN) {
					System.out.println(action);
					deck.getAndRemove(i).draw(context, x, y);
					x += widthRectangle+50;
					i++;
					continue;
				}
			}
		});
	}
}