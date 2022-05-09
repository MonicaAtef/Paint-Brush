package paintpkg;


import paintpkg.Shape;
import java.awt.Color;
import java.awt.Graphics;

class Rectangle extends Shape {

    public Rectangle() {

    }

    public Rectangle(int x1, int y1, int x2, int y2, Color CurrentColor, boolean dottedChecked, boolean filledChecked,char whichShape) {
        super(x1, y1, x2, y2,CurrentColor, dottedChecked, filledChecked,whichShape);
    }
}
