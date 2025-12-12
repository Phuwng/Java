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
