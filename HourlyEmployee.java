public class HourlyEmployee extends Employee {
    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, String ssn, double wage, double hours) {
        super(firstName, lastName, ssn);
        setWage(wage);
        setHours(hours);
    }

    public void setWage(double wage) {
        if (wage < 0) {
            throw new IllegalArgumentException("Wage cannot be negative.");
        }
        this.wage = wage;
    }

    public double getWage() {
        return wage;
    }

    public void setHours(double hours) {
        if (hours < 0 || hours > 168) {
            throw new IllegalArgumentException("Hours must be between 0 and 168.");
        }
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

    public double earnings() {
        if (hours <= 40) {
            return hours * wage;
        } else {
            double overtimeHours = hours - 40;
            return (40 * wage) + (overtimeHours * wage * 1.5);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Wage: " + wage + ", Hours: " + hours + ", Earnings: " + String.format("%.2f", earnings());
    }
}
