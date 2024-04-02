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
	public void draw(ApplicationContext context, float x, float y) {
		Objects.requireNonNull(context);
		Color color = Card.getColor(type);
		Color leftUpCornerColor = Card.getColor(leftUpCorner);
		Color rightUpCornerColor = Card.getColor(rightUpCorner);
		Color leftDownCornerColor = Card.getColor(leftDownCorner);
		Color rightDownCornerColor = Card.getColor(rightDownCorner);
		int widthCard = 200;
		int heightCard = 80;
		int conerSize = 20;
		
		context.renderFrame(graphics -> {
			graphics.setColor(color);
			var card = new Rectangle2D.Float(x, y, widthCard, heightCard);
			var leftUpCornerRectangle = new Rectangle2D.Float(x, y, conerSize, conerSize);
			var rightUpCornerRectangle = new Rectangle2D.Float(widthCard - conerSize, y, conerSize, conerSize);
			var leftDownCornerRectangle = new Rectangle2D.Float(x, heightCard - conerSize, conerSize, conerSize);
			var rightDownCornerRectangle = new Rectangle2D.Float(widthCard - conerSize, heightCard - conerSize, conerSize, conerSize);
			graphics.fill(card);
			graphics.fill(leftUpCornerRectangle);
			graphics.fill(rightUpCornerRectangle);
			graphics.fill(leftDownCornerRectangle);
			graphics.fill(rightUpCornerRectangle);
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
