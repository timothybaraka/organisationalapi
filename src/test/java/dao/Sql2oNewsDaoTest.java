package dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {

    public void addFoodTypeToDepartmentsAddsTypeCorrectly() throws Exception {

        Departments testDepartments = setupDepartments();
        Departments altDepartments = setupAltDepartments();

        restaurantDao.add(testDepartments);
        restaurantDao.add(altDepartments);

        News testNews = setupNewNews();

        newsDao.add(testNews);

        newsDao.addNewsToDepartments(testNews, testDepartments);
        newsDao.addNewsToDepartments(testNews, altDepartments);

        assertEquals(2, newsDao.getAllDepartmentssForANews(testNews.getId()).size());
    }

    @Test
    public void deleteingDepartmentsAlsoUpdatesJoinTable() throws Exception {
        News testNews  = new News("Seafood");
        newsDao.add(testNews);

        Departments testDepartments = setupDepartments();
        departmentsDao.add(testDepartments);

        Departments altDepartments = setupAltDepartments();
        departmentsDao.add(altDepartments);

        departmentsDao.addDepartmentsToNews(testDepartments,testNews);
        departmentsDao.addDepartmentsToNews(altDepartments, testNews);

        departmentsDao.deleteById(testDepartments.getId());
        assertEquals(0, departmentsDao.getAllNewssByDepartments(testDepartments.getId()).size());
    }

}
