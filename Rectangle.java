public class Rectangle {
    private double length = 1.0; // Default value
    private double width = 1.0;  // Default value

    // Getter for length
    public double getLength() {
        return length;
    }

    // Setter for length with validation
    public void setLength(double length) {
        if (length > 0.0 && length < 20.0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length must be greater than 0.0 and less than 20.0.");
        }
    }

    // Getter for width
    public double getWidth() {
        return width;
    }

    // Setter for width with validation
    public void setWidth(double width) {
        if (width > 0.0 && width < 20.0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width must be greater than 0.0 and less than 20.0.");
        }
    }

    // Method to calculate perimeter
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    // Method to calculate area
    public double calculateArea() {
        return length * width;
    }
}
