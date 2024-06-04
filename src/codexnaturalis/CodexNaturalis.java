package codexnaturalis;

import java.awt.Color;
import java.io.IOException;
import codexnaturalis.card.Card;
import codexnaturalis.card.Coordinates;
import codexnaturalis.card.Deck;
import codexnaturalis.player.Player;
import fr.umlv.zen5.Application;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;


public class CodexNaturalis {

	public static void main(String[] args) throws IOException {
		
	        Player p1 = new Player(1);
	        Board board = new Board();
	        Deck deck = DeckLoader.createDeck("src/codexnaturalis/game/deck.txt");
	        System.out.print(deck);

	        System.out.println(p1);
	        System.out.println();
	        Application.run(Color.BLACK, context -> {
	        	try {
					Menu.drawMenu(context);
				} catch (IOException e) {
					e.printStackTrace();
				}
	        	ScreenInfo screenInfo = context.getScreenInfo();
    			float screenWidth = screenInfo.getWidth();
    			float screenHeight = screenInfo.getHeight();
    			board.drawBoard(p1, context);
    			Card firstCard = deck.drawCard();
    			Coordinates coordinatesFirstCard = new Coordinates((screenWidth/2) - firstCard.width()/2, (screenHeight/2) - firstCard.height()/2);
    			firstCard.draw(context, coordinatesFirstCard);
                board.add(coordinatesFirstCard, firstCard);
                System.out.println(board);
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
	                        randomCard.draw(context, coordinates);
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