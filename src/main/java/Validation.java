import java.util.ArrayList;

public class Validation {

    boolean correctGeometry(ArrayList<ComplexNum> vertices) {
        //return !(intersectingSides(vertices) && duplicatedVertices(vertices));
        if(duplicatedVertices(vertices)){
            System.out.println("powtórzone punkty");
            return false;
        }else if(intersectingSides(vertices)){
            System.out.println("przecinające sie boki");
            return false;
        }else{

            return true;
        }

    }

    boolean intersectingSides(ArrayList<ComplexNum> vertices) {
        //todo: sprawdzić czy nie powtarzają się punkty
        boolean intersects = false;

        int max = vertices.size() - 1;

        for (int i = 0; i < max; i++) {
            for (int j = i + 1; j < max; j++) {
                intersects = checkIfIntersects(vertices.get(i), vertices.get(i + 1), vertices.get(j), vertices.get(j + 1));
                if (intersects) {
                    return intersects;
                }
            }
        }
        //System.out.println(intersects);
        return intersects;
    }

    boolean duplicatedVertices(ArrayList<ComplexNum> vertices) {
        int max = vertices.size() - 1;
        for (int i = 0; i < max; i++) {
            for (int j = i + 1; j < max; j++) {
                if (vertices.get(i).equals(vertices.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }


    boolean checkIfIntersects(ComplexNum pointA1, ComplexNum pointA2, ComplexNum pointB1, ComplexNum pointB2) {

        double vectorP1 = vectorProduct(pointB1, pointB2, pointA1);
        double vectorP2 = vectorProduct(pointB1, pointB2, pointA2);
        double vectorP3 = vectorProduct(pointA1, pointA2, pointB1);
        double vectorP4 = vectorProduct(pointA1, pointA2, pointB2);

        return (((vectorP1 > 0 && vectorP2 < 0) || (vectorP1 < 0 && vectorP2 > 0))) && (((vectorP3 > 0 && vectorP4 < 0) || (vectorP3 < 0 && vectorP4 > 0)));


    }

    /**
     * Oblicza iloczyn wektorowy przyjmując za parametr trzy punkty
     *
     * @return
     */
    double vectorProduct(ComplexNum point1, ComplexNum point2, ComplexNum point3) {

        double x1 = point3.getReal() - point1.getReal();
        double y1 = point3.getImg() - point1.getImg();
        double x2 = point2.getReal() - point1.getReal();
        double y2 = point2.getImg() - point1.getImg();

        return ((x1 * y2) - (x2 * y1));
    }

}
