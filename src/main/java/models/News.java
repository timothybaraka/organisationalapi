package models;

public class News {
    private String generalNews;
    private String departmentalNews;
    private int id;

    public News(String generalNews, String departmentalNews){
        this.generalNews = generalNews;
        this.departmentalNews = departmentalNews;
    }
    public String getGeneralNews(){
        return generalNews;
    }
    public String getDepartmentalNews(){
        return departmentalNews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
