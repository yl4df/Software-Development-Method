

public class inClass5{
    public static void main(String[] args) {
        int x[] = new int[3];
        x[0] = 5;
        x[1] = 5;
        x[2] = 5;
        int[] returned = inClass5.changeValue(x);
        inClass5.printArray(returned);
        System.out.print("  ");
        inClass5.printArray(x);
    }
    public static int[] changeValue(int[] value) {
        for (int p = 0; p < value.length; p++) {
            value[p] = 7;
        }
        return value;
    }
    public static void printArray(int[] toPrint) {
        for (int z = 0; z < toPrint.length; z++) {
            System.out.print(toPrint[z] );
            if ( z != toPrint.length-1) {
                System.out.print(",");
            }
        }
    }
}
