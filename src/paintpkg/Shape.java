package paintpkg;


import java.awt.Color;

    class Shape {

        protected int dim;
        protected int x1; 
        protected int y1;
        protected int x2;
        protected int y2;
        private char whichShape;
        protected boolean dottedChecked;
        protected boolean filledChecked;
        protected Color color;

        public Shape() {

        }

        public Shape(int x1, int y1, int x2, int y2,Color currentColor , boolean dottedChecked, boolean filledChecked,char whichShape) {

            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.whichShape = whichShape;
            this.dottedChecked = dottedChecked;
            this.filledChecked = filledChecked;
            this.color = currentColor;

            if (whichShape != 'E') {
                 this.color = currentColor;
               
            } else {
                this.color = Color.WHITE;
            }
        }

        public Shape(int x1, int y1, int x2, int y2, Color currentColor,boolean dottedChecked,char whichShape) {

            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.whichShape = whichShape;
            this.dottedChecked = dottedChecked;
            this.color = currentColor;
        }
        void setX1(int x1) {

            this.x1 = x1;
        }

        void setY1(int y1) {
            this.y1 = y1;
        }

        public void setX2(int x2) {
            this.x2 = x2;
        }

        public void setY2(int y2) {
            this.y2 = y2;
        }
        int getX1() {
            return x1;
        }

        int getY1() {
            return y1;
        }

        int getX2() {
            return x2;
        }

        int getY2() {
            return y2;
        }

        public Color getColor() {
            return color;
        }

        public char getShapeName() {
            return whichShape;
        }
          boolean isFilled() {
            return filledChecked;
        }

        void setShape(char shape) {
            whichShape = shape;
        }

        boolean isDotted() {
            return this.dottedChecked;
        }

        char getShape() {
            return whichShape;
        }
    }

  

