public class TestApplication {
    public static void main(String[] args) {
        // Create a CommissionEmployee
        CompensationModel commissionModel = new CommissionCompensationModel(10000, 0.06);
        Employee employee1 = new Employee("John", "Doe", "111-11-1111", commissionModel);
        
        // Create a BasePlusCommissionEmployee
        CompensationModel basePlusCommissionModel = new BasePlusCommissionCompensationModel(10000, 0.06, 300);
        Employee employee2 = new Employee("Jane", "Smith", "222-22-2222", basePlusCommissionModel);
        
        // Display earnings
        System.out.println("Initial Earnings:");
        System.out.println(employee1);
        System.out.println(employee2);
        
        // Change CompensationModel for employee1
        employee1.setCompensationModel(new BasePlusCommissionCompensationModel(15000, 0.07, 500));
        
        // Change CompensationModel for employee2
        employee2.setCompensationModel(new CommissionCompensationModel(20000, 0.05));
        
        // Display new earnings
        System.out.println("\nUpdated Earnings:");
        System.out.println(employee1);
        System.out.println(employee2);
    }
}