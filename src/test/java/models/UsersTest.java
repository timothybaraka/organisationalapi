package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    @Test
    public void createNewUser_true() {
        Users  users= new Users("lenny","chairman", "counting", "finance");
        assertEquals(true, users instanceof News);
    }

    @Test
    public void createNewUsername_lenny() {
        Users  users= new Users("lenny","chairman", "counting", "finance");
        assertEquals("lenny", users.getUserName());
    }
    @Test
    public void createNewUserPosition_chairman() {
        Users  users= new Users("lenny","chairman", "counting", "finance");
        assertEquals("chairman", users.getUserPosition());
    }
    @Test
    public void createNewUserRole_counting() {
        Users  users= new Users("lenny","chairman", "counting", "finance");
        assertEquals("counting", users.getUserRole());
    }
    @Test
    public void createNewDepartmentId_finance() {
        Users  users= new Users("lenny","chairman", "counting", "finance");
        assertEquals("finance", users.getDepartmentId());
    }

}