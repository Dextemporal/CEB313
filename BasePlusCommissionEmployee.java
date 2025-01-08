public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary; // base salary per week

    // Constructor
    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                      double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate); // Call to CommissionEmployee constructor
        this.baseSalary = baseSalary;
    }

    // Getter
    public double getBaseSalary() {
        return baseSalary;
    }

    // Calculate earnings
    @Override
    public double earnings() {
        return getBaseSalary() + super.earnings();
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%s%nBase Salary: %.2f", super.toString(), getBaseSalary());
    }
}
