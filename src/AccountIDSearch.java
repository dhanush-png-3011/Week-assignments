public class AccountIDSearch {

    static int linearSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(key)) return i;
        return -1;
    }

    static int binarySearch(String[] arr, String key) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m].equals(key)) return m;
            else if (arr[m].compareTo(key) < 0) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] arr = {"A", "B", "B", "C"};
        System.out.println(linearSearch(arr, "B"));
        System.out.println(binarySearch(arr, "B"));
    }
}