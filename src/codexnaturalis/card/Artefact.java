package codexnaturalis.card;

import java.awt.Color;

public enum Artefact implements Collectible {
    QUILL, MANUSCRIPT, INKWELL;
    
    @Override
    public Color getColor() {
        return switch (this) {
            case INKWELL -> Color.RED;
            case MANUSCRIPT -> Color.YELLOW;
            case QUILL -> Color.PINK;
        };
    }
}
