import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ush6leksioni3{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {

            File file = new File("data.txt");
            Scanner fileScanner = new Scanner(file);


            int numriNgaFile = 0;
            if (fileScanner.hasNextInt()) {
                numriNgaFile = fileScanner.nextInt();
            } else {
                System.out.println("File nuk përmban numër të vlefshëm.");
                fileScanner.close();
                return;
            }
            fileScanner.close();


            System.out.print("Jepni nje numer per pjesetim: ");
            int numriPerdorues = input.nextInt();
            
            int rezultati = numriNgaFile / numriPerdorues;
            System.out.println("Rezultati i pjesetimit eshte: " + rezultati);

        } catch (FileNotFoundException e) {

            System.out.println("Gabim: File data.txt nuk u gjet!");

        } catch (InputMismatchException e) {

            System.out.println("Gabim: Ju lutem jepni nje numer te vlefshem!");

        } catch (ArithmeticException e) {

            System.out.println("Gabim: Nuk mund te pjestohet me zero!");

        } finally {
            input.close();
        }
    }
}
