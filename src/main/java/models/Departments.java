package models;

public class Departments {
    private String departmentName;
    private String Description;
    private Integer employeeNumber;
    private int id;



    public Departments(String departmentName, String Description, Integer employeeNumber){
        this.departmentName = departmentName;
        this.Description = Description;
        this.employeeNumber = employeeNumber;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public String getDescription(){
        return departmentName;
    }

    public int getEmployeeNumber(){
        return employeeNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
