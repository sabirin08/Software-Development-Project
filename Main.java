import java.util.Scanner; 

  

public class Main { 

    public static void main(String[] args) { 

        Scanner scanner = new Scanner(System.in); 

        DatabaseHandler dbHandler = new DatabaseHandler(); 



        while (true) { 

            System.out.println("\n--- Employee Management System ---"); 

            System.out.println("1. Add Employee"); 

            System.out.println("2. Update Employee"); 

            System.out.println("3. Search Employee"); 

            System.out.println("4. Update Salary by Range"); 

            System.out.println("5. Show All Employees"); 

            System.out.println("6. Exit"); 

            System.out.print("Choose an option: "); 

            int choice = scanner.nextInt(); 

            scanner.nextLine(); 

  

            switch (choice) { 

                case 1: 

                    System.out.print("Enter ID: "); 

                    int id = scanner.nextInt(); 

                    scanner.nextLine(); 

                    System.out.print("Enter Name: "); 

                    String name = scanner.nextLine(); 

                    System.out.print("Enter SSN (no dashes): "); 

                    String ssn = scanner.nextLine(); 

                    System.out.print("Enter Job Title: "); 

                    String job = scanner.nextLine(); 

                    System.out.print("Enter Division: "); 

                    String division = scanner.nextLine(); 

                    System.out.print("Enter Salary: "); 

                    double salary = scanner.nextDouble(); 

                    scanner.nextLine(); 

                    System.out.print("Enter Pay Statement: "); 

                    String pay = scanner.nextLine(); 

                    Employee emp = new Employee(id, name, ssn, job, division, salary, pay); 

                    dbHandler.insertEmployee(emp); 

                    break; 

                case 2: 

                    System.out.print("Enter Employee ID to Update: "); 

                    int updateId = scanner.nextInt(); 

                    scanner.nextLine(); 

                    System.out.print("Enter New Name: "); 

                    String newName = scanner.nextLine(); 

                    System.out.print("Enter New SSN: "); 

                    String newSsn = scanner.nextLine(); 

                    System.out.print("Enter New Job Title: "); 

                    String newJob = scanner.nextLine(); 

                    System.out.print("Enter New Division: "); 

                    String newDivision = scanner.nextLine(); 

                    System.out.print("Enter New Salary: "); 

                    double newSalary = scanner.nextDouble(); 

                    scanner.nextLine(); 

                    System.out.print("Enter New Pay Statement: "); 

                    String newPay = scanner.nextLine(); 

                    Employee updatedEmp = new Employee(updateId, newName, newSsn, newJob, newDivision, newSalary, newPay); 

                    dbHandler.updateEmployee(updatedEmp); 

                    break; 

                case 3: 

                    System.out.print("Enter Name, SSN, or ID to search: "); 

                    String input = scanner.nextLine(); 

                    dbHandler.searchEmployee(input); 

                    break; 

                case 4: 

                    System.out.print("Enter percentage increase: "); 

                    double percent = scanner.nextDouble(); 

                    System.out.print("Enter min salary: "); 

                    double min = scanner.nextDouble(); 

                    System.out.print("Enter max salary: "); 

                    double max = scanner.nextDouble(); 

                    dbHandler.updateSalaryByRange(percent, min, max); 

                    break; 

                case 5: 

                    dbHandler.showAllEmployees(); 

                    break; 

                case 6: 

                    System.out.println("Exiting..."); 

                    scanner.close(); 

                    return; 

                default: 

                    System.out.println("Invalid choice."); 

            } 

        } 

    } 

} 

// import java.util.*;


// public class Main1 {
//     static Scanner scanner = new Scanner(System.in);
//     static EmployeeRepository repo = new EmployeeRepository();

    
//     public static void main(String[] args) {
//         while (true) {
//             System.out.println("1. Add Employee\n2. Search\n3. Update\n4. Adjust Salary\n5. Generate Report\n0. Exit");
//             int choice = scanner.nextInt();
//             switch (choice) {
//                 case 1 -> addEmployeeUI();
//                 case 2 -> searchUI();
//                 case 3 -> updateUI();
//                 case 4 -> adjustSalaryUI();
//                 case 5 -> new ReportGeneratorImpl(repo5).generate();
//                 case 0 -> System.exit(0);
//             }
//         }
//     }

//     private static void addEmployeeUI() {
//         System.out.print("Enter Name: ");
//         String name = scanner.next();
//         System.out.print("Enter SSN: ");
//         String ssn = scanner.next();
//         System.out.print("Enter Emp ID: ");
//         String empId = scanner.next();
//         System.out.print("Enter Division: ");
//         String division = scanner.next();
//         System.out.print("Enter Salary: ");
//         double salary = scanner.nextDouble();
    
//         FullTimeEmployee emp = new FullTimeEmployee(0, division, salary, name, ssn, empId);
//         repo.addEmployee(emp);
//         DBService.insertEmployee(emp); // insert into DB
//         System.out.println("Employee Added.");
//     }

//     private static void searchUI() {
//         System.out.print("Enter name to search: ");
//         String name = scanner.next();
//         var results = repo.searchByName(name);
//         for (Employee1 e : results) {
//             Person p = (Person) e; 
//             System.out.println(p.getName() + " - " + p.getSsn());
//         }
//     }

//     private static void updateUI() {
//         System.out.print("Enter SSN to update: ");
//         String ssn = scanner.next();
//         Employee1 e = repo.searchBySSN(ssn);
//         if (e != null) {
//             System.out.print("New Division: ");
//             e.division = scanner.next();
//             System.out.print("New Salary: ");
//             e.salary = scanner.nextDouble();
//             repo.updateEmployee(e);
//         }
//     }

//     private static void adjustSalaryUI() {
//         System.out.print("Enter min salary: ");
//         double min = scanner.nextDouble();
//         System.out.print("Enter max salary: ");
//         double max = scanner.nextDouble();
//         System.out.print("Enter % increase: ");
//         double percent = scanner.nextDouble();
//         repo.adjustSalary(min, max, percent);
//     }
// }
