package Model;

import java.util.ArrayList;
import java.util.List;

public class Semestr {
    private List<PublicWork> listOfWork;

    public Semestr(){
        listOfWork=new ArrayList<>();
    }

    public void addToList(PublicWork publicWork){
        listOfWork.add(publicWork);
    }

    public String listToString(){
        String res="";
        if(listOfWork.size()==0){
            return "nothing";
        }
        else {
            for (int work = 0; work < listOfWork.size(); work++) {
                res += listOfWork.get(work).getWork() + " - " + Integer.toString(listOfWork.get(work).getHours()) + "ч;\n";
            }
            return res;
        }
    }

    public int getTotalHours(){
        int totalHours=0;
        for (int listNode=0;listNode<listOfWork.size();listNode++){
            totalHours+=listOfWork.get(listNode).getHours();
        }
        return totalHours;
    }

    public void setListOfWork(List<PublicWork> listOfWork) {
        this.listOfWork = listOfWork;
    }

    public boolean isInWork(String work){
        for (int workIndex=0;workIndex<listOfWork.size();workIndex++){
            if(work.equals(listOfWork.get(workIndex).getWork())==true){
                return true;
            }
        }
        return false;
    }

    public List<PublicWork> getListOfWork(){
        return listOfWork;
    }
}