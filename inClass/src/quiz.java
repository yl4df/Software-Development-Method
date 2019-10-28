import java.util.TreeSet;

public class quiz {

	public static void main(String[] args) {
	    TreeSet<Double> treeHeights = new TreeSet<Double>();

	    treeHeights.add(2.3);

	    treeHeights.add(10.0);

	    treeHeights.add(2.3);

	    treeHeights.add(10.0);

	    treeHeights.remove(2.3);

	    treeHeights.add(3.7);
	    
	    System.out.println(treeHeights.toString());
	}

}
