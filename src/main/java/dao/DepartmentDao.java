package dao;

public interface DepartmentDao {

    //create
    void add(Department department);
    void addDepartmentsToNews(Departments departments, News news);


    //read
    List<Departments> getAll();
    List<News> getAllNewsByDepartment(int departmentId);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}


