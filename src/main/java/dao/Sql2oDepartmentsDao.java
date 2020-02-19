package dao;

import models.Departments;
import org.sql2o.Connection;
import org.sql2o.*;
import  java.util.List;

import java.util.ArrayList;

public class Sql2oDepartmentsDao implements DepartmentDao{
    private final Sql2o sql2o;

    public Sql2oDepartmentsDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Departments departments){
        String sql = "INSERT INTO departments(name, description, numberOfemployees)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(departments)
                    .executeUpdate()
                    .getKey();
            departments.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Departments> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Departments.class);
        }
    };


    @Override
    public void deleteById(int id) {
        String sql = "DELETE from departments WHERE id = :id";
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
