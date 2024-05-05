package codexnaturalis.card;

import java.awt.Color;
import java.util.Objects;
import fr.umlv.zen5.ApplicationContext;

public interface Card {
	public void draw(ApplicationContext context, Coordinates coordinates);

	public static Color getColor(RessourceType type) {
		Objects.requireNonNull(type);
		switch (type) {
			case ANIMAL:
				return Color.BLUE;
			case FUNGI:
				return Color.ORANGE;
			case INSECT:
				return Color.MAGENTA;
			case PLANT:
				return Color.GREEN;
			case VOID:
				return Color.BLACK;
			default:
				return Color.WHITE;
		}
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