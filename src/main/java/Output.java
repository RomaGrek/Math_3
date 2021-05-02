public class Output {
    Integral integral;

    public static void printIntegral(Integral integral) {

        if (Integral.s) {
            double result = integral.getResult();
            if (Integral.call && integral.getResult() != 0.0) {
                System.out.println("I = " + (-result));
            }else {
                System.out.println("I = " + result);
            }
            System.out.println("n = " + integral.getN());
            System.out.println("e = " + integral.getRynge());
            System.exit(0);
        }else {
            System.out.println("I = " + integral.getResult());
            System.out.println("n = " + integral.getN());
            System.out.println("e = " + integral.getRynge());
            System.exit(0);
        }
    }
}
