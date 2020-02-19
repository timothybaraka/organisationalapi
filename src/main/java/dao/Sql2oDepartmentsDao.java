package dao;

import java.util.ArrayList;

public class Sql2oDepartmentsDao {

    @Override
    public void addDepartmentsToNews(Department department, News news) {
//do stuff here.
    }

    @Override
    public List<News> getAllFoodtypesByDepartment(int departmentId) {
        List<News> news = new ArrayList(); //empty list
        return news;
    }


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
