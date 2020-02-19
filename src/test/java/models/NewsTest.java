package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    @Test
    public void createNewNews_true() {
        News classnews = new News("moshene", "departmental moshene");
        assertEquals(true, classnews instanceof News);
    }

    @Test
    public void instantiatesGeneralNews_moshene() {
        News classnews = new News("moshene", "departmental moshene");
        assertEquals("moshene", classnews.getGeneralNews());
    }

    @Test
    public void instantiatesDepartmentalNews() {
        News classnews = new News("moshene", "departmental moshene");
        assertEquals("departmental moshene", classnews.getDepartmentalNews());
    }



}