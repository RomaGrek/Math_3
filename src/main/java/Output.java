public class Output {
    Integral integral;

    public static void printIntegral(Integral integral) {
        System.out.println("I = " + integral.getResult());
        System.out.println("n = " + integral.getN());
        System.out.println("e = " + integral.getRynge());
        System.exit(0);
    }
}
