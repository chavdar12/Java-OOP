package ValidPerson;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = requireName(firstName, "first");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = requireName(lastName, "last");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age should be in the range [0 ... 120]");
        }
        this.age = age;
    }

    private static String requireName(String name, String which) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The " + which + " name cannot be null or empty");
        }
        return name;
    }
}
