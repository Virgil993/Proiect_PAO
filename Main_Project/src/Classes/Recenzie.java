package Classes;

public class Recenzie {

    private String local;
    private Integer number_of_stars;
    private String comment;
    private String user_Name;

    public Recenzie(){}

    public Recenzie(String Local, Integer Number_of_stars, String Comment, String User_Name)
    {
        this.local = Local;
        this.number_of_stars = Number_of_stars;
        this.comment=Comment;
        this.user_Name=User_Name;
    }

    public String getLocal() {
        return local;
    }

    public Integer getNumber_of_stars() {
        return number_of_stars;
    }

    public String getComment() {
        return comment;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setNumber_of_stars(Integer number_of_stars) {
        this.number_of_stars = number_of_stars;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    @Override
    public String toString() {
        return "Recenzie{" +
                "local='" + local + '\'' +
                ", number_of_stars=" + number_of_stars +
                ", comment='" + comment + '\'' +
                ", user_Name='" + user_Name + '\'' +
                '}';
    }
}
