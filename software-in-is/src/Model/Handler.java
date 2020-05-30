package Model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class Handler extends DefaultHandler{
    private StudentDatabase studentDatabase;
    private List<Student> list=new ArrayList<>();
    private Student student=new Student();
    private Semestr sem=new Semestr();
    private List<PublicWork> listOfWork=new ArrayList<>();
    private PublicWork publicWork=new PublicWork();
    private String element="";
    private boolean bLastName=false;
    private boolean bFirstName=false;
    private boolean bFatherName=false;
    private boolean bGroup=false;
    private boolean bWork=false;
    private boolean bHours=false;

    @Override
    public void startDocument() throws SAXException{ }

    @Override
    public void endDocument() throws SAXException{ }

    @Override
    public void startElement(String uri, String localName, String qName,Attributes attr){
        if(qName.equalsIgnoreCase("student")){
            student=new Student();
        }
        else if(qName.equalsIgnoreCase("lastName")){
            bLastName=true;
        }
        else if(qName.equalsIgnoreCase("firstName")){
            bFirstName=true;
        }
        else if(qName.equalsIgnoreCase("fatherName")){
            bFatherName=true;
        }
        else if(qName.equalsIgnoreCase("group")){
            bGroup=true;
        }
        else if(qName.equalsIgnoreCase("work")){
            bWork=true;
        }
        else if(qName.equalsIgnoreCase("hours")){
            bHours=true;
        }
        else if(qName.equals("firstSem")){
            sem=new Semestr();
        }
        else if(qName.equals("secondSem")){
            sem=new Semestr();
        }
        else if(qName.equals("thirdSem")){
            sem=new Semestr();
        }
        else if(qName.equals("fourthSem")){
            sem=new Semestr();
        }
        else if(qName.equals("fifthSem")){
            sem=new Semestr();
        }
        else if(qName.equals("sixthSem")){
            sem=new Semestr();
        }
        else if(qName.equals("seventhSem")){
            sem=new Semestr();
        }
        else if(qName.equals("eighthSem")){
            sem=new Semestr();
        }
        else if(qName.equals("ninthSem")){
            sem=new Semestr();
        }
        else if(qName.equals("tenthSem")){
            sem=new Semestr();
        }
        else if(qName.equals("listOfWork")){
            listOfWork=new ArrayList<>();
        }
        else if(qName.equals("publicWork")){
            publicWork=new PublicWork();
        }
        element=qName;
    }

    @Override
    public void endElement(String uri,String localName,String qName){
        if(qName.equalsIgnoreCase("lastName")){
            bLastName=false;
        }
        else if(qName.equalsIgnoreCase("firstName")){
            bFirstName=false;
        }
        else if(qName.equalsIgnoreCase("fatherName")){
            bFatherName=false;
        }
        else if(qName.equalsIgnoreCase("group")){
            bGroup=false;
        }
        else if(qName.equalsIgnoreCase("work")){
            bWork=false;
        }
        else if(qName.equalsIgnoreCase("hours")){
            bHours=false;
        }
        else if(qName.equals("student")){
            list.add(student);
        }
        else if(qName.equals("firstSem")){
            student.setFirstSem(sem);
        }
        else if(qName.equals("secondSem")){
            student.setSecondSem(sem);
        }
        else if(qName.equals("thirdSem")){
            student.setThirdSem(sem);
        }
        else if(qName.equals("fourthSem")){
            student.setFourthSem(sem);
        }
        else if(qName.equals("fifthSem")){
            student.setFifthSem(sem);
        }
        else if(qName.equals("sixthSem")){
            student.setSixthSem(sem);
        }
       else if(qName.equals("seventhSem")){
            student.setSeventhSem(sem);
        }
        else if(qName.equals("eighthSem")){
            student.setEighthSem(sem);
        }
        else if(qName.equals("ninthSem")){
            student.setNinthSem(sem);
        }
        else if(qName.equals("tenthSem")){
            student.setTenthSem(sem);
        }
        else if(qName.equals("listOfWork")){
            sem.setListOfWork(listOfWork);
        }
        else if(qName.equals("publicWork")){
            listOfWork.add(publicWork);
        }
        else if(qName.equals("list")){
            studentDatabase.setStudents(list);
        }
    }

    @Override
    public void characters(char ch[],int start,int length) throws SAXException{
        if(element.equalsIgnoreCase("lastName") && bLastName==true){
            student.getNameObject().setLastName(new String(ch,start,length).trim());
            bLastName=false;
        }
        else if(element.equalsIgnoreCase("firstName") && bFirstName==true){
            student.getNameObject().setFirstName(new String(ch,start,length).trim());
            bFirstName=false;
        }
        else if(element.equals("fatherName") && bFatherName==true){
            student.getNameObject().setFatherName(new String(ch,start,length));
            bFatherName=false;
        }
        else if(element.equals("group") && bGroup==true){
            student.setGroup(new String(ch,start,length).trim());
            bGroup=false;
        }
        else if(element.equals("work") && bWork==true){
            publicWork.setWork(new String(ch,start,length));
            bWork=false;
        }
        else if(element.equals("hours") && bHours==true){
            publicWork.setHours(Integer.parseInt(new String(ch, start, length)));
            bHours=false;
        }
    }

    public void setBase(StudentDatabase studentDatabase){
        this.studentDatabase=studentDatabase;
    }
}
