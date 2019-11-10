import java.util.ArrayList;

public class Operation {


    /**
     * Oblicza powierzchnie wieloboku, przyjmując za parametr listę wspólrzdnych wierzchołków
     *
     * @param vertices
     * @return
     */
    public double getArea(ArrayList<ComplexNum> vertices) {
        double area = 0;
        int max = vertices.size() - 1;

        for (int i = 1; i < max; i++) {
            area = area + vertices.get(i).getImg() * (vertices.get(i - 1).getReal() - vertices.get(i + 1).getReal());
        }
        area = area + vertices.get(max).getImg() * (vertices.get(max - 1).getReal() - vertices.get(0).getReal());
        area = area + vertices.get(0).getImg() * (vertices.get(max).getReal() - vertices.get(1).getReal());

        return Math.abs(area) / 2;
    }

    /**
     * Oblicza obwód wieloboku, przyjmując za parametr listę wspólrzdnych wierzchołków
     *
     * @param vertices
     * @return
     */
    public double getCircuit(ArrayList<ComplexNum> vertices) {
        double circuit = 0;
        int max = vertices.size() - 1;

        for (int i = 0; i < max; i++) {
            circuit = circuit + getDistanceBetween(vertices.get(i), vertices.get(i + 1));
        }
        circuit = circuit + getDistanceBetween(vertices.get(max), vertices.get(0));
        return circuit;
    }

    /**
     * Oblicza odległość pomiędzy dwoma zadanymi punktami
     *
     * @param origin
     * @param end
     * @return
     */
    public double getDistanceBetween(ComplexNum origin, ComplexNum end) {
        double distance = 0;
        distance = Math.sqrt(
                (origin.getImg() - end.getImg()) * (origin.getImg() - end.getImg()) +
                        (origin.getReal() - end.getReal()) * (origin.getReal() - end.getReal())
        );
        return distance;
    }

    /**
     * Pzesuwa zbiór wierzchołków o wektor o początku w 0,0 i zadanym końcu.
     *
     * @param vertices
     * @param vector
     * @return
     */
    public ArrayList<ComplexNum> moveByVector(ArrayList<ComplexNum> vertices, ComplexNum vector) {
        int max = vertices.size();
        for (int i = 0; i < max; i++) {
            vertices.set(i, new ComplexNum(
                    vertices.get(i).getReal() + vector.getReal(),
                    vertices.get(i).getImg() + vector.getImg()
            ));
        }
        return vertices;
    }


    /**
     * Obraca zbiór punktów względem zadanego punktu o kąt podany w radianach.
     *
     * @param vertices
     * @param angle
     * @return
     */

    public ArrayList<ComplexNum> rotateByRadians(ArrayList<ComplexNum> vertices, ComplexNum pivot, double angle) {
        double pivotReal = pivot.getReal();
        double pivotImg = pivot.getImg();

        int max = vertices.size();

        for (int i = 0; i < max; i++) {
            double pointReal = vertices.get(i).getReal();
            double pointImg = vertices.get(i).getImg();

            vertices.set(i, new ComplexNum(
                    pivotReal + (pointReal - pivotReal) * Math.cos(angle) - (pointImg - pivotImg) * Math.sin(angle),
                    pivotImg + (pointReal - pivotReal) * Math.sin(angle) + (pointImg - pivotImg) * Math.cos(angle)));
        }
        return vertices;
    }


    public ArrayList<ComplexNum> scale(ArrayList<ComplexNum> vertices, ComplexNum pivot, double scale) {
        double pivotReal = pivot.getReal();
        double pivotImg = pivot.getImg();

        int max = vertices.size();

        for (int i = 0; i < max; i++) {
            double pointReal = vertices.get(i).getReal();
            double pointImg = vertices.get(i).getImg();

            vertices.set(i, new ComplexNum(
                    (scale * (pointReal - pivotReal)) + pivotReal,
                    (scale * (pointImg - pivotImg)) + pivotImg));
        }
        return vertices;
    }


}
