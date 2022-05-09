package paintpkg;


import java.awt.Color;

 class Circle extends Shape {

        public Circle() {

        }

        public Circle(int x1, int y1, int x2, int y2, Color CurrentColor, boolean dottedChecked, boolean filledChecked, char whichShape) {
            super(x1, y1, x2, y2,CurrentColor, dottedChecked, filledChecked,whichShape);
        }
    }
