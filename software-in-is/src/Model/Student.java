package Model;

import java.util.ArrayList;
import java.util.List;

public class Student{
    private Name name;
    private String group;
    private Semestr firstSem;
    private Semestr secondSem;
    private Semestr thirdSem;
    private Semestr fourthSem;
    private Semestr fifthSem;
    private Semestr sixthSem;
    private Semestr seventhSem;
    private Semestr eighthSem;
    private Semestr ninthSem;
    private Semestr tenthSem;

    public Student(){
        name=new Name();
        group="";
        firstSem=new Semestr();
        secondSem=new Semestr();
        thirdSem=new Semestr();
        fourthSem=new Semestr();
        fifthSem=new Semestr();
        sixthSem=new Semestr();
        seventhSem=new Semestr();
        eighthSem=new Semestr();
        ninthSem=new Semestr();
        tenthSem=new Semestr();
    }

    public void setName(Name name){
        this.name=name;
    }

    public void setGroup(String group){
        this.group=group;
    }

    public void addToFirstSem(PublicWork publicWork){
        firstSem.addToList(publicWork);
    }

    public void addToSecondSem(PublicWork publicWork){
        secondSem.addToList(publicWork);
    }

    public void addToThirdSem(PublicWork publicWork){
        thirdSem.addToList(publicWork);
    }

    public void addToFourthSem(PublicWork publicWork){
        fourthSem.addToList(publicWork);
    }

    public void addToFifthSem(PublicWork publicWork){
        fifthSem.addToList(publicWork);
    }

    public void addToSixthSem(PublicWork publicWork){
        sixthSem.addToList(publicWork);
    }

    public void addToSeventhSem(PublicWork publicWork){
        seventhSem.addToList(publicWork);
    }

    public void addToEighthSem(PublicWork publicWork){
        eighthSem.addToList(publicWork);
    }

    public void addToNinthSem(PublicWork publicWork){
        ninthSem.addToList(publicWork);
    }

    public void addToTenthSem(PublicWork publicWork){
        tenthSem.addToList(publicWork);
    }

    public String getName(){
        return name.getLastName()+" "+name.getFirstName()+" "+name.getFatherName();
    }

    public Name getNameObject(){
        return name;
    }

    public String getGroup(){
        return group;
    }

    public String getFirstSem(){
        return firstSem.listToString();
    }

    public String getSecondSem(){
        return secondSem.listToString();
    }

    public String getThirdSem(){
        return thirdSem.listToString();
    }

    public String getFourthSem(){
        return fourthSem.listToString();
    }

    public String getFifthSem(){
        return fifthSem.listToString();
    }

    public String getSixthSem(){
        return sixthSem.listToString();
    }

    public String getSeventhSem(){
        return seventhSem.listToString();
    }

    public String getEighthSem(){
        return  eighthSem.listToString();
    }

    public String getNinthSem(){
        return ninthSem.listToString();
    }

    public String getTenthSem(){
        return tenthSem.listToString();
    }

    public void setFirstSem(Semestr semestr){
        firstSem=semestr;
    }

    public void setSecondSem(Semestr semestr){
        secondSem=semestr;
    }

    public void setThirdSem (Semestr semestr){
        thirdSem=semestr;
    }

    public void setFourthSem(Semestr semestr){
        fourthSem=semestr;
    }

    public void setFifthSem(Semestr semestr){
        fifthSem=semestr;
    }

    public void setSixthSem(Semestr semestr){
        sixthSem=semestr;
    }

    public void setSeventhSem(Semestr semestr){
        seventhSem=semestr;
    }

    public void setEighthSem(Semestr semestr){
        eighthSem=semestr;
    }

    public void setNinthSem(Semestr semestr){
        ninthSem=semestr;
    }

    public void setTenthSem(Semestr semestr){
        tenthSem=semestr;
    }

    public int getTotalHours(){
        int totalHours=0;
        totalHours+=firstSem.getTotalHours();
        totalHours+=secondSem.getTotalHours();
        totalHours+=thirdSem.getTotalHours();
        totalHours+=fourthSem.getTotalHours();
        totalHours+=fifthSem.getTotalHours();
        totalHours+=sixthSem.getTotalHours();
        totalHours+=seventhSem.getTotalHours();
        totalHours+=eighthSem.getTotalHours();
        totalHours+=ninthSem.getTotalHours();
        totalHours+=tenthSem.getTotalHours();
        return totalHours;
    }

    public boolean isInWork(String work){
        if(firstSem.isInWork(work)||
           secondSem.isInWork(work)||
           thirdSem.isInWork(work)||
           fourthSem.isInWork(work)||
           fifthSem.isInWork(work)||
           sixthSem.isInWork(work)||
           seventhSem.isInWork(work)||
           eighthSem.isInWork(work)||
           ninthSem.isInWork(work)||
           tenthSem.isInWork(work))
        {
            return true;
        }
        return false;
    }

    public String getLastName(){
        return name.getLastName();
    }

    public String getFirstName(){
        return  name.getFirstName();
    }

    public String getFatherName(){
        return name.getFatherName();
    }

    public List<PublicWork> getFirstSemList(){
        return firstSem.getListOfWork();
    }

    public List<PublicWork> getSecondSemList(){
        return secondSem.getListOfWork();
    }

    public List<PublicWork> getThirdSemList(){
        return thirdSem.getListOfWork();
    }

    public List<PublicWork> getFourthSemList(){
        return fourthSem.getListOfWork();
    }

    public List<PublicWork> getFifthSemList(){
        return fifthSem.getListOfWork();
    }

    public List<PublicWork> getSixthSemList(){
        return sixthSem.getListOfWork();
    }

    public List<PublicWork> getSeventhSemList(){
        return seventhSem.getListOfWork();
    }

    public List<PublicWork> getEighthSemList(){
        return eighthSem.getListOfWork();
    }

    public List<PublicWork> getNinthSemList(){
        return ninthSem.getListOfWork();
    }

    public List<PublicWork> getTenthSemList(){
        return tenthSem.getListOfWork();
    }
}