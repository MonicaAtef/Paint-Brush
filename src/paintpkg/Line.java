package paintpkg;

import java.awt.Color;
  class Line extends Shape {

        public Line() {

        }

        public Line(int x1, int y1, int x2, int y2,Color CurrentColor, boolean dottedChecked,char whichShape) {
            super(x1, y1, x2, y2, CurrentColor,dottedChecked,whichShape);
        }
    }