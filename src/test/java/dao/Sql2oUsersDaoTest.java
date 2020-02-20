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
        NewsDao newsDao= new Sql2oNewsDao(sql2o);
        conn = sql2o.open(); //keep connection open through entire test so it does not get erased
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingNews() throws Exception {
        Users users = new Users ("john","chairman","counting","finance");
        int originalTaskId = users.getId();
        users.add(users);
        assertNotEquals(originalTaskId, users.getId()); //how does this work?
    }




}

