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
