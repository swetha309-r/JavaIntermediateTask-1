import java.util.Scanner;

public class Main {
    private static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Employee Management Application");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    viewEmployee(scanner);
                    break;
                case 3:
                    updateEmployee(scanner);
                    break;
                case 4:
                    deleteEmployee(scanner);
                    break;
                case 5:
                    viewAllEmployees();
                    break;
                case 6:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee department: ");
        String department = scanner.nextLine();
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();

        Employee employee = new Employee(id, name, department, salary, age);
        employeeService.addEmployee(employee);
        System.out.println("Employee added successfully.");
    }

    private static void viewEmployee(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void updateEmployee(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new employee department: ");
        String department = scanner.nextLine();
        System.out.print("Enter new employee salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter new employee age: ");
        int age = scanner.nextInt();

        Employee employee = new Employee(id, name, department, salary, age);
        employeeService.updateEmployee(employee);
        System.out.println("Employee updated successfully.");
    }

    private static void deleteEmployee(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        employeeService.deleteEmployee(id);
        System.out.println("Employee deleted successfully.");
    }

    private static void viewAllEmployees() {
        for (Employee employee : employeeService.getAllEmployees()) {
            System.out.println(employee);
        }
    }
}
