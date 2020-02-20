package dao;
import models.News;

import java.util.List;

public interface NewsDao {

    //create
    void add (News news);
//    void addNewsToDepartment(News news);


    //read
    List<News> getAll();
//    News findById(int id);


    //update
//    void update( int newsid, int deparmentsid ;

    //delete
    void deleteById(int id);
//    void clearAll();
}

