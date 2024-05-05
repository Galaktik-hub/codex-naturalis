package codexnaturalis;

import java.awt.Color;
import codexnaturalis.card.Card;
import codexnaturalis.card.Coordinates;
import codexnaturalis.card.Deck;
import codexnaturalis.player.Player;
import fr.umlv.zen5.Application;
import fr.umlv.zen5.Event.Action;

public class CodexNaturalis {
	private static boolean firstCardPlaced = false;

	public static void main(String[] args) {
	        Player p1 = new Player(1);
	        Board board = new Board();
	        Deck deck = new Deck();

	        System.out.println(p1);
	        System.out.println(deck);
	        Application.run(Color.BLACK, context -> {
	            // Boucle du jeu
	            while (true) {
	                var event = context.pollOrWaitEvent(10); // Récuperer un event
	                if (event == null) {
	                    continue;
	                }
	                var action = event.getAction();
	                if (action == Action.POINTER_DOWN) { // Si clic de la souris
	                    if (!(deck.isEmpty())) { // Tant que le deck n'est pas vide
	                        Card randomCard = deck.drawCard();
	                        Coordinates coordinates = new Coordinates(event.getLocation().x, event.getLocation().y);
	                        if (firstCardPlaced || board.getSize() == 0) {
	                            if (board.getSize() > 0 && !board.isNoneCorner(coordinates)) {
	                                System.out.println("Cliquer sur un coin de couleur noir");
	                            } else {
	                            	// Dessiner la carte
	                                randomCard.draw(context, coordinates);
	                                board.add(coordinates, randomCard);
	                                firstCardPlaced = true;
	                                System.out.println(board);
	                            }
	                        } else {
	                            // Posez la première carte sur le plateau
	                            randomCard.draw(context, coordinates);
	                            board.add(coordinates, randomCard);
	                            firstCardPlaced = true;
	                            System.out.println(board);
	                        }
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