package dao;
import models.Departments;
import models.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oUsersDaoTest {

    private Connection conn;
    private Sql2oUsersDao reviewDao;
    private Sql2oDepartmentsDao departmentsDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        usersDao = new Sql2oUsersDao(sql2o);
        newsDao = new Sql2onewsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingUsersSetsId() throws Exception {
        Users testUsers = setupUsers();
        assertEquals(1, testUsers.getId());
    }

    @Test
    public void getAll() throws Exception {
        Users review1 = setupUsers();
        Users review2 = setupUsers();
        assertEquals(2, reviewDao.getAll().size());
    }

    @Test
    public void getAllUserssByDepartments() throws Exception {
        Departments testDepartments = setupDepartments();
        Departments otherDepartments = setupDepartments(); //add in some extra data to see if it interferes
        Users users1 = setupUsersForDepartments(testDepartments);
        Users users2 = setupUsersForDepartments(testDepartments);
        Users usersForOtherDepartments = setupUsersForDepartments(otherDepartments);
        assertEquals(2, reviewDao.getAllUserssByDepartments(testDepartments.getId()).size());
    }

    @Test
    public void deleteById() throws Exception {
        Users testUsers = setupUsers();
        Users otherUsers = setupUsers();
        assertEquals(2, reviewDao.getAll().size());
        reviewDao.deleteById(testUsers.getId());
        assertEquals(1, reviewDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Users testUsers = setupUsers();
        Users otherUsers = setupUsers();
        reviewDao.clearAll();
        assertEquals(0, reviewDao.getAll().size());
    }

    //helpers

    public Users setupUsers() {
        Users users = new Users("great", "Kim", 4, 555);
        reviewDao.add(review);
        return review;
    }

    public Users setupUsersForDepartments(Departments departments) {
        Users review = new Users("great", "Kim", 4, departments.getId());
        reviewDao.add(review);
        return review;
    }

    public Departments setupDepartments() {
        Departments departments = new Departments("Fish Witch", "214 NE Broadway", "97232", "503-402-9874", "http://fishwitch.com", "hellofishy@fishwitch.com");
        departmentsDao.add(departments);
        return departments;
    }
}
}
