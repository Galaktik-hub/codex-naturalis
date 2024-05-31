package codexnaturalis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

import codexnaturalis.card.Deck;

public class DeckLoader {
	
	public static Deck createDeck(String path) throws IOException {
		Objects.requireNonNull(path);
		Path file = Path.of(path);
		Deck deck = new Deck();
		try(var input = Files.newBufferedReader(file);) {
			String line;
			ArrayList<String> cards = new ArrayList<>();
			while ((line = input.readLine()) != null) {
				cards.add(line);
			}
		}
		
		return deck;
	}
}
