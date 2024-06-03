package codexnaturalis.card;

import java.awt.Color;

public enum RessourceType implements Collectible {
	ANIMAL, PLANT, FUNGI, INSECT, INVISIBLE, EMPTY;
	
	@Override
  public Color getColor() {
      return switch (this) {
          case ANIMAL -> Color.BLUE;
          case FUNGI -> Color.ORANGE;
          case INSECT -> Color.MAGENTA;
          case PLANT -> Color.GREEN;
          case INVISIBLE -> Color.BLACK;
          case EMPTY -> Color.WHITE;
          default -> throw new IllegalArgumentException("Unexpected value: " + this);
      };
  }
}