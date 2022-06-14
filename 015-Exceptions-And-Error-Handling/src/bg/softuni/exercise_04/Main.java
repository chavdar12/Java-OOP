package bg.softuni.exercise_04;

public class Main {
    public static void main(String[] args) {

        try {
            Person peter = new Person("Peter", "Petroc", 19);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Person noName = new Person(" ", "Petroc", 19);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Person noLastName = new Person("Peter", null, 19);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Person negativeAge = new Person("Peter", "Petroc", -1);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Person tooOld = new Person("Peter", "Petroc", 121);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
