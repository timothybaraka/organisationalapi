package dao;

import models.Review;
import java.util.List;

public interface UsersDao {


    //create
    void add(Users users);

    //read
    List<Users> getAll();
    List<Users> getAllReviewsByRestaurant(int restaurantId);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}

