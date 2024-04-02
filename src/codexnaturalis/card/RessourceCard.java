package codexnaturalis.card;

import java.awt.Color;
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
	public void draw(ApplicationContext context, float x, float y) {
		Objects.requireNonNull(context);
		Color color = Card.getColor(type);
		Color leftUpCornerColor = Card.getColor(leftUpCorner);
		Color rightUpCornerColor = Card.getColor(rightUpCorner);
		Color leftDownCornerColor = Card.getColor(leftDownCorner);
		Color rightDownCornerColor = Card.getColor(rightDownCorner);
		int widthCard = 200;
		int heightCard = 80;
		int cornerSize = 20;
		int borderSize = 2;
		
		context.renderFrame(graphics -> {
//			Dessin de la carte
			graphics.setColor(color);
			var card = new Rectangle2D.Float(x, y, widthCard, heightCard);
			graphics.fill(card);
			
//			Dessin du coin supérieur gauche
			graphics.setColor(Color.GRAY);
			var leftUpBorder = new Rectangle2D.Float(x, y, cornerSize + borderSize, cornerSize + borderSize);
			graphics.fill(leftUpBorder);
			graphics.setColor(leftUpCornerColor);
			var leftUpCornerRectangle = new Rectangle2D.Float(x + borderSize, y + borderSize, cornerSize - borderSize, cornerSize - borderSize);
			graphics.fill(leftUpCornerRectangle);
			
//			Dessin du coin supérieur droit
			graphics.setColor(Color.GRAY);
			var rightUpBorder = new Rectangle2D.Float((x + widthCard) - cornerSize, y, cornerSize, cornerSize);
			graphics.fill(rightUpBorder);
			graphics.setColor(rightUpCornerColor);
			var rightUpCornerRectangle = new Rectangle2D.Float((x + widthCard) - cornerSize + borderSize, y, cornerSize - borderSize, cornerSize - borderSize);
			graphics.fill(rightUpCornerRectangle);
			
//			Dessin du coin inférieur gauche
			graphics.setColor(Color.GRAY);
			var leftDownBorder = new Rectangle2D.Float(x, (y + heightCard) - cornerSize, cornerSize, cornerSize);
			graphics.fill(leftDownBorder);
			graphics.setColor(leftDownCornerColor);
			var leftDownCornerRectangle = new Rectangle2D.Float(x, (y + heightCard) - cornerSize, cornerSize - borderSize, cornerSize - borderSize);
			graphics.fill(leftDownCornerRectangle);
			
//			Dessin du coin inférieur droit
			graphics.setColor(Color.GRAY);
			var rightDownBorder = new Rectangle2D.Float((x + widthCard) - cornerSize, (y + heightCard) - cornerSize, cornerSize, cornerSize);
			graphics.fill(rightDownBorder);
			graphics.setColor(leftDownCornerColor);
			var rightDownCornerRectangle = new Rectangle2D.Float((x + widthCard) - cornerSize, (y + heightCard) - cornerSize, cornerSize - borderSize, cornerSize - borderSize);
			graphics.fill(rightDownCornerRectangle);
		});
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
