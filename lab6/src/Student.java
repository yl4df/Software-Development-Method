

public class Student extends Person {
     
    double gpa;
    String compusAddress;
    
    public Student() {
        gpa = 0.0;
        compusAddress="";
    }
    
    public Student(double gpa, String compusAddress) {
        this.gpa = gpa;
        this.compusAddress = compusAddress;
    }
    }
    
