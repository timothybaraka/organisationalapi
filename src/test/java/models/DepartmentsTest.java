package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentsTest {

    @Test
    public void initializeNewDepartment_true() {
        Departments newDepartments = new Departments("finance", "deal with money", 25);
        assertEquals(true, newDepartments instanceof Departments);
    }

    @Test
    public void NewDepartment_true() {
        Departments newDepartments = new Departments("finance", "deal with money", 25);
        assertEquals(true, newDepartments instanceof Departments);
    }
}

