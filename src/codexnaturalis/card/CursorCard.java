package codexnaturalis.card;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

import fr.umlv.zen5.ApplicationContext;

public class CursorCard{

	public void draw(ApplicationContext context, Coordinates coordinates) {
		Objects.requireNonNull(context);
		Objects.requireNonNull(coordinates);
		context.renderFrame(graphics -> {
			graphics.setColor(Color.WHITE);
			graphics.fill(new Rectangle2D.Float(coordinates.x(), coordinates.y(), 200, 80));
		});
	}
	
	public Coordinates move(Coordinates coordinates, String key) {
		Objects.requireNonNull(coordinates);
		Objects.requireNonNull(key);
		float x = 0;
		float y = 0;
		switch (key) {
			case "Z":
				y -= 80;
				break;
			case "Q":
				x -= 200;
				break;
			case "D":
				x += 200;
				break;
			case "S":
				y += 80;
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
		}
		Coordinates newCoordinates = new Coordinates(coordinates.x() + x, coordinates.y() + y);
		return newCoordinates;
	}
	
	public void clearCursorCard(ApplicationContext context, Coordinates coordinates) {
		Objects.requireNonNull(context);
		Objects.requireNonNull(coordinates);
		context.renderFrame(graphics -> {
			graphics.setColor(Color.BLACK);
			graphics.fill(new Rectangle2D.Float(coordinates.x(), coordinates.y(), 200, 80));
		});
	}
}