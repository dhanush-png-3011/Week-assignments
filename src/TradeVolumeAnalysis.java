public class TradeVolumeAnalysis {

    static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r)
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, l, temp.length);
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static int partition(int[] arr, int l, int r) {
        int pivot = arr[r], i = l - 1;
        for (int j = l; j < r; j++)
            if (arr[j] > pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        int t = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = t;
        return i + 1;
    }

    static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pi = partition(arr, l, r);
            quickSort(arr, l, pi - 1);
            quickSort(arr, pi + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {500, 100, 300};
        mergeSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
    }
}