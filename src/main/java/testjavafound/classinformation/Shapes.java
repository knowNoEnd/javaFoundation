package main.java.testjavafound.classinformation;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class Shapes {

//    final static Object dd = this;

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle());
        for (Shape shape : shapeList)
            shape.draw();
        Shapes shapes = new Shapes();
        System.out.println(shapes.getClass().toString());
    }

}

abstract class Shape {
    void draw() {
        System.out.println(this +".draw()");
    }
    abstract public String toString();
}

class Circle extends Shape {
    public String toString() {
        return "Circle";
    }
}
class Square extends Shape {
    public String toString() {
        return "Square";
    }
}
class Triangle extends Shape {
    public String toString() {
        return "Triangle";
    }
}

