import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", "123 Lane"));
        students.add(new Student(2, "Bob", "456 Lane"));
        students.add(new Student(3, "Charlie", "789 Lane"));
        // add more students as needed...

        System.out.println("Original list:");
        students.forEach(System.out::println);

        // Sorting by rollno
        SelectionSort.sort(students, new RollNoComparator());
        System.out.println("\nSorted by roll number:");
        students.forEach(System.out::println);

        // Sorting by name
        SelectionSort.sort(students, new NameComparator());
        System.out.println("\nSorted by name:");
        students.forEach(System.out::println);
    }
}
