package FoodShortage;

public class Rebel implements Buyer, Person {
    private final String name;
    private final int age;
    private final String group;
    private int food = 0;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public int getFood() {
        return food;
    }

    public void buyFood() {
        this.food += 5;
    }
}
