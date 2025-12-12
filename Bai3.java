import java.util.*;

class CountThread extends Thread {
    private int[] arr;
    private int left, right;  // đoạn cần xử lý
    private int x;
    private int count = 0;

    public CountThread(int[] arr, int left, int right, int x) {
        this.arr = arr;
        this.left = left;
        this.right = right;
        this.x = x;
    }

    @Override
    public void run() {
        for (int i = left; i < right; i++) {
            if (arr[i] == x) count++;
        }
    }

    public int getCount() {
        return count;
    }
}

public class Bai3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        int X = sc.nextInt();
        int K = sc.nextInt();
        sc.close();

        CountThread[] threads = new CountThread[K];

        int block = N / K;
        int start = 0;

        for (int i = 0; i < K; i++) {
            int end = (i == K - 1) ? N : start + block;
            threads[i] = new CountThread(arr, start, end, X);
            threads[i].start();
            start = end;
        }

        int total = 0;
        for (int i = 0; i < K; i++) {
            threads[i].join();
            total += threads[i].getCount();
        }

        System.out.println(total);
    }
}
