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
    public void createNewDepartment_finance() {
        Departments newDepartments = new Departments("finance", "deal with money", 25);
        assertEquals("finance", newDepartments.getDepartmentName());
    }

    @Test
    public void initializeDescription_description() {
        Departments newDepartments = new Departments("finance", "deal with money", 25);
        assertEquals("deal with money", newDepartments.getDescription());
    }

    @Test
    public void initializeEmployeeNumber_25() {
        Departments newDepartments = new Departments("finance", "deal with money", 25);
        assertEquals(25, newDepartments.getEmployeeNumber());
    }
}

