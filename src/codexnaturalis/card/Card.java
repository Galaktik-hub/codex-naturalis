package codexnaturalis.card;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import fr.umlv.zen5.ApplicationContext;

public interface Card {
	@Override
	public String toString();
	public void draw(ApplicationContext context, float x, float y);
	
	public static Color getColor(RessourceType type) {
		Map<RessourceType, Color> map = new HashMap<>();
		map.put(RessourceType.NONE, Color.BLACK);
		map.put(RessourceType.ANIMAL, Color.BLUE);
		map.put(RessourceType.FUNGI, Color.ORANGE);
		map.put(RessourceType.INSECT, Color.MAGENTA);
		map.put(RessourceType.PLANT, Color.GREEN);
		return map.get(type);
	}
}
