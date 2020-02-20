package dao;


import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;


public class Sql2oNewsDao implements NewsDao{
        private final Sql2o sql2o;

        public Sql2oNewsDao(Sql2o sql2o){
            this.sql2o = sql2o;
        }


    @Override
    public void add(News news){
        String sql = "INSERT INTO news(generalnewa, departmentalnews)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public List <News> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class);
        }
    };
    @Override
    public void deleteById(int id) {
        String sql = "DELETE from news WHERE id = :id";
        String deleteJoin = "DELETE from departments_news WHERE departmentsid = :departmentId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            con.createQuery(deleteJoin)
                    .addParameter("departmentsId", id)
                    .executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


}
