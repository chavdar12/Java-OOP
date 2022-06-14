package bg.softuni.exercise_05;

import java.util.regex.Pattern;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        try {
            this.setName(name);
            this.setEmail(email);
        } catch (InvalidPersonNameException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    private void setName(String name) throws InvalidPersonNameException {

        if ((name == null) || name.equals("") || (!name.matches("^[a-zA-Z]*$"))) {
            throw new InvalidPersonNameException(
                    "Name cannot be empty and should not contain special characters and numbers");
        }

        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) throws InvalidPersonNameException {

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                            + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null || !pat.matcher(email).matches()) {
            throw new InvalidPersonNameException("Invalid email");
        }

        this.email = email;
    }

}
