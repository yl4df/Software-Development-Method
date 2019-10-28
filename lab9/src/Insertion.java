
public class Insertion {
  
    public void insertionSort(int arr[]) {
        int n=arr.length;
        
        for ( int i = 1; i<n; i++) {
            int value = arr[i];
            int j = i-1;
            while(j >=0 && arr[j]>value) {
                 arr[j+1]=arr[j];
                 j--;
             }
             arr[j+1]=value;
        }
    }
    
    public static void printIt(int arr[]) {
        int n=arr.length;
        for ( int i = 0; i<n; i++) {
            System.out.print(arr[i]+" ");
            
        }
        
    }
    public static void main(String[] args) {
        int arr[] = {2,5,3,8,17,12};
        Insertion test = new Insertion();
        test.insertionSort(arr);
        printIt(arr);
        
        /**
        System.out.println(Algorithms.algorithm0(10));
        System.out.println(Algorithms.algorithm0(50));
        System.out.println(Algorithms.algorithm0(100));
        System.out.println(Algorithms.algorithm0(150));
        System.out.println(Algorithms.algorithm0(200));
        
        
        System.out.println(Algorithms.algorithm1(10));
        System.out.println(Algorithms.algorithm1(50));
        System.out.println(Algorithms.algorithm1(100));
        System.out.println(Algorithms.algorithm1(150));
        System.out.println(Algorithms.algorithm1(200));
        
        
        System.out.println(Algorithms.algorithm2(10));
        System.out.println(Algorithms.algorithm2(15));
        System.out.println(Algorithms.algorithm2(20));
        System.out.println(Algorithms.algorithm2(22));
        System.out.println(Algorithms.algorithm2(24));
        
        
        System.out.println(Algorithms.algorithm3(10));
        System.out.println(Algorithms.algorithm3(20));
        System.out.println(Algorithms.algorithm3(30));
        System.out.println(Algorithms.algorithm3(40));
        System.out.println(Algorithms.algorithm3(50));
        **/
        System.out.println(Algorithms.algorithm4(10));
        System.out.println(Algorithms.algorithm4(20));
        System.out.println(Algorithms.algorithm4(40));
        System.out.println(Algorithms.algorithm4(70));
        System.out.println(Algorithms.algorithm4(1000));
        
        
    }
}
