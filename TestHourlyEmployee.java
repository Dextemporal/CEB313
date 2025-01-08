
public class TestHourlyEmployee {
    public static void main(String[] args) {
        // Create an HourlyEmployee object
        try {
            HourlyEmployee employee = new HourlyEmployee("John", "Doe", "123-45-6789", 20.0, 45);
            System.out.println(employee);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test with different hours
        try {
            HourlyEmployee employee = new HourlyEmployee("Jane", "Smith", "987-65-4321", 15.0, 40);
            System.out.println(employee);
            employee.setHours(50); // This should work
            System.out.println(employee);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            HourlyEmployee employee = new HourlyEmployee("Alice", "Johnson", "111-22-3333", 25.0, 30);
            System.out.println(employee);
            employee.setWage(-15);  // This should raise an error
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            HourlyEmployee employee = new HourlyEmployee("Bob", "Brown", "444-55-6666", 30.0, 170); // This should raise an error
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}