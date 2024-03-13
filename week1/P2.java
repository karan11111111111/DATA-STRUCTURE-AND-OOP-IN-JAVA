// Create a program to manage employee information using Object-Oriented Programming (OOP) concepts. Design a class Employee with the following attributes: empId (Employee ID), name, designation, basicSalary, hraPercentage, and daPercentage. Implement methods within the class to calculate the gross salary based on the provided information and to display the employee details.

// Utilize an array of Employee objects to store the information of 'n' employees. Prompt the user to input the number of employees ('n') and gather details for each employee. Display the information of each employee along with their gross salary

import java.util.Scanner;

class Employee {
    private int empId;
    private String name;
    private String designation;
    private double basicSalary;
    private double hraPercentage;
    private double daPercentage;

    public Employee(int empId, String name, String designation, double basicSalary, double hraPercentage,
            double daPercentage) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.basicSalary = basicSalary;
        this.hraPercentage = hraPercentage;
        this.daPercentage = daPercentage;
    }

    public double calculateGrossSalary() {
        double hra = basicSalary * (hraPercentage / 100);
        double da = basicSalary * (daPercentage / 100);
        return basicSalary + hra + da;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("HRA Percentage: " + hraPercentage);
        System.out.println("DA Percentage: " + daPercentage);
        System.out.println("Gross Salary: " + calculateGrossSalary());
        System.out.println();
    }
}

public class P2 {

public static void main(String[] args){
 
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the of employees");

    int n = sc.nextInt();

    Employee[] employees = new Employee[n];

    for(int i =0; i<n; i++){
        System.out.println("Enter information for Employess "+ (i+1)+ ": ");
        System.out.println("Emp-id: ");
        int empId = sc.nextInt();
        System.out.println("Name: ");
        String name = sc.next();
        System.out.println("Designation: ");
        String designation = sc.next();
        System.out.println("Basic Salary: ");
        double basicSalary = sc.nextDouble();
        System.out.println("HRA Percentage: ");
        double hraPercentage = sc.nextDouble();
        System.out.println("DA Percentage: ");
        double daPercentage = sc.nextDouble();

        employees[i] = new Employee(empId, name, designation, basicSalary, hraPercentage, daPercentage);
    }

    System.out.println("Employee Informsation with Gross Salary: ");
    for(Employee employee :employees){
        employee.displayEmployeeInfo();
    }
    }

}
