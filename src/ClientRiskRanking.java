class ClientA {
    String name;
    int risk;
    int balance;

    ClientA(String n, int r, int b) {
        name = n;
        risk = r;
        balance = b;
    }
}

public class ClientRiskRanking {

    static void bubbleSort(ClientA[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j].risk > arr[j + 1].risk) {
                    ClientA t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
    }

    static void insertionSort(ClientA[] arr) {
        for (int i = 1; i < arr.length; i++) {
            ClientA key = arr[i];
            int j = i - 1;
            while (j >= 0 && (arr[j].risk < key.risk ||
                    (arr[j].risk == key.risk && arr[j].balance < key.balance))) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        ClientA[] arr = {
                new ClientA("A", 20, 1000),
                new ClientA("B", 50, 2000),
                new ClientA("C", 80, 500)
        };

        bubbleSort(arr);
        insertionSort(arr);

        for (ClientA c : arr)
            System.out.println(c.name + " " + c.risk);
    }
}