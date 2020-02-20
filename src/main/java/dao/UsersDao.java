package dao;


import models.Users;

import java.util.List;

public interface UsersDao {


    //create
    void add(Users users);

    //read
    List<Users> getAll();


    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}

