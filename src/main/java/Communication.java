import java.util.ArrayList;
import java.util.Scanner;

public class Communication {
    Operation operation = new Operation();
    Representation representation = new Representation();
    Scanner scan = new Scanner(System.in);

    ArrayList<ComplexNum> vertices = new ArrayList();
    ComplexNum pivot = new ComplexNum(0, 0);

    public Communication() {


        System.out.println("Program wykonuje podstawowe operacje na wielobokach przy pomocy liczb zespolonych.\n");

        initialPolygonInput();

        help();

        boolean run = true;
        while (run) {

            System.out.print("Podaj nr. operacji (pomoc \"H\"): ");
            String operationChose = scan.nextLine();

            switch (operationChose) {
                case "0":
                    getArea();
                    getCircuit();
                    moveByVector();
                    rotateBy();
                    scaleBy();
                    break;
                case "1":
                    getArea();
                    break;
                case "2":
                    getCircuit();
                    break;
                case "3":
                    moveByVector();
                    break;
                case "4":
                    rotateBy();
                    break;
                case "5":
                    scaleBy();
                    break;
                case "z":
                case "Z":
                    System.out.println("KONIEC");
                    run = false;
                    break;
                case "n":
                case "N":
                    vertices.clear();
                    initialPolygonInput();
                    break;
                default:
                    help();
                    break;
            }
        }


    }

    public void help() {
        System.out.println(
                "Lista funkcji:\n" +
                        "0.Wypisz wszystkie operacje,\n" +
                        "1.Powierzchnia wieloboku,\n" +
                        "2.Obwód wieloboku,\n" +
                        "3.Przesunięcie wieloboku o wektor,\n" +
                        "4.Obrót wieloboku o zadany punkt względem punktu,\n" +
                        "5.Skalowanie wieloboku względem zadanego punktu,\n\n");


        System.out.println("Wybierz operację która ma zostać wykonana\n" +
                "\"N\" Wpisz nowy poligon \n" +
                "\"H\" wyświetli spis funkcji).\n");

    }

    private void printVertices(ArrayList<ComplexNum> vertices) {
        for (ComplexNum vertex : vertices) {
            System.out.println("[" + vertex.getReal() + " , " + vertex.getImg() + "]");
        }
        System.out.println();
    }


    private void getArea() {
        System.out.println("POWIERZCHNIA WIELOBOKU:");
        System.out.println(operation.getArea(vertices) + "\n");
    }

    private void getCircuit() {
        System.out.println("OBWÓD WIELOBOKU:");
        System.out.println(operation.getCircuit(vertices) + "\n");
    }

    private void moveByVector() {
        System.out.println("PRZESUNIĘCIE WIELOBOKU O WEKTOR");
        System.out.println("Podaj o jaki wektor (z początkiem w punkcie 0,0) chcesz dokonac przesunięcia");
        ComplexNum vector = representation.addNewComplex();

        printVertices(operation.moveByVector(vertices, vector));
    }

    private void rotateBy() {
        System.out.println("OBRÓCENIE WIELOBOKU O KĄT:");
        System.out.println("Podaj punkt obrotu");
        pivot = representation.addNewComplex();

        System.out.print("Podaj kąt obrotu (w radianach): ");
        double angle = Double.valueOf(scan.nextLine());

        printVertices(operation.rotateByRadians(vertices, pivot, angle));
    }

    private void scaleBy() {
        System.out.println("SKALOWANIE WIELOBOKU:");
        System.out.println("Podaj punkt względem którego będzie dokonywane skalowanie");
        pivot = representation.addNewComplex();

        System.out.print("Podaj skale:");
        double scale = Double.valueOf(scan.nextLine());
        printVertices(operation.scale(vertices, pivot, scale));
    }

    private void initialPolygonInput() {
        System.out.println("Podaj kolejne wierzchołki wieloboku.\n");


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

    }


}
