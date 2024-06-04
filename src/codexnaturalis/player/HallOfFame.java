package codexnaturalis.player;

import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import codexnaturalis.game.Menu;
import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event.Action;
import fr.umlv.zen5.ScreenInfo;

public class HallOfFame {

    public static List<String> getHallOfFame() throws IOException {
        List<String> hallOfFame = new ArrayList<>();
        String fileName = "src/codexnaturalis/game/halloffame.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 0;
            // On récupère que les 10 premières lignes, ou, si il y a moins de scores enregistrés que 10, on ne prend
            // ceux présents
            while ((line = br.readLine()) != null && count < 10) {
                hallOfFame.add(line);
                count++;
            }
        } catch (IOException e) {
            throw new IOException();
        }
        return hallOfFame;
    }

    public static void insertHallOfFame(String person) throws IOException {
        List<String> hallOfFame = getHallOfFame();
        hallOfFame.add(person);
        // On trie pour avoir les meilleurs scores
        hallOfFame.sort((s1, s2) -> {
            int score1 = Integer.parseInt(s1.split(" ")[1]);
            int score2 = Integer.parseInt(s2.split(" ")[1]);
            return Integer.compare(score2, score1);
        });

        // On ne garde que les 10 meilleures entrées
        if (hallOfFame.size() > 10) {
            hallOfFame = hallOfFame.subList(0, 10);
        }

        String fileName = "halloffame.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String entry : hallOfFame) {
                bw.write(entry);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new IOException();
        }
    }
    
    public static void drawHallOfFame(ApplicationContext context) throws IOException {
    	Objects.requireNonNull(context);
    	Menu.clearScreen(context);
    	ScreenInfo screenInfo = context.getScreenInfo();
		float screenWidth = screenInfo.getWidth();
		float screenHeight = screenInfo.getHeight();
    	List<String> listHallOfFame = HallOfFame.getHallOfFame();
    	System.out.println(listHallOfFame);
    	int separator = 1;
    	for (String fame : listHallOfFame) {
    		final int separatorReal = separator;
	    	context.renderFrame(graphics -> {
	    			graphics.setColor(Color.WHITE);
	                graphics.setFont(new Font("Arial", Font.BOLD, 25));
	                graphics.drawString(String.valueOf(separatorReal) + ". " + fame, screenWidth / 2 - 200, (screenHeight / 2 - 200) + (35 * separatorReal));
			});
	    	separator++;
	    }
    	while (separator != 11) {
    		final int separatorReal = separator;
	    	context.renderFrame(graphics -> {
	    			graphics.setColor(Color.WHITE);
	                graphics.setFont(new Font("Arial", Font.BOLD, 25));
	                graphics.drawString(String.valueOf(separatorReal) + ". Aucune données", screenWidth / 2 - 200, (screenHeight / 2 - 200) + (35 * separatorReal));
			});
	    	separator++;
    	}
    	final int separatorReal = separator + 1;
    	context.renderFrame(graphics -> {
			graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("Arial", Font.BOLD, 25));
            graphics.drawString("Appuyez sur une touche pour revenir au menu", screenWidth / 2 - 200, (screenHeight / 2 - 200) + (35 * separatorReal));
    	});
    	while (true) {
    		var event = context.pollEvent();
    		if (event == null || event.getAction() == Action.POINTER_MOVE || event.getAction() == Action.POINTER_UP) {
    			continue;
    		}
            if (event != null) {
            	Menu.clearScreen(context);
            	System.out.print(event);
            	Menu.drawMenu(context);
                break;
            }
       }
    	
    }
}
