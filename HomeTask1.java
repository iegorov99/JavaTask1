import java.util.Scanner;


public class HomeTask1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // task1();
        // task2();
        task3();
    }
    // 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
    static void task1() {

        System.out.print("Введите номер числа: ");
        int number = sc.nextInt();
        System.out.printf("%d-е треугольное число - это %d", number, triangle(number));
        System.out.println();
        System.out.printf("Факториал числа %d - это %d", number, factorial(number));
    }

    static int triangle(int number) {
        if (number == 1)
            return 1;
        else
            return (number + triangle(number-1));
    }

    static int factorial(int number) {
        int res = 1;
        for (int i = 1; i <= number; i++) {
            res *=i;
        }
        return res;
    }

    // 2) Вывести все простые числа от 1 до 1000
    static void task2() {
        for (int i = 2; i <= 1000; i++) {
            boolean flag = false;
            for (int j = 2; j * j < i; j++) {
                flag = i % j == 0;
                if (flag) 
                    break;
            }
            if (!flag)
                System.out.print(i + " ");
        }

    }
    // 3) Реализовать простой калькулятор
    public static void task3() {
        
        int a = getNum();
        int b = getNum();
        
        print();

        int op = getOp();

        calc(a, b, op);

    }

    public static int getNum() {
        System.out.println("Введите число: ");
        int num;
        if (sc.hasNextInt())
            num = sc.nextInt();
        else {
            System.out.println("Неверное значение! Попробуйте снова.");
            sc.next();
            num = getNum();
        }
        return num;
    }

    static int getOp() {
        System.out.println("Выберите операцию: ");
        int op;
        if (sc.hasNextInt())
            op = sc.nextInt();
        else {
            System.out.println("Неверное значение! Попробуйте снова.");
            sc.next();
            op = getOp();
        }
        return op;
    }

    static void print() {
        System.out.println("1 - сложение");
        System.out.println("2 - вычитание");
        System.out.println("3 - умножение");
        System.out.println("4 - деление");
    }

    static void calc(int a, int b , int op) {
        switch (op) {
            case 1 :
                System.out.printf("Сумма чисел %d и %d равна %d", a, b, a + b);
                break;
            case 2 :
                System.out.printf("Разность чисел %d и %d равна %d", a, b, a - b);
                break;
            case 3 :
                System.out.printf("Произведение чисел %d и %d равно %d", a, b, a * b);
                break;
            case 4 :
                System.out.printf("Частное чисел %d и %d равна %d", a, b, a / b);
                break;
            default :
                System.out.println("Операция не распознана! Повторите попытку.");
                calc(a, b, getOp());
        }
    }
}