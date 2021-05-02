import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Пожалуйста, выберите тип уравнения:\n"
        + "1: I = (x^3 - cos(x))dx\n"
        + "2: I = (cos(x))dx\n"
        + "3: I = (sin(x)/x)dx\n" // разрыв первого рода
        + "4: I = (1/x)dx\n" // // разрыв второго рода
        + "0: Завершить программу");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        Integral integral = new Integral();
            switch (type) {
                case 1:
                    Function function1;
                    function1 = (x) -> Math.pow(x, 3) - Math.cos(x);
                    System.out.println("Пожалуйста, введите границы промежутка");
                    integral.setLeftBoard(scanner.nextDouble());
                    integral.setRightBoard(scanner.nextDouble());
                    System.out.println("Пожалуйста, введите точность");;
                    integral.setN(scanner.nextInt());
                    System.out.println(Integral.methodSimpson(integral, function1).getResult());
                    break;
                case 2:
                    Function function2;
                    function2 = (x) -> Math.cos(x);
                    System.out.println("Пожалуйста, введите границы промежутка");
                    integral.setLeftBoard(scanner.nextDouble());
                    integral.setRightBoard(scanner.nextDouble());
                    System.out.println("Пожалуйста, введите точность");;
                    integral.setN(scanner.nextInt());
                    integral = Integral.methodSimpson(integral, function2);
                    System.out.println("I = " + integral.getResult());
                    System.out.println("Погрешность = " + integral.getRynge());
                    break;
                case 3:
                    Function function3;
                    function3 = (x) -> x != 0 ? (Math.sin(x) / x) : 1;
                    System.out.println("Пожалуйста, введите границы промежутка");
                    integral.setLeftBoard(scanner.nextDouble());
                    integral.setRightBoard(scanner.nextDouble());
                    if ((integral.getLeftBoard() < 0 && integral.getRightBoard() > 0) ||
                            (integral.getLeftBoard() > 0 && integral.getRightBoard() < 0) ||
                            integral.getRightBoard() == 0 || integral.getLeftBoard() == 0) {
                        System.out.println("ИНФО: Вы наткнулись на устранимый разрвыв 1 рода :)");
                    }
                    System.out.println("Пожалуйста, введите точность");;
                    integral.setN(scanner.nextInt());
                    System.out.println(Integral.methodSimpson(integral, function3).getResult());
                    break;
                case 4:
                    Function function4;
                    function4 = (x) -> 1.0 / x;
                    System.out.println("Пожалуйста, введите границы промежутка");
                    integral.setLeftBoard(scanner.nextDouble());
                    integral.setRightBoard(scanner.nextDouble());
                    System.out.println("Пожалуйста, введите точность");;
                    integral.setN(scanner.nextInt());
                    if ((integral.getLeftBoard() < 0 && integral.getRightBoard() > 0) ||
                            (integral.getLeftBoard() > 0 && integral.getRightBoard() < 0) ||
                            integral.getRightBoard() == 0 || integral.getLeftBoard() == 0) {
                        System.out.println("ИНФО: Вы наткнулись на неустранимый разрвыв 2 рода :)");
                    }
                    Integral.checkForSecond(integral);
                    double result = Integral.methodSimpson(integral, function4).getResult();
                    if (integral.isCall() && integral.getResult() != 0.0) {
                        System.out.println(-result);
                    }else {
                        System.out.println(result);
                    }
                    break;
                default:
                    System.out.println("Программа завершена...");
                    break;
            }
        }
}
