package dao;

import models.Departments;
import java.util.List;

public interface DepartmentDao {

    //create
    void add(Departments departments);
//    void addDepartmentsToNews(Departments departments, News news);


    //read
    List<Departments> getAll();
//    List<News> getAllNewsByDepartment(int departmentId);

    //update
    //omit for now

    //delete
    void deleteById(int id);
//    void clearAll();
}


