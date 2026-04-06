import java.util.*;

class AssetA {
    String name;
    double returnRate;
    double volatility;

    AssetA(String n, double r, double v) {
        name = n;
        returnRate = r;
        volatility = v;
    }
}

public class PortfolioSorting {

    static void merge(List<AssetA> arr, int l, int m, int r) {
        List<AssetA> temp = new ArrayList<>();
        int i = l, j = m + 1;
        while (i <= m && j <= r)
            temp.add(arr.get(i).returnRate <= arr.get(j).returnRate ? arr.get(i++) : arr.get(j++));
        while (i <= m) temp.add(arr.get(i++));
        while (j <= r) temp.add(arr.get(j++));
        for (int k = 0; k < temp.size(); k++) arr.set(l + k, temp.get(k));
    }

    static void mergeSort(List<AssetA> arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static int partition(List<AssetA> arr, int l, int r) {
        AssetA pivot = arr.get(r);
        int i = l - 1;
        for (int j = l; j < r; j++)
            if (arr.get(j).returnRate > pivot.returnRate ||
                    (arr.get(j).returnRate == pivot.returnRate &&
                            arr.get(j).volatility < pivot.volatility)) {
                i++;
                Collections.swap(arr, i, j);
            }
        Collections.swap(arr, i + 1, r);
        return i + 1;
    }

    static void quickSort(List<AssetA> arr, int l, int r) {
        if (l < r) {
            int pi = partition(arr, l, r);
            quickSort(arr, l, pi - 1);
            quickSort(arr, pi + 1, r);
        }
    }
}