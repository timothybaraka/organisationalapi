package dao;

public interface NewsDao {

    //create
    void add (News news);
    void addNewsToDepartment(News news, Departments departments);


    //read
    List<News> getAll();
    News findById(int id);


    //update
    void update(int id, String name, String address, String zipcode, String phone, String website, String email);

    //delete
    void deleteById(int id);
    void clearAll();
}

