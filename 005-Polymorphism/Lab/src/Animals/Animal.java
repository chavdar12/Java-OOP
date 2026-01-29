package Animals;

public class Animal {
    private final String name;
    private final String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public String explainSelf() {
        return String.format("I am %s and my favorite food is %s", this.name, this.favouriteFood);
    }
}
