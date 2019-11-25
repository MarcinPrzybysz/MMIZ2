
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OperationTest {
    Operation op = new Operation();

    @Test
    public void getAreaTest() {
        ArrayList<ComplexNum> vertices = new ArrayList<>();

        vertices.add(new ComplexNum(10, 10));
        vertices.add(new ComplexNum(20, 10));
        vertices.add(new ComplexNum(20, 20));
        vertices.add(new ComplexNum(10, 15));

        assertEquals(75, op.getArea(vertices), 0.00001);
    }

    @Test
    public void getAreaTest2() {
        ArrayList<ComplexNum> vertices = new ArrayList<>();

        vertices.add(new ComplexNum(0, 0));
        vertices.add(new ComplexNum(10, 0));
        vertices.add(new ComplexNum(10, 10));
        vertices.add(new ComplexNum(0, 10));

        assertEquals(100, op.getArea(vertices), 0.00001);
    }


    @Test
    public void getAreaTest3() {
        ArrayList<ComplexNum> vertices = new ArrayList<>();

        vertices.add(new ComplexNum(5, 0));
        vertices.add(new ComplexNum(10, 10));
        vertices.add(new ComplexNum(10, 15));
        vertices.add(new ComplexNum(7.5, 15));
        vertices.add(new ComplexNum(5, 20));
        vertices.add(new ComplexNum(2.5, 15));
        vertices.add(new ComplexNum(0, 15));
        vertices.add(new ComplexNum(0, 10));

        assertEquals(112.5, op.getArea(vertices), 0.00001);
    }


    @Test
    public void getDistanceTest() {
        ComplexNum origin = new ComplexNum(2, 3);
        ComplexNum end = new ComplexNum(8, 20);
        assertEquals(18.0278, op.getDistanceBetween(origin, end), 0.001);
    }


    @Test
    public void getCircuitTest() {
        ArrayList<ComplexNum> vertices = new ArrayList<>();

        vertices.add(new ComplexNum(5, 0));
        vertices.add(new ComplexNum(10, 0));
        vertices.add(new ComplexNum(10, 15));
        vertices.add(new ComplexNum(7.5, 15));
        vertices.add(new ComplexNum(5, 20));
        vertices.add(new ComplexNum(2.5, 15));
        vertices.add(new ComplexNum(0, 15));
        vertices.add(new ComplexNum(0, 10));

        assertEquals(52.36, op.getCircuit(vertices), 0.001);
    }

    @Test
    public void moveByVectorTest() {
        ArrayList<ComplexNum> verticesOriginal = new ArrayList<>();

        verticesOriginal.add(new ComplexNum(5, 0));
        verticesOriginal.add(new ComplexNum(10, 0));
        verticesOriginal.add(new ComplexNum(10, 15));
        verticesOriginal.add(new ComplexNum(7.5, 15));
        verticesOriginal.add(new ComplexNum(5, 20));
        verticesOriginal.add(new ComplexNum(2.5, 15));
        verticesOriginal.add(new ComplexNum(0, 15));
        verticesOriginal.add(new ComplexNum(0, 10));

        ArrayList<ComplexNum> verticesMoved = new ArrayList<>();

        verticesMoved.add(new ComplexNum(25, -7));
        verticesMoved.add(new ComplexNum(30, -7));
        verticesMoved.add(new ComplexNum(30, 8));
        verticesMoved.add(new ComplexNum(27.5, 8));
        verticesMoved.add(new ComplexNum(25, 13));
        verticesMoved.add(new ComplexNum(22.5, 8));
        verticesMoved.add(new ComplexNum(20, 8));
        verticesMoved.add(new ComplexNum(20, 3));

        assertEquals(verticesMoved, op.moveByVector(verticesOriginal, new ComplexNum(20, -7)));
    }

    @Test
    public void rotateByRadiansTest() {
        ArrayList<ComplexNum> verticesOriginal = new ArrayList<>();
        ArrayList<ComplexNum> verticesRotated = new ArrayList<>();

        verticesOriginal.add(new ComplexNum(5, 0));
        verticesOriginal.add(new ComplexNum(10, 0));
        verticesOriginal.add(new ComplexNum(10, 15));
        verticesOriginal.add(new ComplexNum(7.5, 15));

        verticesRotated.add(new ComplexNum(8.0289, 15.4233));
        verticesRotated.add(new ComplexNum(5.161, 19.519));
        verticesRotated.add(new ComplexNum(-7.1263, 10.9154));
        verticesRotated.add(new ComplexNum(-5.6924, 8.8675));

        ComplexNum pivot = new ComplexNum(2.5, 8.5);

        double angle = 125 * Math.PI / 180;

        assertEquals(verticesRotated, op.rotateByRadians(verticesOriginal, pivot, angle));
    }


    @Test
    public void scaleTest() {
        ArrayList<ComplexNum> verticesOriginal = new ArrayList<>();
        ArrayList<ComplexNum> verticesRotated = new ArrayList<>();

        verticesOriginal.add(new ComplexNum(5, 0));
        verticesOriginal.add(new ComplexNum(10, 0));
        verticesOriginal.add(new ComplexNum(10, 15));
        verticesOriginal.add(new ComplexNum(7.5, 15));


        verticesRotated.add(new ComplexNum(6.25, -4.25));
        verticesRotated.add(new ComplexNum(13.75, -4.25));
        verticesRotated.add(new ComplexNum(13.75, 18.25));
        verticesRotated.add(new ComplexNum(10, 18.25));

        ComplexNum pivot = new ComplexNum(2.5, 8.5);

        double scale = 1.5;

        assertEquals(verticesRotated, op.scale(verticesOriginal, pivot, scale));
    }

}