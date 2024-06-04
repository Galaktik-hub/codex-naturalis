package codexnaturalis.card;

public record Coordinates(float x, float y) {

    public Coordinates add(Coordinates newCoordinates) {
        return new Coordinates(x + newCoordinates.x, y + newCoordinates.y);
    } 
}