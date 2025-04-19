import java.util.ArrayList;

public class SortedList {
    private final ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    public void add(String item) {
        int index = findInsertIndex(item);
        list.add(index, item);
    }

    public int findInsertIndex(String item) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = item.compareTo(list.get(mid));

            if (cmp == 0) return mid; // item already exists
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return low; // correct insert location
    }

    public int search(String item) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = item.compareTo(list.get(mid));

            if (cmp == 0) return mid;
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return -low - 1; // not found, return negative insertion point
    }

    public ArrayList<String> getList() {
        return list;
    }
}
