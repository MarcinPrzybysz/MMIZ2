import java.util.ArrayList;

public class Validation {

    boolean correctGeometry(ArrayList<ComplexNum> vertices) {
        //todo: sprawdzić czy jest przecięcie
        //todo: sprawdzić czy nie powtarzają się punkty
        boolean intersects=false;

        int max = vertices.size() - 1;

        //prawdopodobnie wystarczy sprawdzić tylko do połowy figury bo późnie się powtarza
        for (int i = 0; i < max; i++) {
            for(int j = i+1; j < max; j++) {
                intersects=checkIfIntersects(vertices.get(i), vertices.get(i + 1), vertices.get(j), vertices.get(j + 1));
                System.out.println(intersects);
                if(intersects){
                    System.out.println("przecinają się punkty: "+ vertices.get(i).toString()+" -  "+ vertices.get(i+1).toString()+"\n" + vertices.get(j).toString()+" - "+ vertices.get(j+1).toString() );
                    return !intersects;
                }
            }

        }
        System.out.println(intersects);
        return !intersects;
    }


    boolean checkIfIntersects(ComplexNum pointA1, ComplexNum pointA2, ComplexNum pointB1, ComplexNum pointB2) {

        double vectorP1 = vectorProduct(pointB1, pointB2, pointA1);
        double vectorP2 = vectorProduct(pointB1, pointB2, pointA2);
        double vectorP3 = vectorProduct(pointA1, pointA2, pointB1);
        double vectorP4 = vectorProduct(pointA1, pointA2, pointB2);

        if ((((vectorP1 > 0 && vectorP2 < 0) || (vectorP1 < 0 && vectorP2 > 0))) && (((vectorP3 > 0 && vectorP4 < 0) || (vectorP3 < 0 && vectorP4 > 0)))) {
            return true;
       // }else if(vectorP1==0){
       //     return true;
       // }else if(vectorP2==0) {
       //     return true;
       // }else if(vectorP3==0) {
       //     return true;
       // }else if(vectorP4==0) {
       //     return true;
        }else{
            return false;
        }


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
