public class Shapee {
    public static void main(String[] args) {
        class Shape {
            private final double area;
            public Shape(double area) {
                this.area = area;
            }
            public static double sumAreas(Shape[] shapes) {
                double sum = 0;
                for (Shape s : shapes) {
                    sum += s.area;
                }
                return sum;
            }

        }
        Shape circle = new Shape(Math.PI * 5 * 5); // Assuming a circle with radius 5
        Shape square = new Shape(5 * 5); // Assuming a square with side length 5

        Shape[] shapes = {circle, square};

        double totalArea = Shape.sumAreas(shapes);
        System.out.println("Total Area: " + totalArea);
    }
}
