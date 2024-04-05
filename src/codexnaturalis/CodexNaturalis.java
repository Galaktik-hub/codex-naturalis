package codexnaturalis;

import java.awt.Color;
import codexnaturalis.card.Coordinates;
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
			// Boucle du jeu
			while (true) {
				var event = context.pollOrWaitEvent(10); // Récuperer un event
				if (event == null) {
					continue;
				}
				var action = event.getAction();
				if (action == Action.POINTER_DOWN) { // Si clic de la souris
					if (!(deck.isEmpty())) { // Tant que le deck n'est pas vide
						Coordinates coordinates = new Coordinates(event.getLocation().x, event.getLocation().y);
						deck.drawCard().draw(context, coordinates);
					} else { // Sinon, on quitte le jeu
						System.out.println("Deck épuisé");
						context.exit(0); // On ferme la fenêtre
						return;
					}
				}
			}
		});
	}
}