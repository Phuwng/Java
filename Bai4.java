import java.util.*;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        sc.close();

        // TreeSet tự loại trùng + sắp xếp tăng dần
        TreeSet<Integer> set = new TreeSet<>(list);

        // In ra
        for (int x : set) {
            System.out.print(x + " ");
        }
    }
}
