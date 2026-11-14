package ValidPerson;

public class Main {
    public static void main(String[] args) {
        String[][] people = {{"Peter", "Petrov", "20"}, {"", "Petrov", "20"}, {"Peter", null, "20"},
                {"Peter", "Petrov", "-1"}, {"Peter", "Petrov", "121"}};
        for (String[] data : people) {
            try {
                new Person(data[0], data[1], Integer.parseInt(data[2]));
                System.out.println("Created " + data[0] + " " + data[1]);
            } catch (IllegalArgumentException e) {
                System.out.println("Exception thrown: " + e.getMessage());
            }
        }
        try {
            new Student("4havdar", "chavdar@softuni.bg");
        } catch (InvalidPersonNameException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }
    }
}
