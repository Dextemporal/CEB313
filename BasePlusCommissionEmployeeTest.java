public class BasePlusCommissionEmployeeTest {
    public static void main(String[] args) {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Jane", "Doe", "987-65-4321", 1000, 0.1, 300);
        System.out.println(employee);
        System.out.printf("Earnings: %.2f%n", employee.earnings());
    }
}