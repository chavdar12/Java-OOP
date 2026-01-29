package SayHello;

public class Chinese implements Person {

    private final String name;

    public Chinese(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
