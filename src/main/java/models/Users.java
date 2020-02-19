package models;

public class Users {
    private String userName;
    private String userPosition;
    private String userRole;
    private String departmentId;


    public Users(String userName, String userPosition, String userRole, String departmentId){
        this.userName=userName;
        this.userPosition = userPosition;
        this.userRole = userRole;
        this.departmentId = departmentId;
    }

    public String getUserName(){
        return userName;
    }
    public String getUserPosition(){
        return userPosition;
    }
    public String getUserRole(){
        return userRole;
        }
    public String getDepartmentId(){
        return departmentId;
    }

}
