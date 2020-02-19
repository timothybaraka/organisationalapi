package models;

public class Departments {
    private String departmentName;
    private String Description;
    private Integer employeeNumber;

    public Departments(String departmentName, String Description, Integer employeeNumber){
        this.departmentName = departmentName;
        this.Description = Description;
        this.employeeNumber = employeeNumber;
    }

    public String getDepartmentName(){
        return departmentName;
    }


}
