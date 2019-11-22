import java.util.Scanner;
import java.util.regex.Pattern;

public class Representation {
    final static String DOUBLE_PATTERN = "[-]?[0-9]+(\\.)?[0-9]*";

    public ComplexNum addNewComplex() {
        String real="";
        String img="";
        Scanner scan = new Scanner(System.in);

        boolean invalidInput=true;

        while(invalidInput) {
            System.out.print("Podaj część rzeczywistą: ");
            real = scan.nextLine();
            if(Pattern.matches(DOUBLE_PATTERN, real)) {
                invalidInput = false;
            }else{
                System.out.println("Błędna wartość, to nie jest liczba");
            }
        }

        invalidInput=true;

        while(invalidInput) {
            System.out.print("Podaj część urojoną: ");
            img = scan.nextLine();
            if(Pattern.matches(DOUBLE_PATTERN, img)) {
                invalidInput = false;
            }else{
                System.out.println("Błędna wartość, to nie jest liczba");
            }
        }


        ComplexNum complex = new ComplexNum(Double.valueOf(real), Double.valueOf(img));
        return complex;
    }




}
