import java.util.Comparator;

public class CmpByAddress implements Comparator<Person> {
    public int compare(Person a, Person b) {
        return a.getAddress().compareTo(b.getAddress());
    }
}
