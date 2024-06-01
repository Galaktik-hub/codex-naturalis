package codexnaturalis.card;

import fr.umlv.zen5.ApplicationContext;

import java.util.List;

public record StarterCard(Collectible rectoLeftUpCorner,
                          Collectible rectoRightUpCorner,
                          Collectible rectoLeftDownCorner,
                          Collectible rectoRightDownCorner,
                          Collectible versoLeftUpCorner,
                          Collectible versoRightUpCorner,
                          Collectible versoLeftDownCorner,
                          Collectible versoRightDownCorner,
                          List<String> ressources) implements Card {
    @Override
    public void draw(ApplicationContext context, Coordinates coordinates) {

    }

    @Override
    public boolean isValidCorner(int corner) {
        return switch (corner) {
            // En haut à gauche = 0, en haut à droite = 1, en bas à droite = 2, en bas à gauche = 3
            case 0 -> !(this.rectoLeftUpCorner.equals(RessourceType.EMPTY));
            case 1 -> !(this.rectoRightUpCorner.equals(RessourceType.EMPTY));
            case 2 -> !(this.rectoRightDownCorner.equals(RessourceType.EMPTY));
            case 3 -> !(this.rectoLeftDownCorner.equals(RessourceType.EMPTY));
            default -> throw new IllegalArgumentException("Le coin choisi n'est pas possible");
        };
    }
}
