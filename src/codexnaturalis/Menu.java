package codexnaturalis;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Rectangle2D;

import fr.umlv.zen5.Application;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;

public class Menu {
	
	public void drawMenu() {
		
		Application.run(Color.darkGray, context -> {
			boolean gameStarted = false;
			ScreenInfo screenInfo = context.getScreenInfo();
			float screenWidth = screenInfo.getWidth();
			float screenHeight = screenInfo.getHeight();
			
			float buttonWidth = 200;
            float buttonHeight = 50;
            float newGameButtonX = screenWidth / 2 - buttonWidth / 2;
            float newGameButtonY = screenHeight / 2 - buttonHeight - 10;
            float quitButtonX = screenWidth / 2 - buttonWidth / 2;
            float quitButtonY = screenHeight / 2 + 10;
			
			while (true) {
				if (!gameStarted) {
					context.renderFrame(graphics -> {
                        graphics.setColor(Color.WHITE);
                        graphics.setFont(new Font("Arial", Font.BOLD, 60));
                        graphics.drawString("Codex Naturalis", screenWidth / 2 - 200, screenHeight / 2 - 200);
                        
                        // Dessiner le bouton Nouvelle Partie
                        graphics.setColor(Color.GRAY);
                        graphics.fill(new Rectangle2D.Float(newGameButtonX, newGameButtonY, buttonWidth, buttonHeight));
                        graphics.setColor(Color.WHITE);
                        graphics.setFont(new Font("Arial", Font.BOLD, 25));
                        graphics.drawString("Nouvelle Partie", newGameButtonX + 10, newGameButtonY + 35);
                        
                        // Dessiner le bouton Quitter
                        graphics.setColor(Color.GRAY);
                        graphics.fill(new Rectangle2D.Float(quitButtonX, quitButtonY, buttonWidth, buttonHeight));
                        graphics.setColor(Color.WHITE);
                        graphics.setFont(new Font("Arial", Font.BOLD, 25));
                        graphics.drawString("Quitter", quitButtonX + 60, quitButtonY + 35);
                    });
					
					var event = context.pollOrWaitEvent(10);
					if (event == null) {
						continue;
					}
					
					var action = event.getAction();
					
					if (action == Action.POINTER_DOWN) {
						var location = event.getLocation();
						float x = location.x;
						float y = location.y;
						
						if (x >= newGameButtonX && x <= newGameButtonX + buttonWidth && y >= newGameButtonY && y <= newGameButtonY + buttonHeight) {
                            gameStarted = true;
                            break;
                        }
						
						 if (x >= quitButtonX && x <= quitButtonX + buttonWidth && y >= quitButtonY && y <= quitButtonY + buttonHeight) {
	                            context.exit(0); // On ferme la fenêtre
						 }
					}
					continue;
				}
			}
		});
	}
}