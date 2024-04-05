package codexnaturalis.card;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.Objects;

import fr.umlv.zen5.ApplicationContext;

public record GoldenCard(RessourceType type, 
						 RessourceType leftUpCorner, 
						 RessourceType rightUpCorner, 
						 RessourceType leftDownCorner, 
						 RessourceType rightDownCorner, 
						 int point, 
						 List<RessourceType> cost) implements Card {
	
	@Override
	public void draw(ApplicationContext context, Coordinates coordinates) {
		Objects.requireNonNull(context);
		Objects.requireNonNull(coordinates);
		
		// On récupère la couleur de la ressource depuis l'interface Card
		Color cardColor = Card.getColor(type); // Couleur de la bordure des coins
		Color leftUpCornerColor = Card.getColor(leftUpCorner); // Couleur du coin supérieur gauche de la carte
		Color rightUpCornerColor = Card.getColor(rightUpCorner); // Couleur du coin supérieur droit de la carte
		Color leftDownCornerColor = Card.getColor(leftDownCorner); // Couleur du coin inférieur gauche de la carte
		Color rightDownCornerColor = Card.getColor(rightDownCorner); // Couleur du coin inférieur droit de la carte
		Color borderColor = Color.GRAY;
		int widthCard = 200;
		int heightCard = 80;
		int cornerSize = 20;
		int borderSize = 2;
		float x = coordinates.x();
		float y = coordinates.y();
		
		//Dessin de la carte
		context.renderFrame(graphics -> {
			
			// Dessin du rectangle carte
			graphics.setColor(cardColor);
			var card = new Rectangle2D.Float(x, y, widthCard, heightCard);
			graphics.fill(card);
			
			// Dessin du coin avec des bordures, deux rectangles (la bordure plus grande que l'autre)
			
			// Dessin du coin supérieur gauche
			// Dessin de la bordure du coin en gris
			graphics.setColor(borderColor);
			var leftUpBorder = new Rectangle2D.Float(x, y, cornerSize, cornerSize);
			graphics.fill(leftUpBorder);
			
			// Dessin du coin 'dans' la bordure afin de voir seulement les bordures avec les calculs de coordonnées
			graphics.setColor(leftUpCornerColor);
			var leftUpCornerRectangle = new Rectangle2D.Float(x, y, cornerSize - borderSize, cornerSize - borderSize);
			graphics.fill(leftUpCornerRectangle);
			
			
			
			//Dessin du coin supérieur droit
			// Dessin de la bordure du coin en gris
			graphics.setColor(borderColor);
			var rightUpBorder = new Rectangle2D.Float((x + widthCard) - cornerSize, y, cornerSize, cornerSize); // coordonnées afin que la bordure soit plus grande que le coin
			graphics.fill(rightUpBorder);
			
			// Dessin du coin 'dans' la bordure afin de voir seulement les bordures avec les calculs de coordonnées
			graphics.setColor(rightUpCornerColor);
			var rightUpCornerRectangle = new Rectangle2D.Float((x + widthCard) - cornerSize + borderSize, y, cornerSize - borderSize, cornerSize - borderSize);
			graphics.fill(rightUpCornerRectangle);
			
			
			// Dessin du coin inférieur gauche
			// Dessin de la bordure du coin en gris
			graphics.setColor(borderColor);
			var leftDownBorder = new Rectangle2D.Float(x, (y + heightCard) - cornerSize, cornerSize, cornerSize);
			graphics.fill(leftDownBorder);
			
			// Dessin du coin inférieur gauche
			// Dessin de la bordure du coin en gris
			graphics.setColor(leftDownCornerColor);
			var leftDownCornerRectangle = new Rectangle2D.Float(x, ((y + heightCard) - cornerSize) + borderSize, cornerSize - borderSize, cornerSize - borderSize);
			graphics.fill(leftDownCornerRectangle);
			
			
			
			// Dessin du coin inférieur droit
			// Dessin de la bordure du coin en gris
			graphics.setColor(borderColor);
			var rightDownBorder = new Rectangle2D.Float((x + widthCard) - cornerSize, (y + heightCard) - cornerSize, cornerSize, cornerSize);
			graphics.fill(rightDownBorder);
			graphics.setColor(leftDownCornerColor);
			var rightDownCornerRectangle = new Rectangle2D.Float(((x + widthCard) - cornerSize) + borderSize, ((y + heightCard) - cornerSize) + borderSize, cornerSize - borderSize, cornerSize - borderSize);
			graphics.fill(rightDownCornerRectangle);
		});
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
