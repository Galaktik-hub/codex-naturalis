package codexnaturalis.card;

import java.awt.Color;

import fr.umlv.zen5.ApplicationContext;

public record RessourceCard(RessourceType type, 
													  RessourceType leftUpCorner, 
													  RessourceType rightUpCorner, 
													  RessourceType leftDownCorner, 
													  RessourceType rightDownCorner, 
													  int point) implements Card {
	
	@Override
	public void draw(ApplicationContext context, float x, float y) {
		Color color = Card.getColor(type);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Carte dorure | Point(s): ")
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
