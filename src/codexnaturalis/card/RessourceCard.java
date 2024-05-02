package codexnaturalis.card;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

import fr.umlv.zen5.ApplicationContext;

public record RessourceCard(RessourceType type, 
						  RessourceType leftUpCorner, 
						  RessourceType rightUpCorner, 
						  RessourceType leftDownCorner, 
						  RessourceType rightDownCorner, 
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
	    
	    if (this.verifyClickMouse(coordinates)) {
	    	 // Dessin de la carte et de ses coins
		    context.renderFrame(graphics -> {
		        drawCard(graphics, x, y, width(), height(), cardColor);
		        drawCorner(graphics, x, y, cornerSize(), bordersize(), leftUpCornerColor);
		        drawCorner(graphics, x + width() - cornerSize(), y, cornerSize(), bordersize(), rightUpCornerColor);
		        drawCorner(graphics, x, y + height() - cornerSize(), cornerSize(), bordersize(), leftDownCornerColor);
		        drawCorner(graphics, x + width() - cornerSize(), y + height() - cornerSize(), cornerSize(), bordersize(), rightDownCornerColor);
		    });
		}
	}

	// Méthode pour dessiner la carte
	private void drawCard(Graphics2D graphics, float x, float y, int width, int height, Color color) {
		Objects.requireNonNull(graphics);
		Objects.requireNonNull(color);
		
	    graphics.setColor(color);
	    graphics.fill(new Rectangle2D.Float(x, y, width, height));
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Carte ressource | Point(s): ")
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
