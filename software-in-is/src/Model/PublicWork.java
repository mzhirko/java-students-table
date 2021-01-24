package Model;

import Model.Semestr;

public class PublicWork {
    private String work;
    private int hours;

    public PublicWork(){
        work="nothing";
        hours=0;
    }

    public PublicWork(String work,int hours){
        this.work=work;
        this.hours=hours;
    }

    public String getWork() {
        return work;
    }

    public int getHours() {
        return hours;
    }

    public void  setWork(String work){
        this.work=work;
    }

    public  void setHours(int hours){
        this.hours=hours;
    }
}
