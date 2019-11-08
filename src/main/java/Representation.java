import java.util.Scanner;

public class Representation {

    public ComplexNum addNewComplex() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj część rzeczywistą: ");
        String real = scan.nextLine();

        System.out.print("Podaj część urojoną: ");
        String img = scan.nextLine();

        ComplexNum complex = new ComplexNum(Double.valueOf(real), Double.valueOf(img));
        return complex;
    }


}
