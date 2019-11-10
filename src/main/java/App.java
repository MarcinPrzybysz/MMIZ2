import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

public class App {
    public static void main(String[] args) {
        Operation operation = new Operation();
        Representation representation = new Representation();
        Scanner scan = new Scanner(System.in);

        ArrayList<ComplexNum> vertices = new ArrayList();
        ComplexNum pivot = new ComplexNum(0, 0);

        System.out.println("Program wykonuje podstawowe operacje na wielobokach przy pomocy liczb zespolonych.\n");


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
            if (!input.equals("")) {
                addNext = !addNext;
            }
        }


        help();

        boolean run = true;
        while (run) {

            System.out.print("Podaj nr. operacji: ");
            String operationChose = scan.nextLine();

            switch (operationChose) {
                case "0":

                    break;
                case "1":
                    System.out.println(operation.getArea(vertices));
                    break;
                case "2":
                    System.out.println(operation.getCircuit(vertices));
                    break;
                case "3":

                    System.out.println("Podaj o jaki wektor (z początkiem w punkcie 0,0) chcesz dokonac przesunięcia");
                    ComplexNum vector = representation.addNewComplex();

                    System.out.println(operation.moveByVector(vertices, vector));
                    break;
                case "4":
                    System.out.println("Podaj punkt obrotu");
                    pivot = representation.addNewComplex();

                    System.out.print("Podaj kąt obrotu (w radianach): ");
                    double angle = Double.valueOf(scan.nextLine());


                    System.out.println(operation.rotateByRadians(vertices, pivot, angle));
                    break;
                case "5":
                    System.out.println("Podaj punkt względem którego będzie dokonywane skalowanie");
                    pivot = representation.addNewComplex();

                    System.out.print("Podaj skalę: ");
                    double scale = Double.valueOf(scan.nextLine());
                    System.out.println(operation.scale(vertices, pivot, scale));
                    break;
                case "z":
                    System.out.println("KONIEC");
                    run = false;
                    break;
                case "H":
                    help();
                    break;
            }
        }

    }

    public static void help() {
        System.out.println(
                "Lista funkcji:\n" +
                        "0.Wypisz wszystkie operacje,\n" +
                        "1.Powierzchnia wieloboku,\n" +
                        "2.Obwód wieloboku,\n" +
                        "3.Przesunięcie wieloboku o wektor,\n" +
                        "4.Obrót wieloboku o zadany punkt względem punktu,\n" +
                        "5.Skalowanie wieloboku względem zadanego punktu,\n");

        System.out.println("Wybierz operację która ma zostać wykonana\n(wpisanie \"0\" wyświetli wyniki każdej operacji, \"H\" wyświetli spis funkcji).\n");

    }

    public static void printVertices(ArrayList<ComplexNum> vertices) {

        for (int i = 0; i < vertices.size(); i++) {
            System.out.println("[ " + vertices.get(i).getReal() + " , " + vertices.get(i).getImg() + " ]");
        }

    }


}
