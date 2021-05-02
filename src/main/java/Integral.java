public class Integral {
    private double leftBoard; // нижняя граница предела
    private double rightBoard; // верхняя граница предела
    public static double eps = 0.0001;
    private int n; // число отрезков - вводит пользователь - от него зависит точность
    private double result;
    private boolean checkSecond = false;
    public static boolean call = false;
    private double i0 = 0;
    private static boolean checkStop = false;
    private double rynge;
    private static double firstResult;
    public static double exOne;
    public static int nOne;
    public static boolean s = false;
    public static double rightZAPAS;
    public static int nZAPAS;


    public Integral(double leftBoard, double rightBoard, int n) {
        this.leftBoard = leftBoard;
        this.rightBoard = rightBoard;
        this.n = n;
    }

    public  Integral(){}



    public static void methodSimpson(Integral integral, Function function) {
        if (integral.checkSecond) {
            checkStop = true;
            rightZAPAS = integral.rightBoard;
            nZAPAS = integral.n;
            methodSimpson(new Integral(integral.leftBoard, 0 - 0.0001, integral.n), function);
        }else {
            double h = (integral.rightBoard - integral.leftBoard) / integral.n;
            double sumX_2 = 0d;
            double sumX_4 = 0d;
            double x;
            for (int i = 1; i < integral.n; i += 2) {
                x = integral.leftBoard + i * h;
                sumX_4 = sumX_4 + function.func(x);
            }

            for (int i = 2; i < integral.n - 1; i += 2) {
                x = integral.leftBoard + i * h;
                sumX_2 = sumX_2 + function.func(x);
            }

            integral.result = ((sumX_2 * 2 + sumX_4 * 4 + function.func(integral.leftBoard) + function.func(integral.rightBoard)) * h) / 3;
            double resultRynge = ryhgeMethod(integral.result, integral.i0);
            integral.i0 = integral.result;
            integral.rynge = resultRynge;
//            System.out.println("sss: " + resultRynge);
            while (resultRynge >= eps) {
                integral.n *= 2;
                methodSimpson(integral, function);
            }
            /* сюда дойдет код когда закончиться рекурсия*/
            if (checkStop) {
                if (!s) {
                    firstResult = integral.result;
                    exOne = integral.rynge;
                    nOne = integral.n;
                    s = true;
                    methodSimpson(new Integral(0 + eps, rightZAPAS, nZAPAS), function);
                }else {
                    integral.result = integral.result + firstResult;
                    integral.n = integral.n + nOne;
                    integral.rynge = (integral.rynge + exOne) / 2;
                    Output.printIntegral(integral);
                }
            }else {
                Output.printIntegral(integral);
            }
        }
    }
    /* i1 текущее - i0 - предыдущее */
    public static double ryhgeMethod(double i1, double i0) {
        return Math.abs(i1 - i0) / 15;
    }



    // проверяем промежутки
    public static void checkForSecond(Integral integral) {
        if ((integral.getLeftBoard() > 0 && integral.getRightBoard() > 0) || (integral.getLeftBoard() < 0 && integral.getRightBoard() < 0)){
            integral.setCheckSecond(false);
        }else {
            if (integral.getRightBoard() < 0 && integral.getLeftBoard() > 0) {
                call = true;
                integral.setCheckSecond(true);
                double glass = integral.getLeftBoard();
                integral.setLeftBoard(integral.getRightBoard());
                integral.setRightBoard(glass);
            }
            if (integral.getRightBoard() > 0 && integral.getLeftBoard() < 0) {
                integral.setCheckSecond(true);
            }
            else if (integral.getLeftBoard() == 0 && integral.getRightBoard() > 0) {
                integral.setLeftBoard(integral.getLeftBoard() + integral.getEps());
                integral.setCheckSecond(false);
            }else if (integral.getRightBoard() == 0 && integral.getLeftBoard() < 0) {
                integral.setRightBoard(integral.getRightBoard() - integral.getEps());
                integral.setCheckSecond(false);
            }
            else if (integral.getLeftBoard() == 0 && integral.getRightBoard() < 0) {
                integral.setLeftBoard(integral.getLeftBoard() - integral.getEps());
                integral.setCheckSecond(false);
            }else if(integral.getRightBoard() == 0 && integral.getLeftBoard() > 0) {
                integral.setRightBoard(integral.getRightBoard() + integral.getEps());
                integral.setCheckSecond(false);
            }
        }
    }

    public boolean isCall() {
        return call;
    }

    public void setCall(boolean call) {
        this.call = call;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getLeftBoard() {
        return leftBoard;
    }

    public void setLeftBoard(double leftBoard) {
        this.leftBoard = leftBoard;
    }

    public double getRightBoard() {
        return rightBoard;
    }

    public void setRightBoard(double rightBoard) {
        this.rightBoard = rightBoard;
    }

    public double getEps() {
        return eps;
    }

    public double getRynge() {
        return rynge;
    }

    public void setRynge(double rynge) {
        this.rynge = rynge;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    public boolean isCheckSecond() {
        return checkSecond;
    }

    public void setCheckSecond(boolean checkSecond) {
        this.checkSecond = checkSecond;
    }

    public double getI0() {
        return i0;
    }

    public void setI0(double i0) {
        this.i0 = i0;
    }

    public boolean isCheckStop() {
        return checkStop;
    }

    public void setCheckStop(boolean checkStop) {
        this.checkStop = checkStop;
    }

}

