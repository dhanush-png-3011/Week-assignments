public class Week4_RiskThresholdSearch {

    static int floor(int[] arr, int x) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] <= x) {
                res = arr[m];
                l = m + 1;
            } else r = m - 1;
        }
        return res;
    }

    static int ceil(int[] arr, int x) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] >= x) {
                res = arr[m];
                r = m - 1;
            } else l = m + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 50, 100};
        System.out.println(floor(arr, 30));
        System.out.println(ceil(arr, 30));
    }
}