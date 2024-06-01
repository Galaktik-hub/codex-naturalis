package codexnaturalis.card;

import java.awt.Color;
import java.util.Objects;
import fr.umlv.zen5.ApplicationContext;

public interface Card {
	public void draw(ApplicationContext context, Coordinates coordinates);

	public static Color getColor(Collectible type) {
		Objects.requireNonNull(type);
        return switch (type) {
			case RessourceType.ANIMAL -> Color.BLUE;
			case RessourceType.FUNGI -> Color.ORANGE;
			case RessourceType.INSECT -> Color.MAGENTA;
			case RessourceType.PLANT -> Color.GREEN;
			case RessourceType.INVISIBLE -> Color.BLACK;
			case Artefact.INKWELL -> Color.RED;
			case Artefact.MANUSCRIPT -> Color.YELLOW;
			case Artefact.QUILL -> Color.PINK;
            default -> Color.WHITE;
        };
	}

	public boolean isValidCorner(int corner);
	
	default public int width() {
		return 200;
	}
	
	default public int height() {
		return 80;
	}
	
	default public int cornerSize() {
		return 20;
	}
	
	default public int bordersize() {
		return 2;
	}
}