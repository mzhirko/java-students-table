package Model;

public class Name {
    private String lastName;
    private String firstName;
    private String fatherName;

    public Name(){
        firstName="";
        lastName="";
        fatherName="";
    }

    public Name(String lastName,String firstName){
        this.lastName=lastName;
        this.firstName=firstName;
        this.fatherName="";
    }

    public Name(String lastName,String firstName,String fatherName){
        this.lastName=lastName;
        this.firstName=firstName;
        this.fatherName=fatherName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName){
        this.firstName= firstName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
}
