package dao;

import org.junit.Before;
import org.junit.Test;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {
        private Sql2oNewsDao newsDao; //ignore me for now. We'll create this soon.
        private Connection conn; //must be sql2o class conn

        @Before
        public void setUp() throws Exception {
            String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
            Sql2o sql2o = new Sql2o(connectionString, "", "");
            NewsDao newsDao= new Sql2oNewsDao(sql2o);
            conn = sql2o.open(); //keep connection open through entire test so it does not get erased
        }

    @Test
    public void addingNews() throws Exception {
        News news = new News ("sacking","promotion");
        int originalTaskId = news.getId();
        newsDao.add(news);
        assertNotEquals(originalTaskId, news.getId()); //how does this work?
    }


}
