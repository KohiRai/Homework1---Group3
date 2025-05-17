package motorphsalarycalculation;

public class EmployeeDetail {
    private String EmployeeName;
    private int EmployeeID;
    private String EmployeeGender;
    private String EmployeeBirthday;
    
    public EmployeeDetail(String EmployeeName, int EmployeeID, String EmployeeGender, String EmployeeBirthday){
        this.EmployeeName = EmployeeName;
        this.EmployeeID = EmployeeID;
        this.EmployeeGender = EmployeeGender;
        this.EmployeeBirthday = EmployeeBirthday;
}
    //getter Methods
    public String getName(){
        return EmployeeName;
    }
    
    public int getID(){
        return EmployeeID;
    }
    
    public String getGender(){
        return EmployeeGender;
    }
    
    public String getBirthday(){
        return EmployeeBirthday;
    }
    
    
    //setter Methods 
            
    private void setName(String EmployeeName){        
       this.EmployeeName = EmployeeName;
    }
    private void setID(int EmployeeID){        
       this.EmployeeID = EmployeeID;
    }
    private void setGender(String EmployeeGender){        
       this.EmployeeGender = EmployeeGender;
    }
    private void setBirthday(String EmployeeBirthday){        
       this.EmployeeBirthday = EmployeeBirthday;
    }
    
    public void display(){
       System.out.println("\n"+ "Employee Name: " + EmployeeName + "\n" + 
                          "Employee ID: " + EmployeeID + "\n" +
                          "Employee Gender: " + EmployeeGender + "\n" + 
                          "Employee Birthday: " + EmployeeBirthday + "\n");
    }
    
}






