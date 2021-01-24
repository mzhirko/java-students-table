package Model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class Writer {
    private File file;
    private Document document;
    private StudentDatabase studentDatabase;
    Element listOfWork;

    public void write(File file,StudentDatabase studentDatabase){
            this.file=file;
            this.studentDatabase=studentDatabase;
            try {
                document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
                Element list=document.createElement("list");
                for (int numOfStudent=0;numOfStudent< studentDatabase.getStudents().size();numOfStudent++){
                    Element student=document.createElement("student");
                    student.setAttribute("id",numOfStudent+"");

                    Element name=document.createElement("name");

                    Element lastName=document.createElement("lastName");
                    lastName.setTextContent(studentDatabase.getStudents().get(numOfStudent).getLastName());
                    name.appendChild(lastName);

                    Element firstName=document.createElement("firstName");
                    firstName.setTextContent(studentDatabase.getStudents().get(numOfStudent).getFirstName());
                    name.appendChild(firstName);

                    Element fatherName=document.createElement("fatherName");
                    fatherName.setTextContent(studentDatabase.getStudents().get(numOfStudent).getFatherName());
                    name.appendChild(fatherName);
                    student.appendChild(name);

                    Element group=document.createElement("group");
                    group.setTextContent(studentDatabase.getStudents().get(numOfStudent).getGroup());
                    student.appendChild(group);

                    Element firstSem=document.createElement("firstSem");
                    listOfWork=document.createElement("listOfWork");
                    addSemToFile(studentDatabase.getStudents().get(numOfStudent).getFirstSemList(),firstSem);
                    student.appendChild(firstSem);

                    Element secondSem=document.createElement("secondSem");
                    listOfWork=document.createElement("listOfWork");
                    addSemToFile(studentDatabase.getStudents().get(numOfStudent).getSecondSemList(),secondSem);
                    student.appendChild(secondSem);

                    Element thirdSem=document.createElement("thirdSem");
                    listOfWork=document.createElement("listOfWork");
                    addSemToFile(studentDatabase.getStudents().get(numOfStudent).getThirdSemList(),thirdSem);
                    student.appendChild(thirdSem);

                    Element fourthSem=document.createElement("fourthSem");
                    listOfWork=document.createElement("listOfWork");
                    addSemToFile(studentDatabase.getStudents().get(numOfStudent).getFourthSemList(),fourthSem);
                    student.appendChild(fourthSem);

                    Element fifthSem=document.createElement("fifthSem");
                    listOfWork=document.createElement("listOfWork");
                    addSemToFile(studentDatabase.getStudents().get(numOfStudent).getFifthSemList(),fifthSem);
                    student.appendChild(fifthSem);

                    Element sixthSem=document.createElement("sixthSem");
                    listOfWork=document.createElement("listOfWork");
                    addSemToFile(studentDatabase.getStudents().get(numOfStudent).getSixthSemList(),sixthSem);
                    student.appendChild(sixthSem);

                    Element seventhSem=document.createElement("seventhSem");
                    listOfWork=document.createElement("listOfWork");
                    addSemToFile(studentDatabase.getStudents().get(numOfStudent).getSeventhSemList(),seventhSem);
                    student.appendChild(seventhSem);

                    Element eighthSem=document.createElement("eighthSem");
                    listOfWork=document.createElement("listOfWork");
                    addSemToFile(studentDatabase.getStudents().get(numOfStudent).getEighthSemList(),eighthSem);
                    student.appendChild(eighthSem);

                    Element ninthSem=document.createElement("ninthSem");
                    listOfWork=document.createElement("listOfWork");
                    addSemToFile(studentDatabase.getStudents().get(numOfStudent).getNinthSemList(),ninthSem);
                    student.appendChild(ninthSem);

                    Element tenthSem=document.createElement("tenthSem");
                    listOfWork=document.createElement("listOfWork");
                    addSemToFile(studentDatabase.getStudents().get(numOfStudent).getTenthSemList(),tenthSem);
                    student.appendChild(tenthSem);

                    list.appendChild(student);
                }
                document.appendChild(list);
                Transformer transformer= TransformerFactory.newInstance().newTransformer();
                DOMSource source=new DOMSource(document);
                StreamResult streamResult=new StreamResult(file);
                transformer.transform(source,streamResult);
            }catch (ParserConfigurationException ex){
                String exText=ex.getMessage();
                studentDatabase.getController().alertMessage(exText);
            }catch(TransformerConfigurationException ex){
                String exText=ex.getMessage();
                studentDatabase.getController().alertMessage(exText);
            }
            catch (TransformerException ex){
                String exText=ex.getMessage();
                studentDatabase.getController().alertMessage(exText);
            }
        }

    public void addSemToFile(List<PublicWork> list, Element sem){
        for (int i=0;i<list.size();i++){
            Element publicWork=document.createElement("publicWork");
            publicWork.setAttribute("id",""+i);

            Element work=document.createElement("work");
            work.setTextContent(list.get(i).getWork());
            publicWork.appendChild(work);

            Element hours=document.createElement("hours");
            hours.setTextContent(list.get(i).getHours()+"");
            publicWork.appendChild(hours);

            listOfWork.appendChild(publicWork);
        }
        sem.appendChild(listOfWork);
    }
}
