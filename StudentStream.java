import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    // ✅ Proper getter for marks
    public double getMarks() {
        return marks;
    }

    public String toString() {
        return name + " - " + marks + "%";
    }
}

public class StudentStream {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Amit", 80),
            new Student("Ravi", 65),
            new Student("Neha", 90),
            new Student("Kiran", 70),
            new Student("Pooja", 88)
        );

        // ✅ Fully Stream-based processing
        List<Student> filteredAndSorted = students.stream()
                .filter(s -> s.getMarks() > 75) // filter condition
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed()) // sort descending
                .collect(Collectors.toList()); // collect results into a list

        System.out.println("Students scoring above 75% (sorted by marks):");
        filteredAndSorted.stream()
                .map(Student::toString)
                .forEach(System.out::println);
    }
}
