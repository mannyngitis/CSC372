public class Manager extends Employee {
    private String department;

    // Setter
    public void setDepartment(String department) {
        this.department = department;
    }

    // Getter
    public String getDepartment() {
        return department;
    }

    // Overriding the employeeSummary method to include department
    @Override
    public void employeeSummary() {
        super.employeeSummary();
        System.out.println("Department: " + department);
    }
}
