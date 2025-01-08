
class QuadTest {
    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 0);
        Point p3 = new Point(2, 3);
        Point p4 = new Point(0, 3);

        Trapezoid trapezoid = new Trapezoid(p1, p2, p3, p4);
        System.out.println("Trapezoid area: " + trapezoid.area());

        Parallelogram parallelogram = new Parallelogram(p1, p2, p3, p4);
        System.out.println("Parallelogram area: " + parallelogram.area());

        Rectangle rectangle = new Rectangle(p1, p2, p3, p4);
        System.out.println("Rectangle area: " + rectangle.area());

        Square square = new Square(p1, p2, new Point(2, 2), new Point(0, 2));
        System.out.println("Square area: " + square.area());
    }
}
