public class CommissionEmployee extends Employee {
    private double grossSales; // gross weekly sales
    private double commissionRate; // commission percentage

    // Constructor
    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                              double grossSales, double commissionRate) {
        super(firstName, lastName, socialSecurityNumber); // Call to Employee constructor
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    // Getters
    public double getGrossSales() {
        return grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    // Calculate earnings
    public double earnings() {
        return getCommissionRate() * getGrossSales();
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%s%nGross Sales: %.2f%nCommission Rate: %.2f",
                super.toString(), getGrossSales(), getCommissionRate());
    }
}