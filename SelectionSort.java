import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort {
    public static void sort(ArrayList<Student> list, Comparator<Student> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            Student temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
    }
}
