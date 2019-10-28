
public class Student extends Person{
    
   double gpa;
   String compusAddress;
   
   public Student() {
       super();
       gpa = 0.0;
       compusAddress="";
   }
   public Student(double gpa, String compusAddress) {
       super();
       this.gpa=gpa;
       this.compusAddress=compusAddress;
   }
@Override
public boolean equals(Object obj) {
    // TODO Auto-generated method stub
    return super.equals(obj);
}
}
