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
