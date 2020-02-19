package models;

public class News {
    private String generalNews;
    private String departmentalNews;

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

}
