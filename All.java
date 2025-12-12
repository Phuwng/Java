import java.util.*;

interface IMathOperation {
    double PI = 3.1416;
    void calculate();
    void showInfo();
}

class Addition implements IMathOperation {
    private float operand1;
    private float operand2;
    private float result;

    public Addition(float operand1, float operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public void calculate() {
        result = operand1 + operand2;
    }

    @Override
    public void showInfo() {
        calculate();
        System.out.println("Lớp: Addition");
        System.out.printf("%.2f + %.2f = %.2f\n", operand1, operand2, result);
    }
}

class Subtraction implements IMathOperation {
    private float operand1;
    private float operand2;
    private float result;

    public Subtraction(float operand1, float operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public void calculate() {
        result = operand1 - operand2;
    }

    @Override
    public void showInfo() {
        calculate();
        System.out.println("Lớp: Subtraction");
        System.out.printf("%.2f - %.2f = %.2f\n", operand1, operand2, result);
    }
}

class Multiplication implements IMathOperation {
    private float operand1;
    private float operand2;
    private float result;

    public Multiplication(float operand1, float operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public void calculate() {
        result = operand1 * operand2;
    }

    @Override
    public void showInfo() {
        calculate();
        System.out.println("Lớp: Multiplication");
        System.out.printf("%.2f * %.2f = %.2f\n", operand1, operand2, result);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float a1 = sc.nextFloat();
        float a2 = sc.nextFloat();
        float s1 = sc.nextFloat();
        float s2 = sc.nextFloat();
        float m1 = sc.nextFloat();
        float m2 = sc.nextFloat();

        Addition add = new Addition(a1, a2);
        Subtraction sub = new Subtraction(s1, s2);
        Multiplication mul = new Multiplication(m1, m2);

        add.showInfo();
        sub.showInfo();
        mul.showInfo();
    }
}



-----
import java.io.*;
import java.util.Scanner;

class MyObject implements Serializable {
    private String message;
    private int value;

    public MyObject(String message, int value) {
        this.message = message;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyObject{message='" + message + "', value=" + value + "}";
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập dữ liệu
        String message = sc.nextLine();
        int value = sc.nextInt();
        sc.close();

        // Tạo đối tượng
        MyObject obj = new MyObject(message, value);

        // Ghi đối tượng vào file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đọc lại đối tượng
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))) {
            MyObject readObj = (MyObject) ois.readObject();
            System.out.println(readObj);  // tự động gọi toString()
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


----
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


-----
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


-----
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            list.add(new Employee(name, age));
        }
        sc.close();

        // Predicate: lọc tuổi >= 25
        Predicate<Employee> ageFilter = e -> e.age >= 25;

        // Function: ánh xạ sang "Tên - Tuổi"
        Function<Employee, String> toStringFunc = e -> e.name + " - " + e.age;

        // Comparator: sắp xếp giảm dần theo tuổi
        Comparator<Employee> ageDesc = (a, b) -> b.age - a.age;

        // BinaryOperator: chọn chuỗi có độ dài lớn hơn
        BinaryOperator<String> longerString = (s1, s2) -> s1.length() >= s2.length() ? s1 : s2;

        // Xử lý bằng Streams
        List<String> result = list.stream()
                .filter(ageFilter)
                .sorted(ageDesc)
                .map(toStringFunc)
                .collect(Collectors.toCollection(LinkedList::new));

        // In ra
        result.forEach(System.out::println);
    }
}


