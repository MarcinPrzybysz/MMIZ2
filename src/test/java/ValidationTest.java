import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ValidationTest {
    Validation validate = new Validation();

    @Test
    public void checkIfIntersectTest_intersects() {
        ArrayList<ComplexNum> vertices = new ArrayList<>();

        ComplexNum p1 = new ComplexNum(0, 0);
        ComplexNum p2 = new ComplexNum(20, 20);
        ComplexNum p3 = new ComplexNum(0, 20);
        ComplexNum p4 = new ComplexNum(20, 0);

        assertEquals(true, validate.checkIfIntersects(p1,p2,p3,p4));
    }

    @Test
    public void checkIfIntersectTest_parallel() {
        ArrayList<ComplexNum> vertices = new ArrayList<>();

        ComplexNum p1 = new ComplexNum(0, 0);
        ComplexNum p2 = new ComplexNum(0, 20);
        ComplexNum p3 = new ComplexNum(20, 0);
        ComplexNum p4 = new ComplexNum(20, 20);

        assertEquals(false, validate.checkIfIntersects(p1,p2,p3,p4));
    }


    @Test
    public void geometryCheckTest() {
        ArrayList<ComplexNum> vertices = new ArrayList<>();

        vertices.add(new ComplexNum(5, 0));
        vertices.add(new ComplexNum(10, 10));
        vertices.add(new ComplexNum(10, 15));
        vertices.add(new ComplexNum(7.5, 15));
        vertices.add(new ComplexNum(5, 20));
        vertices.add(new ComplexNum(2.5, 15));
        vertices.add(new ComplexNum(0, 15));
        vertices.add(new ComplexNum(0, 10));

        assertEquals(true, validate.correctGeometry(vertices));
    }


    @Test
    public void geometryCheckTest_intersects() {
        ArrayList<ComplexNum> vertices = new ArrayList<>();

        vertices.add(new ComplexNum(0, 0));
        vertices.add(new ComplexNum(20, 20));
        vertices.add(new ComplexNum(20, 0));
        vertices.add(new ComplexNum(0, 20));


        assertEquals(false, validate.correctGeometry(vertices));
    }


}
