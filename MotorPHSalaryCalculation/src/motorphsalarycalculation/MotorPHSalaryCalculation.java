
package motorphsalarycalculation;

import java.util.Scanner;//imports scanner for user input
import java.text.DecimalFormat;//imports Decimal Format


public class MotorPHSalaryCalculation {

    public static final DecimalFormat decfor = new DecimalFormat("0.00");//Formats Decimal places to be only 2 places
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);//creates a new scanner for user input. sc will be used when need for user input
         
        System.out.println("Employee ID Registered: 1 and 2");
        System.out.print("Choose Employee ID Registered: ");
        String EmID = sc.nextLine();//User Input for Employee ID
         
         switch (EmID) {
            case "1":
            {
                var employee1 = new EmployeeDetail("Juztin Kristoffer P. Estacio", 1, "Male", "December 7, 2005");
                employee1.display();
                var SalaryCalculation = new SalaryCalculation();
                break;
            }
            case "2":
            {
                var employee2 = new EmployeeDetail("Janaya", 2, "Female", "May 14, 2014");
                employee2.display();
                var SalaryCalculation = new SalaryCalculation();
                break;
            }
            default://This is the default and will run if the user inputs Employee ID other than 001 or 002(Registered Employee ID)
            System.out.println("No Employee Registered with the inserted Employee ID");
            
              
    }   
    }
}

         
         
    
    
