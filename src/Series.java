class SumException extends Exception { //наследование только от одного класса
    public SumException(String s) {
        super(s); //конструктор предка
    }
}

public class Series {
    public static void main(String args[]) //args - параметры командной строки
    {
        try {
            if (args.length != 2)
                throw new SumException("Wrong number of arguments");
            Double x  = Double.parseDouble(args[0]); //метод возвращает int, но присваивается Integer'у
            Double eps = Double.parseDouble(args[1]);
            System.out.println(getSum(x, eps));

        }
        catch (NumberFormatException e) {
            System.out.println("Error of convertation");
        }
        catch (SumException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Double getSum (Double x, Double eps){
        Double a = x * x * (2048. / 2187.);
        Double res = a;
        int k = 2;
        while (Math.abs(a) > eps)
        {
            a *= (-256.) / (81 * 2 * k * (2*k + 1));
            res += a;
            k++;
        }
        return res;
    }
}