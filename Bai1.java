import java.util.Scanner;

interface IMathOperation {
    float PI = 3.1416f;

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
        System.out.printf("%s\n", "Addition");
        System.out.printf("%.2f + %.2f = %.2f\n", operand1, operand2, result);
        System.out.println();
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
        System.out.printf("%s\n", "Subtraction");
        System.out.printf("%.2f - %.2f = %.2f\n", operand1, operand2, result);
        System.out.println();
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
        System.out.printf("%s\n", "Multiplication");
        System.out.printf("%.2f * %.2f = %.2f\n", operand1, operand2, result);
        System.out.println();
    }
}

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập 6 số thực
        float add1 = sc.nextFloat();
        float add2 = sc.nextFloat();
        float sub1 = sc.nextFloat();
        float sub2 = sc.nextFloat();
        float mul1 = sc.nextFloat();
        float mul2 = sc.nextFloat();

        // Tạo đối tượng
        Addition add = new Addition(add1, add2);
        Subtraction sub = new Subtraction(sub1, sub2);
        Multiplication mul = new Multiplication(mul1, mul2);

        // Hiển thị
        add.showInfo();
        sub.showInfo();
        mul.showInfo();

        sc.close();
    }
}
