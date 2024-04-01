package codexnaturalis.card;

import java.awt.Color;

import fr.umlv.zen5.ApplicationContext;

public interface Card {
	@Override
	public String toString();
	public void draw(ApplicationContext context, float x, float y);
	
	public static Color getColor(RessourceType type) {
		switch (type) {
			case ANIMAL:
				return Color.BLUE;				
			case FUNGI:
				return Color.ORANGE;				
			case INSECT:
				return Color.MAGENTA;				
			case NONE:
				return Color.BLACK;				
			case PLANT:
				return Color.GREEN;
		}
		return Color.WHITE;
	}
}
