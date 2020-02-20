package dao;

import org.junit.*;
import java.util.List;
import models.Departments;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class Sql2oDepartmentsDaoTest {
    private static Sql2oDepartmentsDao departmentsDao;
    private static Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        conn.close();
    }
    public Departments testDepartment(){
        return new Departments("accounts", "financial issues",8);
    }

    @Test
    public void addingADepartmentSetsId() throws Exception{
        Departments departments = testDepartment();
        int departmentId = departments.getId();
        departmentsDao.add(departments);
        assertNotEquals(departmentId, departments.getId());
    }
//    @Test
//    public void findByIdCanFindDepartmentById() throws Exception{
//        Department department = testDepartment();
//        departmentDao.add(department);
//        Department foundDepartment = departmentDao.findById(department.getId());
//        assertEquals(department, foundDepartment);
//    }
    @Test
    public void getAllDepartmentReturnsAllCreatedDepartments() throws Exception{
        Departments departments = testDepartment();
        Departments anotherDepartment = new Departments("hr", "deals with all employees", 4);
        departmentsDao.add(departments);
        departmentsDao.add(anotherDepartment);
        assertEquals(2, departmentsDao.getAll().size());
    }
//    @Test
//    public void ifNoDepartmentExistsReturnsEmpty() throws Exception{
//        assertEquals(0, departmentDao.getAll().size());
//    }
//    @Test
//    public void addingNews() throws Exception {
//        Departments departments = new Departments ("finance","money",25);
//        int originalDepId = departments.getId();
//        departmentsDao.add(departments);
//        assertNotEquals(originalDepId, departments.getId()); //how does this work?
//    }



//    @Test
//    public void DepartmentsReturnsNewsCorrectly() throws Exception {
//        News testNews  = new News("Seafood");
//        newsDao.add(testNews);
//
//        News otherNews  = new News("Bar Food");
//        newsDao.add(otherNews);
//
//        Departments testDepartments = setupDepartments();
//        departmentsDao.add(testDepartments);
//        departmentsDao.addDepartmentsToNews(testDepartments,testNews);
//        departmentsDao.addDepartmentsToNews(testDepartments,otherNews);
//
//        News[] news = {testNews, otherNews}; //oh hi what is this? Observe how we use its assertion below.
//
//        assertEquals(Arrays.asList(news), departmentsDao.getAllNewssByDepartments(testDepartments.getId()));
//    }
//
//    @Override
//    public void addDepartmentsToNews(Departments departments, News news){
//        String sql = "INSERT INTO departments_news (departmentsid, newsid) VALUES (:departmentsId, :newsId)";
//        try (Connection con = sql2o.open()) {
//            con.createQuery(sql)
//                    .addParameter("departmentsId", departments.getId())
//                    .addParameter("newsId", news.getId())
//                    .executeUpdate();
//        } catch (Sql2oException ex){
//            System.out.println(ex);
//        }
//    }
//
//    @Override
//    public List<News> getAllNewssByDepartments(int departmentsId) {
//        ArrayList<News> news = new ArrayList<>();
//
//        String joinQuery = "SELECT newsid FROM departments_news WHERE departmentsid = :departmentsId";
//
//        try (Connection con = sql2o.open()) {
//            List<Integer> allNewssIds = con.createQuery(joinQuery)
//                    .addParameter("departmentsId", departmentsId)
//                    .executeAndFetch(Integer.class);
//            for (Integer foodId : allNewssIds){
//                String newsQuery = "SELECT * FROM news WHERE id = :newsId";
//                news.add(
//                        con.createQuery(newsQuery)
//                                .addParameter("newsId", foodId)
//                                .executeAndFetchFirst(News.class));
//            }
//        } catch (Sql2oException ex){
//            System.out.println(ex);
//        }
//        return news;
//    }

}