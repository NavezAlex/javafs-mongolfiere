package javafsmongolfiere.javafsmongolfiere.exceptions;

public class ElementNotFoundException extends RuntimeException {

    private final Object id;

    public ElementNotFoundException(Object id) {
        super("element d'id {"+ id+ "} introuvable.");
        this.id = id;
    }

    public Object getId() {
        return id;
    }
}
