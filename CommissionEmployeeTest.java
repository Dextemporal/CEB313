public class CommissionEmployeeTest {
    public static void main(String[] args) {
        CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 1000, 0.1);
        System.out.println(employee);
        System.out.printf("Earnings: %.2f%n", employee.earnings());
    }
}

