package motorphsalarycalculation;

import java.util.Scanner;//imports scanner for user input
import java.text.DecimalFormat;


public class SalaryCalculation {
    private static final DecimalFormat decfor = new DecimalFormat("0.00");//Formats Decimal places to be only 2 places
    Scanner sc = new Scanner(System.in);//creates a new scanner for user input. sc will be used when need for user input
    
    private double BasicSalary, DailyRate, DaysWorked, OvertimeHours;
    private double OverTimePay ,Overtime ,GrossIncome;
    private double Benefits;
    private double SSS, Philhealth,PagIbig;
    private double TotalDeduction = SSS + Philhealth + PagIbig//These are Deductions without Withholding Tax Since it would be calculated with total deductions of SSS, Philhealht, and PagIbig
                           ,WithholdingTax = 0//WithHolding Tax is automatically 0, and would be declared inside if,elseif,else statements and would be calculated inside the conditions(If,elseif,else)
                          ,TaxableIncome = BasicSalary - TotalDeduction;//TaxableIncome will be used to calculate the Withholding Tax
    private double FinalTotalDeductions = TotalDeduction + WithholdingTax;
    private double NetIncome = GrossIncome + Benefits - FinalTotalDeductions;   
    
    //constructor
    public SalaryCalculation(){
        
        //Requests the user input of The employee's Basic Salary
        System.out.print("Enter Employee's Basic Salary: ");
        BasicSalary = sc.nextDouble();
        
        this.BasicSalary = BasicSalary;
       
        DailyRate = BasicSalary / 20;//Calculation for Dailyrate
        System.out.println("Daily Rate: " + decfor.format(DailyRate));//Prints the Calculated DailyRate
        
        DaysValidity();//Calls out the While loop for right days input before proceeds to calculate others
        
        //Requests user input of Overtime Hours 
        System.out.print("Enter Overtime Hours: ");
        OvertimeHours = sc.nextInt();
        
        OverTimePay = DailyRate * .10; //OverTimePay = Daily rate times 0.1 or 10%
        Overtime = OvertimeHours * OverTimePay;//Overtime = Overtime Hours times OTP
        GrossIncome = DailyRate * DaysWorked + Overtime;  // Compute for Gross Income. Gross income = Daily Rate times Days Worked Plus Overtime Time
     
        Benefits = 4500.00d; //Assigned value of benefits           
        System.out.println("Gross Income: P" + decfor.format(GrossIncome));//Prints/shows Gross Income
        
        Benefits();
        
        System.out.println("Deductions");//Title of next section
        SSS = BasicSalary * 0.045; //Calculation for SSS Deduction
        Philhealth = BasicSalary * 0.03; //Calculation for SSS Deduction
        PagIbig = BasicSalary * 0.02; // PagIbig = BasicSalary * 2%
                    
        System.out.println("Social Security Systems Deductions: P" + decfor.format(SSS));
        System.out.println("Philhealth Deduction: P" + decfor.format(Philhealth));
        System.out.println("Pag-Ibig Deduction: P" + decfor.format(PagIbig) + "\n");
        
        WithholdingTax();
        
        Summary();
    }
    
    
    //While loop for Right Days Input
    private void DaysValidity(){
        
    DaysWorked = 0;
    while(true){
                    System.out.print("Enter Days Worked during the Month(Maximum: 20 Days): ");
                    DaysWorked = sc.nextInt();//User input days worked. NOTE: User input 
                    if(DaysWorked > 0 && DaysWorked <= 20){
                    break;//This Statement will run over and over again unless the user inputs a valid number of Days Worked such as below and equal to 20 days
        }   
        System.out.println("Invalid Days Worked");
         }
}
    
    private void Benefits(){
        System.out.println();//Prints a line for space
                    System.out.println("Benefits" );//Title of the next section
                    System.out.println();
                    System.out.println("Rice Subsidy: P1500.00");//Prints/shows Rice Subsidy Benefits
                    System.out.println("Phone Allowance: P2000.00");//Prints/shows Phone Allowance Benefits
                    System.out.println("Clothing Allowance: P1000.00");//Prints/shows Rice Clothing Allowance Benefits
                    System.out.println("Benefits: P" + decfor.format(Benefits) + "\n");//Prints/Shows Total Benefits
    }
    
    private void WithholdingTax(){
        TotalDeduction = SSS + Philhealth + PagIbig;//These are Deductions without Withholding Tax Since it would be calculated with total deductions of SSS, Philhealht, and PagIbig
        WithholdingTax = 0;//WithHolding Tax is automatically 0, and would be declared inside if,elseif,else statements and would be calculated inside the conditions(If,elseif,else)
        TaxableIncome = BasicSalary - TotalDeduction;//TaxableIncome will be used to calculate the Withholding Tax
                    
                        if (BasicSalary >= 20_833 && BasicSalary < 33_333) {//This will run  if Basic Salary is 20,833 to below 33,333
                        WithholdingTax = (TaxableIncome - 20_833) * 0.20;//This condition is based on The MotorPH Witholdding Tax Rate
                    }
                        else if (BasicSalary >= 33_333 && BasicSalary < 66_667) {//This will run  if Basic Salary is 33,333 to below 66,667
                        WithholdingTax = ((TaxableIncome - 33_333) * 0.25) + 2_500;//This condition is based on The MotorPH Witholdding Tax Rate
                    }
                        else if (BasicSalary >= 66_667 && BasicSalary < 166_667) {//This will run  if Basic Salary is 66,667 to below 166,667
                        WithholdingTax = ((TaxableIncome - 66_667) * 0.30) + 10_833;//This condition is based on The MotorPH Witholdding Tax Rate
                    }   
                        else if (BasicSalary >= 166_667 && BasicSalary < 666_667) {//This will run  if Basic Salary is 166,667 to below 666,667
                        WithholdingTax = ((TaxableIncome - 66_667) * 0.32) + 40_833.33;//This condition is based on The MotorPH Witholdding Tax Rate
                    }   
                        else if (BasicSalary >= 666_667) {//This will run  if Basic Salary is 666,667 and above
                        WithholdingTax = ((TaxableIncome - 666_667) * 0.35) + 200_833.33;//This condition is based on The MotorPH Witholdding Tax Rate
                    }   
                        else{//This will run  if Basic Salary is 20,832 and below
                            WithholdingTax = 0;//Basic Salaries that are 20,832 and below it will have no withholding Tax
                        }
                        
                    System.out.println("Withholding Tax: P" + decfor.format(WithholdingTax));    
                    FinalTotalDeductions = TotalDeduction + WithholdingTax; //Final Total Deductions = SSS plus Philhealth plus Pag-Ibig plus Withholding Tax
                    System.out.println("Total Deductions: P" + decfor.format(FinalTotalDeductions) + "\n");//Prints/shows total deduction
    }
    
    private void Summary(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");//Space for final section
                    System.out.println();//Prints a new line for space
                    System.out.println("Summary");//Title of next final section
                    System.out.println();
                    System.out.println("Gross Income: P" + decfor.format(GrossIncome));//Prints/shows Gross Income
                    System.out.println("Benefits: P" + decfor.format(Benefits));//Prints/shows Benefits
                    System.out.println("Deductions: P" + decfor.format(FinalTotalDeductions));//Prints/shows Deductions
                    System.out.println();//Prints a new line for space
                    
                    NetIncome = GrossIncome + Benefits - FinalTotalDeductions; // NetIncome = Gross income plus Benefits minus FinalTotalDeductions
                    System.out.println("Net Income: P" + decfor.format(NetIncome));// prints/shows Net Income
    }
}




