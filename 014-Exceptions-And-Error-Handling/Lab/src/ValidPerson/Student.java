package ValidPerson;

public class Student {
    private final String name;
    private final String email;

    public Student(String name, String email) {
        if (!name.matches("[A-Za-z ]+")) {
            throw new InvalidPersonNameException("Name may contain only letters: " + name);
        }
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
