package factory;

public final class ShapeFactory {
    private ShapeFactory() {
    }

    // Callers ask for a shape by name and never see the concrete classes.
    public static Shape create(String type, double size) {
        return switch (type) {
            case "circle" -> () -> Math.PI * size * size;
            case "square" -> () -> size * size;
            default -> throw new IllegalArgumentException("Unknown shape: " + type);
        };
    }
}
