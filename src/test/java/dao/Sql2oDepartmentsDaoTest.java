package dao;

import com.sun.jdi.connect.spi.Connection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Sql2oDepartmentsDaoTest {



    @Test
    public void DepartmentsReturnsNewsCorrectly() throws Exception {
        News testNews  = new News("Seafood");
        newsDao.add(testNews);

        News otherNews  = new News("Bar Food");
        newsDao.add(otherNews);

        Departments testDepartments = setupDepartments();
        departmentsDao.add(testDepartments);
        departmentsDao.addDepartmentsToNews(testDepartments,testNews);
        departmentsDao.addDepartmentsToNews(testDepartments,otherNews);

        News[] news = {testNews, otherNews}; //oh hi what is this? Observe how we use its assertion below.

        assertEquals(Arrays.asList(news), departmentsDao.getAllNewssByDepartments(testDepartments.getId()));
    }

    @Override
    public void addDepartmentsToNews(Departments departments, News news){
        String sql = "INSERT INTO departmentss_news (departmentsid, newsid) VALUES (:departmentsId, :newsId)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("departmentsId", departments.getId())
                    .addParameter("newsId", news.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<News> getAllNewssByDepartments(int departmentsId) {
        ArrayList<News> news = new ArrayList<>();

        String joinQuery = "SELECT newsid FROM departments_news WHERE departmentsid = :departmentsId";

        try (Connection con = sql2o.open()) {
            List<Integer> allNewssIds = con.createQuery(joinQuery)
                    .addParameter("departmentsId", departmentsId)
                    .executeAndFetch(Integer.class);
            for (Integer foodId : allNewssIds){
                String newsQuery = "SELECT * FROM news WHERE id = :newsId";
                news.add(
                        con.createQuery(newsQuery)
                                .addParameter("newsId", foodId)
                                .executeAndFetchFirst(News.class));
            }
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
        return news;
    }




}