
public class Cat implements Comparable<Cat> {
   String color;
   double spatialVolume;
   double moewVolume;
   
   public Cat(String color, double spatialVolume, double moewVolume) {
       this.color = color;
       this.spatialVolume=spatialVolume;
       this.moewVolume=moewVolume;
   }
   
   public String toString() {
       return this.color +"cat" + this.spatialVolume +"cubic meter" + this.moewVolume+"fb";
   }
   

@Override
public int compareTo(Cat c) {
    // TODO Auto-generated method stub
    if(this.spatialVolume>c.spatialVolume) {
        return -1;
    }
    else if(this.spatialVolume==c.spatialVolume) {
        return 0;
    }
    else {
        return 1;
    }
}


}
