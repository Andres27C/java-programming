public class Calcuradora {
    
    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir entre cero.");
        }
        return a / b;
    }

        public static void main(String[] args) {
        System.out.println("5 + 3 = " + sumar(5, 3));
        System.out.println("5 - 3 = " + restar(5, 3));
        System.out.println("5 * 3 = " + multiplicar(5, 3));
        System.out.println("5 / 3 = " + dividir(5, 3));

    }    

}
