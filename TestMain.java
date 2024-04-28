public class TestMain {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setFirstName("John");
        manager.setLastName("Doe");
        manager.setEmployeeID(12345);
        manager.setSalary(75000);
        manager.setDepartment("IT");

        manager.employeeSummary();
    }
}
