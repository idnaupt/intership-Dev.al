public class ush4leksioni3 {
    public class Pjestimi {

        public static void main(String[] args) {
            pjestimi(10, 2);
            pjestimi(5, 0);
        }

        public static void pjestimi(int numri, int emeruesi) {
            try {
                int rezultati = numri / emeruesi;
                System.out.println("Rezultati: " + rezultati);
            } catch (ArithmeticException e) {
                System.out.println("Gabim: Nje emerues nuk mund te jete 0!");
            }
        }
    }

}
