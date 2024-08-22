import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Employee implements Comparable<Employee>, Cloneable {
    private int employeeId;
    private String name;
    private double salary;

    public Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.employeeId, other.employeeId); // Default sorting by employeeId
    }

    @Override
    public Employee clone() {
        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Employee [ID=" + employeeId + ", Name=" + name + ", Salary=" + salary + "]";
    }
}

class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}

class EmployeeList implements Iterable<Employee> {
    private List<Employee> employees;

    public EmployeeList() {
        employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public Iterator<Employee> iterator() {
        return employees.iterator();
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();

        employeeList.add(new Employee(102, "Alice", 75000));
        employeeList.add(new Employee(101, "Bob", 80000));
        employeeList.add(new Employee(103, "Charlie", 70000));

        // Sort using Comparable (by employeeId)
        Collections.sort(employeeList.getEmployees());
        System.out.println("Sorted by Employee ID (Comparable):");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }

        // Sort using Comparator (by name)
        Collections.sort(employeeList.getEmployees(), new EmployeeNameComparator());
        System.out.println("\nSorted by Name (Comparator):");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }

        // Sort using Comparator (by salary)
        Collections.sort(employeeList.getEmployees(), new EmployeeSalaryComparator());
        System.out.println("\nSorted by Salary (Comparator):");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }

        // Clone an employee
        Employee clonedEmployee = employeeList.getEmployees().get(0).clone();
        System.out.println("\nCloned Employee: " + clonedEmployee);
    }
}
