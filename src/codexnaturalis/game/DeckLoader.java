package codexnaturalis.game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import codexnaturalis.card.*;

public class DeckLoader {
	
	public static Deck createDeck(String path) throws IOException {
        Objects.requireNonNull(path);
        Path file = Path.of(path);
        Deck deck = new Deck();
        ArrayList<String> cards;
        // On récupère toutes les cartes (lignes) du fichier
        try (var input = Files.newBufferedReader(file)) {
            String line;
            cards = new ArrayList<>();
            while ((line = input.readLine()) != null) {
                cards.add(line);
            }
        }
        System.out.println(cards);
        for (String line : cards) {
        		String[] card = line.split(" ");
            Card newCard;
            
			switch (card[0]) {
				case "StarterCard":
                    ArrayList<String> ressources = new ArrayList<>(Arrays.asList(card).subList(12, card.length));
                    System.out.println(ressources);
                    newCard = new StarterCard(
                            matchCollectibleType(card[2]),
                            matchCollectibleType(card[3]),
                            matchCollectibleType(card[4]),
                            matchCollectibleType(card[5]),
                            matchCollectibleType(card[7]),
                            matchCollectibleType(card[8]),
                            matchCollectibleType(card[9]),
                            matchCollectibleType(card[10]),
                            ressources
                    );
                    break;
                case "ResourceCard":
                    newCard = new RessourceCard(
                            matchCollectibleType(card[7]),
                            matchCollectibleType(card[2]),
                            matchCollectibleType(card[3]),
                            matchCollectibleType(card[4]),
                            matchCollectibleType(card[5]),
                            card[9].equals("None") ? 0 : Integer.valueOf(card[9].substring(2))
                    );
                    break;
                case "GoldCard":
                    ArrayList<String> costStringed = new ArrayList<>(Arrays.asList(card).subList(Arrays.asList(card).indexOf("Cost") + 1, card.length - 2));
                    ArrayList<Collectible> cost = new ArrayList<>();
                    for (String s: costStringed) {
                        cost.add(matchCollectibleType(s));
                    }
                    newCard = new GoldenCard(
                            matchCollectibleType(card[7]),
                            matchCollectibleType(card[2]),
                            matchCollectibleType(card[3]),
                            matchCollectibleType(card[4]),
                            matchCollectibleType(card[5]),
                            cost,
                            card[card.length - 1].substring(0,1),
                            Integer.valueOf(card[card.length - 1].substring(2))
                    );
                    break;
                case "Objective":
                    //TODO: FAIRE LA CARTE OBJECTIF
                    newCard = null;
                    break;
                default:
                    newCard = null;
			}
            deck.add(newCard);
		}
        return deck;
    }

    private static Collectible matchCollectibleType(String ressource) {
        Objects.requireNonNull(ressource);
        return switch (ressource) {
            case "Insect", "R:Insect" -> RessourceType.INSECT;
            case "Fungi", "R:Fungi" -> RessourceType.FUNGI;
            case "Animal", "R:Animal" -> RessourceType.ANIMAL;
            case "Plant", "R:Plant" -> RessourceType.PLANT;
            case "Invisible", "R:Invisible" -> RessourceType.INVISIBLE;
            case "Empty", "R:Empty" -> RessourceType.EMPTY;
            case "Inkwell", "A:Inkwell" -> Artefact.INKWELL;
            case "Quill", "A:Quill" -> Artefact.QUILL;
            case "Manuscript", "A:Manuscript" -> Artefact.MANUSCRIPT;
            default -> throw new IllegalStateException("Unexpected value: " + ressource);
        };
    }
}
