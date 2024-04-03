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
			
			// Attribution des positions des cartes
			int x = 40;
			int y = 40;
			int positionCard = 0; // ième position de la carte dans le deck
			int widthCard = 200; // Largeur de la carte afin de donner une marge
			
			// Boucle du jeu
			while (true) {
				var event = context.pollOrWaitEvent(10); // Récuperer un event
				if (event == null) {
					continue; // Si il n'y a pas de event on coninue
				}
				var action = event.getAction(); // Si il y a un event, récupérer l'action
				if (action == Action.POINTER_DOWN) { // Si clic de la souris
					if (deck.getSize() - 1 >= positionCard) { // Si la position de la carte est dans le deck
						deck.get(positionCard).draw(context, x, y); // On dessine avec la méthode draw
						x += widthCard+50; // Un espacement entre les cartes
						positionCard++; // La carte suivante
					} else { // Si la position de la carte pas dans le deck
						System.out.println("Deck épuisé");
						context.exit(0); // On ferme la fenêtre
						return;
					}
				}
			}
		});
	}
}