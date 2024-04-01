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
		int widthCard = 200;
		int heightCard = 80;
		
		context.renderFrame(graphics -> {
			graphics.setColor(color);
			var card = new Rectangle2D.Float(x, y, widthCard, heightCard);
			graphics.fill(card);
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
