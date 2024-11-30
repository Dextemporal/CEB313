public class RectangleTest {
    public static void main(String[] args) {
        // Create a rectangle with default values
        Rectangle rect = new Rectangle();
        System.out.println("Default Rectangle:");
        System.out.println("Length: " + rect.getLength());
        System.out.println("Width: " + rect.getWidth());
        System.out.println("Perimeter: " + rect.calculatePerimeter());
        System.out.println("Area: " + rect.calculateArea());

        // Set new values for length and width
        try {
            rect.setLength(10.5);
            rect.setWidth(5.5);
            System.out.println("\nUpdated Rectangle:");
            System.out.println("Length: " + rect.getLength());
            System.out.println("Width: " + rect.getWidth());
            System.out.println("Perimeter: " + rect.calculatePerimeter());
            System.out.println("Area: " + rect.calculateArea());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
