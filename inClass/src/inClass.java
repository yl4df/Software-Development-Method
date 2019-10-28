import java.util.HashSet;

public class inClass {

	public HashSet<String> names (HashSet<String> cards, HashSet<String> topNames){
		HashSet<String> nameSet = new HashSet<String>(cards);
		for(String name: topNames) {
			if (!cards.contains(name)) {
				nameSet.add(name);
			}
		}
		return nameSet;
	}
}
