package codexnaturalis.card;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.Objects;
import fr.umlv.zen5.ApplicationContext;

public record GoldenCard(Collectible type,
						 Collectible leftUpCorner,
						 Collectible rightUpCorner,
						 Collectible leftDownCorner,
						 Collectible rightDownCorner,
						 List<Collectible> cost,
						 String pointType,
						 int point) implements Card {
	
	@Override
	public void draw(ApplicationContext context, Coordinates coordinates) {
		Objects.requireNonNull(context);
	    Objects.requireNonNull(coordinates);
	    
	    // Récupération des couleurs des coins et de la carte
	    Color cardColor = Card.getColor(type);
	    Color leftUpCornerColor = Card.getColor(leftUpCorner);
	    Color rightUpCornerColor = Card.getColor(rightUpCorner);
	    Color leftDownCornerColor = Card.getColor(leftDownCorner);
	    Color rightDownCornerColor = Card.getColor(rightDownCorner);
	    float x = coordinates.x();
	    float y = coordinates.y();
	    
    	// Dessin de la carte et de ses coins
	    context.renderFrame(graphics -> {
	        drawBorder(graphics, x, y, width(), height(), Color.ORANGE, bordersize());
	        drawCard(graphics, x, y, width(), height(), cardColor);
	        drawCorner(graphics, x, y, cornerSize(), bordersize(), leftUpCornerColor);
	        drawCorner(graphics, x + width() - cornerSize(), y, cornerSize(), bordersize(), rightUpCornerColor);
	        drawCorner(graphics, x, y + height() - cornerSize(), cornerSize(), bordersize(), leftDownCornerColor);
	        drawCorner(graphics, x + width() - cornerSize(), y + height() - cornerSize(), cornerSize(), bordersize(), rightDownCornerColor);
	    });
	}

	// Méthode pour dessiner la carte
	private void drawCard(Graphics2D graphics, float x, float y, int width, int height, Color color) {
		Objects.requireNonNull(graphics);
		Objects.requireNonNull(color);
		
	    graphics.setColor(color);
	    graphics.fill(new Rectangle2D.Float(x, y, width, height));
	}

	private void drawBorder(Graphics2D graphics, float x, float y, int width, int height, Color color, int borderSize) {
        graphics.setColor(color);
        var border = new Rectangle2D.Float(x - borderSize, y - borderSize, width + borderSize * 2, height + borderSize * 2);
        graphics.fill(border);
    }

	// Méthode pour dessiner un coin de la carte
	private void drawCorner(Graphics2D graphics, float x, float y, int size, int borderSize, Color fillColor) {
		Objects.requireNonNull(graphics);
		Objects.requireNonNull(fillColor);
		
	    // Dessin de la bordure du coin
	    graphics.setColor(Color.GRAY);
	    graphics.fill(new Rectangle2D.Float(x, y, size, size));
	    
	    // Dessin du coin rempli
	    graphics.setColor(fillColor);
	    graphics.fill(new Rectangle2D.Float(x + borderSize, y + borderSize, size - borderSize * 2, size - borderSize * 2));
	}
	
	@Override
	public boolean isValidCorner(int corner) {
        return switch (corner) {
            // En haut à gauche = 0, en haut à droite = 1, en bas à droite = 2, en bas à gauche = 3
            case 0 -> !(this.leftUpCorner.equals(RessourceType.EMPTY));
            case 1 -> !(this.rightUpCorner.equals(RessourceType.EMPTY));
            case 2 -> !(this.rightDownCorner.equals(RessourceType.EMPTY));
            case 3 -> !(this.leftDownCorner.equals(RessourceType.EMPTY));
            default -> throw new IllegalArgumentException("Le coin choisi n'est pas possible");
        };
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Carte dorure | Coût: ")
			.append(this.cost)
			.append(" | Point(s): ")
			.append(this.point)
			.append(" | Type: ")
			.append(this.type)
			.append(" | Coin supérieur gauche: ")
			.append(this.leftUpCorner)
			.append(" | Coin supérieur droit: ")
			.append(this.rightUpCorner)
			.append(" | Coin inférieur gauche: ")
			.append(this.leftDownCorner)
			.append(" | Coin inférieur droit: ")
			.append(this.rightDownCorner);
		return sb.toString();	
	}
}
