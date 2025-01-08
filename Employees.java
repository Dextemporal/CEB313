public class Employees {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private CompensationModel compensationModel;

    public Employee(String firstName, String lastName, String socialSecurityNumber, CompensationModel compensationModel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.compensationModel = compensationModel;
    }

    public void setCompensationModel(CompensationModel compensationModel) {
        this.compensationModel = compensationModel;
    }

    public double earnings() {
        return compensationModel.earnings();
    }

    @Override
    public String toString() {
        return String.format("%s %s\nSocial Security Number: %s\nEarnings: %.2f",
                firstName, lastName, socialSecurityNumber, earnings());
    }
}