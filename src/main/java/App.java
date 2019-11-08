import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Operation operation = new Operation();
        Representation representation = new Representation();
        Scanner scan = new Scanner(System.in);

        ArrayList<ComplexNum> vertices = new ArrayList();

        System.out.println("Program wykonuje podstawowe operacje na wielobokach przy pomocy liczb zespolonych.\n");
        help();

        System.out.println("Pierwszy wierzchołek");
        vertices.add(representation.addNewComplex());
        System.out.println("Drugi wierzchołek");
        vertices.add(representation.addNewComplex());
        System.out.println("Trzeci wierzchołek");

        boolean addNext = true;

        while (addNext) {
            vertices.add(representation.addNewComplex());
            System.out.println("Naciśnij ENTER żeby dodać nowy wierzchołek, lub dowolny przycisk żeby zakończyć");
            String input = scan.nextLine();
            if(!input.equals("")){
                addNext=!addNext;
            }

        }

        System.out.println(operation.getArea(vertices));






    }
        public static void help() {
            System.out.println("tu na razie jest ściernisko ale będzie San Francisco");

        }


}
