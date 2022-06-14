package bg.softuni.exercise_05;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("4havdar", "cvqtkokirilov@gmail.com");
        Student student2 = new Student("", "cvqtkokirilov@gmail.com");
        Student student3 = new Student(null, "cvqtkokirilov@gmail.com");

        Student student4 = new Student("Chavdar", "");
        Student student5 = new Student("Chavdar", null);
        Student student6 = new Student("Chavdar", "cvqtkokirilov.gmail.com");
    }
}
