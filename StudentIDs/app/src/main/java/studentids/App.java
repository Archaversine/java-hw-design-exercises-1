/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package studentids;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class App {

    private static class Student {
        public final int id;
        public final String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override 
        public String toString() {
            return String.format("Student(id=%d, name=%s)", id, name);
        }
    }

    private static class AllStudents {
        public static final ArrayList<Student> students = new ArrayList<>();

        // Ideally I would make this load from a database but for this class 
        // I am just going to hardcode some values in
        public static void loadStudents() {
            students.add(new Student(1, "John"));
            students.add(new Student(2, "Jane"));
            students.add(new Student(3, "Joe"));
            students.add(new Student(4, "Jill"));
            students.add(new Student(5, "Jack"));
        }
    }

    private static class School {
        private final Set<Student> students = new HashSet<>();

        public void swipeIn(Student student) {
            students.add(student);
        }

        public void printStudents() {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        AllStudents.loadStudents();
        School school = new School();

        for (Student student : AllStudents.students) {
            school.swipeIn(student);
            school.swipeIn(student); // swipe in twice to show that duplicates are not added
        }

        school.printStudents();
    }

    public static boolean test1() {
        AllStudents.loadStudents();
        School school = new School();

        for (Student student : AllStudents.students) {
            school.swipeIn(student);
            school.swipeIn(student); // swipe in twice to show that duplicates are not added
        }

        return school.students.size() == AllStudents.students.size();
    }

    public static boolean test2() {
        AllStudents.loadStudents();
        School school = new School();

        for (Student student : AllStudents.students) {
            school.swipeIn(student);
            school.swipeIn(student);
            school.swipeIn(student); // swipe in thrice to show that duplicates are not added
        }

        return school.students.size() == AllStudents.students.size();
    }
}
