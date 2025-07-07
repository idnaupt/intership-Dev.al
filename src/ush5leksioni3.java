public class ush5leksioni3 {
    public class Validator {

        public static void validateNumber(int number) {
            if (number < 20) {
                throw new IllegalArgumentException("Numri duhet të jetë të paktën 20!");
            }
            System.out.println("Numri është i vlefshëm: " + number);
        }

        public static void main(String[] args) {
            validateNumber(25); // Nuk hedh gabim
            validateNumber(10); // Hedh IllegalArgumentException
        }
    }

}
